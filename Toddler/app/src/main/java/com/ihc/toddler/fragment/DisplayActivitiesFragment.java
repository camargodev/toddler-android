package com.ihc.toddler.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ActivityCardAdapter;
import com.ihc.toddler.adapter.BaseCardAdapter;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.ActivitiesStats;
import com.ihc.toddler.entity.ActivityType;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class DisplayActivitiesFragment extends Fragment {

    protected TextToSpeech textToSpeech;
    protected TextView nextTitle, moreTitle, alreadyDoneNumber, alreadyDoneLabel, leftNumber, leftLabel;
    private RecyclerView moreActivitiesView, nextActivityView;

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

        setTitles(nextTitle, moreTitle);
        alreadyDoneLabel.setText(getLabel());
        leftLabel.setText(getLabel());

        ActivitiesStats stats = getStats();
        alreadyDoneNumber.setText(String.valueOf(stats.getNumberOfConsumesActivities()));
        leftNumber.setText(String.valueOf(stats.getTotalNumberOfActivities() - stats.getNumberOfConsumesActivities()));

        textToSpeech = new TextToSpeech(view.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(new Locale("pt", "BR"));
            }
        });

        textToSpeech.setSpeechRate(0.8f);
    }

    @Override
    public void onResume() {
        super.onResume();
        populateCardView();
    }

    protected abstract List<AbstractActivity> getActivities();

    private void populateCardView() {
        List<AbstractActivity> activities = getSortedActivities();
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

    private List<AbstractActivity> getSortedActivities() {
        List<AbstractActivity> sortedActivities = new ArrayList<>();
        List<AbstractActivity> activities = getActivities();
        for (AbstractActivity activity : activities)
            if (!ActivityTracker.getInstance().isActivityConsumed(activity))
                sortedActivities.add(activity);
        for (AbstractActivity activity : activities)
            if (ActivityTracker.getInstance().isActivityConsumed(activity))
                sortedActivities.add(activity);
        return sortedActivities;
    }
}