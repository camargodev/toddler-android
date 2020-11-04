package com.ihc.toddler.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class BaseCardAdapter extends RecyclerView.Adapter<BaseCardAdapter.ActivityViewHolder> {

    List<List<AbstractActivity>> groups;
    Context originScreen;
    TextToSpeech textToSpeech;

    public BaseCardAdapter(List<AbstractActivity> activities, Context originScreen, TextToSpeech textToSpeech) {
        this.groups = buildActivitiesGroups(activities);
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_blank_list_row, viewGroup, false);
        return new ActivityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {

        ActivityCardAdapter groupActivitiesCardAdapter = new ActivityCardAdapter(groups.get(position), originScreen, textToSpeech);
        RecyclerView.LayoutManager groupActivitiesManager = new GridLayoutManager(originScreen, 2);

        holder.cardGroup.setLayoutManager(groupActivitiesManager);
        holder.cardGroup.setAdapter(groupActivitiesCardAdapter);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    private List<List<AbstractActivity>> buildActivitiesGroups(List<AbstractActivity> activities) {
        final int NUMBER_PER_GROUP = 4;
        int remaining = activities.size();
        List<List<AbstractActivity>> groups = new ArrayList<>();
        while (remaining >= NUMBER_PER_GROUP) {
            List<AbstractActivity> group = new ArrayList<>();
            for (int i = 0; i < NUMBER_PER_GROUP; i++) {
                group.add(activities.get(0));
                activities.remove(0);
            }
            groups.add(group);
            remaining -= NUMBER_PER_GROUP;
        }
        if (remaining > 0) {
            List<AbstractActivity> lastGroup = new ArrayList<>();
            for (int i = 0; i < remaining; i++) {
                lastGroup.add(activities.get(0));
                activities.remove(0);
            }
            groups.add(lastGroup);
        }

        return groups;
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        RecyclerView cardGroup;
        public ActivityViewHolder(View itemView) {
            super(itemView);
            cardGroup = itemView.findViewById(R.id.card_group);
        }
    }
}