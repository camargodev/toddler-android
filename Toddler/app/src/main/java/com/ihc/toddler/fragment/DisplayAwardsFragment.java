package com.ihc.toddler.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.AwardTier;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.repository.AwardRepository;

import java.util.ArrayList;
import java.util.List;

public class DisplayAwardsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView noAwardsText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.awards_display_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.your_awards_view);
        noAwardsText = view.findViewById(R.id.no_awards);

        RecyclerView.LayoutManager manager = new GridLayoutManager(view.getContext(), 3);
        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(view.getContext(), getMyAwards());

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    private List<Award> getMyAwards() {
        List<Award> myAwards = new ArrayList<>();
        List<Award> allAwards = new ArrayList<>();
        allAwards.addAll(AwardRepository.getByTier(AwardTier.DIAMOND));
        allAwards.addAll(AwardRepository.getByTier(AwardTier.GOLD));
        allAwards.addAll(AwardRepository.getByTier(AwardTier.SILVER));
        allAwards.addAll(AwardRepository.getByTier(AwardTier.BRONZE));
        for (Award award : allAwards)
            if (AwardManager.getInstance().isAwardAccomplished(award.getId()))
                myAwards.add(award);
        return myAwards;
    }

    private void updateScreenAccordingToAwards(List<Award> awards) {
        if (awards.size() == 0) {
            recyclerView.setVisibility(View.GONE);
            noAwardsText.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            noAwardsText.setVisibility(View.GONE);
        }
    }

    private void setAwardsPerTier(@NonNull View view, int id, AwardTier tier) {
        RecyclerView recyclerView = view.findViewById(id);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(view.getContext(), AwardRepository.getByTier(tier));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

}