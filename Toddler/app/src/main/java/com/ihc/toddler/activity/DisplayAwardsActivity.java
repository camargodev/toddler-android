package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.repository.AwardRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

public class DisplayAwardsActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awards_display_activity);

        RecyclerView recyclerView = findViewById(R.id.awards_recycler_view);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(this);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }
}