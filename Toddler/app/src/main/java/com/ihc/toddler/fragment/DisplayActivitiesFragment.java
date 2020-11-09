package com.ihc.toddler.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ActivityCardAdapter;
import com.ihc.toddler.adapter.BaseCardAdapter;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.ActivitiesStats;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.persistence.ActivityTracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class DisplayActivitiesFragment extends Fragment {

    protected TextToSpeech textToSpeech;
    protected SpeechManager speechManager;
    protected TextView nextTitle, moreTitle, alreadyDoneNumber, alreadyDoneLabel, leftNumber, leftLabel;
    protected SwitchCompat alreadyConsumedSwitch;
    private RecyclerView moreActivitiesView, nextActivityView;

    private boolean considerConsumed = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moreActivitiesView = view.findViewById(R.id.more_activities_view);
        nextActivityView = view.findViewById(R.id.next_activity_view);

        nextTitle = view.findViewById(R.id.next_activities_title);
        moreTitle = view.findViewById(R.id.more_activities_title);

        alreadyDoneNumber = view.findViewById(R.id.already_gone_number);
        alreadyDoneLabel = view.findViewById(R.id.already_gone_type);
        leftNumber = view.findViewById(R.id.left_number);
        leftLabel = view.findViewById(R.id.left_type);

        alreadyConsumedSwitch = view.findViewById(R.id.consumed_switch);

        setTitles(nextTitle, moreTitle);
        alreadyDoneLabel.setText(getLabel());
        leftLabel.setText(getLabel());
        alreadyConsumedSwitch.setText(getSwitchText());

        textToSpeech = new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(new Locale("pt", "BR"));
            }
        });

        speechManager = new SpeechManager(textToSpeech);

        alreadyConsumedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                considerConsumed = isChecked;
                populateCardView(considerConsumed);
            }
        });

        textToSpeech.setSpeechRate(0.8f);
    }

    @Override
    public void onResume() {
        super.onResume();
        populateCardView(considerConsumed);
        ActivitiesStats stats = getStats();
        alreadyDoneNumber.setText(String.valueOf(stats.getNumberOfConsumedActivities()));
        leftNumber.setText(String.valueOf(stats.getTotalNumberOfActivities() - stats.getNumberOfConsumedActivities()));

        speechManager.readWithNormalClick(alreadyDoneNumber, getAlreadyDoneTextToSpeak(stats.getNumberOfConsumedActivities()));
        speechManager.readWithNormalClick(leftNumber, getLeftTextToSpeak(stats.getTotalNumberOfActivities() - stats.getNumberOfConsumedActivities()));
        speechManager.readWithNormalClick(nextTitle);
        speechManager.readWithNormalClick(moreTitle);
        speechManager.readWithLongClick(alreadyConsumedSwitch, getSwitchText());
    }

    protected abstract List<AbstractActivity> getActivities();

    private void populateCardView(boolean considerConsumed) {
        List<AbstractActivity> activities = considerConsumed ? getSortedActivities() : getAvailableSortedActivities();
        AbstractActivity first = activities.get(0);
        List<AbstractActivity> others = activities.subList(1, activities.size());

        BaseCardAdapter moreActivitiesCardAdapter = new BaseCardAdapter(others, getActivity(), textToSpeech);
        ActivityCardAdapter nextActivityCardAdapter = new ActivityCardAdapter(Collections.singletonList(first), getActivity(), textToSpeech, true);

        RecyclerView.LayoutManager moreActivitiesManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager nextActivityManager = new GridLayoutManager(getActivity(), 1);

        moreActivitiesView.setLayoutManager(moreActivitiesManager);
        moreActivitiesView.setAdapter(moreActivitiesCardAdapter);

        nextActivityView.setLayoutManager(nextActivityManager);
        nextActivityView.setAdapter(nextActivityCardAdapter);
    }

    protected abstract void setTitles(TextView next, TextView more);
    protected abstract String getLabel();
    protected abstract ActivitiesStats getStats();
    protected abstract String getSwitchText();
    protected abstract String getAlreadyDoneTextToSpeak(int num);
    protected abstract String getLeftTextToSpeak(int num);

    private AbstractActivity getFirstAvailableActivity() {
        List<AbstractActivity> activities = getActivities();
        for (AbstractActivity activity : activities)
            if (!ActivityTracker.getInstance().isActivityConsumed(activity)) return activity;
        return null;
    }

    private List<AbstractActivity> getSortedActivities() {
        AbstractActivity firstAvailableActivity = getFirstAvailableActivity();
        if (firstAvailableActivity == null)
            return getActivities();

        List<AbstractActivity> sortedActivities = new ArrayList<>();
        sortedActivities.add(firstAvailableActivity);
        for (AbstractActivity activity : getActivities())
            if (activity.getId() != firstAvailableActivity.getId())
                sortedActivities.add(activity);
        return sortedActivities;
    }


    private List<AbstractActivity> getAvailableSortedActivities() {
        List<AbstractActivity> sortedActivities = new ArrayList<>();
        for (AbstractActivity activity : getActivities())
            if (!ActivityTracker.getInstance().isActivityConsumed(activity))
                sortedActivities.add(activity);
        if (sortedActivities.size() == 0) return getActivities();
        return sortedActivities;
    }

}