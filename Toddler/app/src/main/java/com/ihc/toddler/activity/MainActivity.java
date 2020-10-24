package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ActivityCardAdapter;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;

public class MainActivity extends AppCompatActivity {
    protected TextToSpeech textToSpeech;

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(new Locale("pt", "BR"));
            }
        });
        textToSpeech.setSpeechRate(0.8f);


        List<AbstractActivity> activities = populateActivities();
        ActivityCardAdapter activityCardAdapter = new ActivityCardAdapter(activities, this, textToSpeech);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    private List<AbstractActivity>  populateActivities() {
        List<AbstractActivity> activities = new ArrayList<>();
        AbstractActivity quiz = QuizRepository.getQuiz();
        AbstractActivity content = ContentRepository.getContent();
        int contentCounter = 1, quizCounter = 1;
        content.setId(contentCounter++);
        activities.add(content);
        for (int i = 0; i < 5; i ++) {
            int random = new Random().nextInt(10);
            if (random % 2 == 0) {
                AbstractActivity cloneQuiz = quiz.clone();
                cloneQuiz.setId(quizCounter++);
                activities.add(cloneQuiz);
            } else {
                AbstractActivity cloneContent = content.clone();
                cloneContent.setId(contentCounter++);
                activities.add(cloneContent);
            }
        }
        quiz.setId(quizCounter);
        activities.add(quiz);
        return activities;
    }
}