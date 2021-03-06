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
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.dialog.AwardDescriptionDialog;
import com.ihc.toddler.dialog.ContentEndDialog;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.repository.AwardRepository;
import com.ihc.toddler.repository.QuizRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class AwardCardAdapter extends RecyclerView.Adapter<AwardCardAdapter.AwardViewHolder> {

    List<Award> awards;
    Context originScreen;
    TextToSpeech textToSpeech;

    public AwardCardAdapter(Context originScreen, List<Award> awards, TextToSpeech textToSpeech) {
        this.awards = awards;
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
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
        holder.awardTitle.setText(award.getTitle());
//        int color = ContextCompat.getColor(originScreen, R.color.gray);
        if (AwardManager.getInstance().isAwardAccomplished(award.getId())) {
//            color = ContextCompat.getColor(originScreen, getRandomColorId());
            holder.awardIcon.setBackgroundResource(award.getAwardTier().getAchievedIconId());
        } else {
            holder.awardIcon.setBackgroundResource(award.getAwardTier().getNotAchievedIconId());
            holder.awardIcon.setBackgroundTintList(AppCompatResources.getColorStateList(originScreen, R.color.gray));
        }
//        holder.background.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return awards.size();
    }

    class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView awardTitle;
        ImageView awardIcon;
        ConstraintLayout background;
        public AwardViewHolder(View itemView) {
            super(itemView);
            awardTitle = itemView.findViewById(R.id.award_title);
            awardIcon = itemView.findViewById(R.id.award_logo);
            background = itemView.findViewById(R.id.award_background);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AwardDescriptionDialog dialog = new AwardDescriptionDialog(originScreen, awards.get(getAdapterPosition()), textToSpeech);
                    dialog.show();
                }
            });
        }
    }
}