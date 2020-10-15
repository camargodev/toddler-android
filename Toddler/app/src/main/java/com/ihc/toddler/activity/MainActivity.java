package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ActivityCardAdapter;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;
import android.annotation.TargetApi;
import android.os.Build;

public class MainActivity extends AppCompatActivity {
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();


        List<AbstractActivity> activities = populateAcitivies();
        ActivityCardAdapter activityCardAdapter = new ActivityCardAdapter(activities, this);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    private List<AbstractActivity>  populateAcitivies() {
        List<AbstractActivity> activities = new ArrayList<>();
        AbstractActivity quiz = QuizRepository.getQuiz();
        AbstractActivity content = ContentRepository.getContent();
        for (int i = 0; i < 7; i ++) {
            activities.add(quiz);
            activities.add(content);
        }
        return activities;
    }
}