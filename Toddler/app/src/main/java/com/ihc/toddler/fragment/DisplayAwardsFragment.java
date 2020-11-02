package com.ihc.toddler.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.entity.AwardTier;
import com.ihc.toddler.repository.AwardRepository;

public class DisplayAwardsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.awards_display_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAwardsPerTier(view, R.id.bronze_awards_recycler_view, AwardTier.BRONZE);
        setAwardsPerTier(view, R.id.silver_awards_recycler_view, AwardTier.SILVER);
        setAwardsPerTier(view, R.id.gold_awards_recycler_view, AwardTier.GOLD);
        setAwardsPerTier(view, R.id.diamond_awards_recycler_view, AwardTier.DIAMOND);
    }

    private void setAwardsPerTier(@NonNull View view, int id, AwardTier tier) {
        RecyclerView recyclerView = view.findViewById(id);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(view.getContext(), AwardRepository.getByTier(tier));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

}