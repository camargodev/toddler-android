package com.ihc.toddler.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class DisplayActivitiesFragment extends Fragment {

    protected TextToSpeech textToSpeech;
    private static List<AbstractActivity> activities;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activies_display_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);

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

        activities = populateActivities();

        ActivityCardAdapter activityCardAdapter = new ActivityCardAdapter(activities, getActivity(), textToSpeech);

        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
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