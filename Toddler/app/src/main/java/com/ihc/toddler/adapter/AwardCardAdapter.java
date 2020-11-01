package com.ihc.toddler.adapter;

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
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.repository.QuizRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class AwardCardAdapter extends RecyclerView.Adapter<AwardCardAdapter.AwardViewHolder> {

    List<Award> awards;

    public AwardCardAdapter(List<Award> awards) {
        this.awards = awards;
    }

    @NonNull
    @Override
    public AwardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_award_list_row, viewGroup, false);
        return new AwardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AwardViewHolder holder, int position) {
        Award award = awards.get(position);
        holder.awardTitle.setText(award.getDescription());
    }

    @Override
    public int getItemCount() {
        return awards.size();
    }

    static class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView awardTitle;
        public AwardViewHolder(View itemView) {
            super(itemView);
            awardTitle = itemView.findViewById(R.id.award_title);
        }
    }
}