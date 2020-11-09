package com.ihc.toddler.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.SpeechManager;

import java.util.List;

public class AwardDescriptionCardAdapter extends RecyclerView.Adapter<AwardDescriptionCardAdapter.AwardViewHolder> {

    Award award;
    Context originScreen;
    SpeechManager speechManager;

    public AwardDescriptionCardAdapter(Context originScreen, Award award, TextToSpeech textToSpeech) {
        this.award = award;
        this.originScreen = originScreen;
        this.speechManager = new SpeechManager(textToSpeech);
    }

    @NonNull
    @Override
    public AwardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_award_description_list_row, viewGroup, false);
        return new AwardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AwardViewHolder holder, int position) {
        holder.awardTitle.setText(award.getTitle());
        holder.description.setText(award.getDescription());
        holder.awardIcon.setBackgroundResource(award.getAwardTier().getAchievedIconId());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView awardTitle, description;
        ImageView awardIcon;
        ConstraintLayout background;
        public AwardViewHolder(View itemView) {
            super(itemView);
            awardTitle = itemView.findViewById(R.id.award_title);
            description = itemView.findViewById(R.id.award_description);
            awardIcon = itemView.findViewById(R.id.award_logo);
            background = itemView.findViewById(R.id.award_background);

            speechManager.readWithNormalClick(itemView, award.getDescription());
        }
    }
}