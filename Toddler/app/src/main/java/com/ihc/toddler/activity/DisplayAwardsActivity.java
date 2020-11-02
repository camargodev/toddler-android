package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.AwardTier;
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
        setAwardsPerTier(R.id.silver_awards_recycler_view, AwardTier.SILVER);
        setAwardsPerTier(R.id.gold_awards_recycler_view, AwardTier.GOLD);
        setAwardsPerTier(R.id.diamond_awards_recycler_view, AwardTier.DIAMOND);
        setAwardsPerTier(R.id.ultimate_awards_recycler_view, AwardTier.ULTIMATE);
    }

    private void setAwardsPerTier(int id, AwardTier tier) {
        RecyclerView recyclerView = findViewById(id);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(this, AwardRepository.getByTier(tier));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }


}