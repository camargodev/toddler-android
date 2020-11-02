package com.ihc.toddler.fragment;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ActivityCardAdapter;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DisplayActivitiesFragment extends Fragment {

    protected TextToSpeech textToSpeech;
    private RecyclerView moreActivitiesView, nextActivityView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activies_display_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moreActivitiesView = view.findViewById(R.id.more_activities_view);
        nextActivityView = view.findViewById(R.id.next_activity_view);

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

        List<AbstractActivity> activities = populateActivities();

        ActivityCardAdapter moreActivitiesCardAdapter = new ActivityCardAdapter(activities, getActivity(), textToSpeech);
        ActivityCardAdapter nextActivityCardAdapter = new ActivityCardAdapter(Collections.singletonList(activities.get(0)), getActivity(), textToSpeech);

        RecyclerView.LayoutManager moreActivitiesManager = new GridLayoutManager(getActivity(), 2);
        RecyclerView.LayoutManager nextActivityManager = new GridLayoutManager(getActivity(), 1);

        moreActivitiesView.setLayoutManager(moreActivitiesManager);
        moreActivitiesView.setAdapter(moreActivitiesCardAdapter);

        nextActivityView.setLayoutManager(nextActivityManager);
        nextActivityView.setAdapter(nextActivityCardAdapter);
    }

    private List<AbstractActivity> populateActivities() {
        List<Content> contents = ContentRepository.getContents();
        List<Quiz> quizes = QuizRepository.getQuizes();
        List<AbstractActivity> activities = new ArrayList<>();
        activities.addAll(contents);
        activities.addAll(quizes);
        return activities;
    }
}