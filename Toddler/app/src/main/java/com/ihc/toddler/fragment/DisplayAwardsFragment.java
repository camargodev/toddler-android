package com.ihc.toddler.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class DisplayAwardsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.awards_display_activity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAwardsPerTier(view, R.id.silver_awards_recycler_view, AwardTier.SILVER);
        setAwardsPerTier(view, R.id.gold_awards_recycler_view, AwardTier.GOLD);
        setAwardsPerTier(view, R.id.diamond_awards_recycler_view, AwardTier.DIAMOND);
        setAwardsPerTier(view, R.id.ultimate_awards_recycler_view, AwardTier.ULTIMATE);
    }

    private void setAwardsPerTier(@NonNull View view, int id, AwardTier tier) {
        RecyclerView recyclerView = view.findViewById(id);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(view.getContext(), AwardRepository.getByTier(tier));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

}