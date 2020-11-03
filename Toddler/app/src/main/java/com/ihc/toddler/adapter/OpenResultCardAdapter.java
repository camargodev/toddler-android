package com.ihc.toddler.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.DisplayResultsActivity;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.ExerciseStatus;
import com.ihc.toddler.manager.AwardManager;

import java.util.List;

public class OpenResultCardAdapter extends RecyclerView.Adapter<OpenResultCardAdapter.OpenResultViewHolder> {

    Exercise openExercise;
    DisplayResultsActivity originScreen;

    public OpenResultCardAdapter(DisplayResultsActivity originScreen) {
        this.originScreen = originScreen;
    }

    public void setOpenExercise(Exercise openExercise) {
        this.openExercise = openExercise;
    }

    @NonNull
    @Override
    public OpenResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_open_result, viewGroup, false);
        return new OpenResultViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenResultViewHolder holder, int position) {
        if (openExercise == null) return;

        originScreen.getOpenResultView().setVisibility(View.VISIBLE);

        holder.exerciseQuestion.setText(openExercise.getQuestion());

        if (openExercise.getStatus() == ExerciseStatus.CORRECT) {
            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.correct));
            holder.icon.setBackgroundResource(R.drawable.correct);
            holder.exerciseDescription.setText("Voce acertou");
        } else {
            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.wrong));
            holder.icon.setBackgroundResource(R.drawable.wrong);
            holder.exerciseDescription.setText("Voce errou");
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static class OpenResultViewHolder extends RecyclerView.ViewHolder {
        TextView exerciseQuestion, exerciseDescription;
        ImageView icon;
        RelativeLayout background;
        public OpenResultViewHolder(View itemView) {
            super(itemView);
            exerciseQuestion = itemView.findViewById(R.id.exercise_question);
            exerciseDescription = itemView.findViewById(R.id.result_description);
            icon = itemView.findViewById(R.id.small_emoticon_bg);
            background = itemView.findViewById(R.id.colorful_background);
        }
    }
}