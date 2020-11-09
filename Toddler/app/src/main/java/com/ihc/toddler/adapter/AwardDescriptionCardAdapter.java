package com.ihc.toddler.adapter;

import android.content.Context;
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

import java.util.List;

public class AwardDescriptionCardAdapter extends RecyclerView.Adapter<AwardDescriptionCardAdapter.AwardViewHolder> {

    Award award;
    Context originScreen;

    public AwardDescriptionCardAdapter(Context originScreen, Award award) {
        this.award = award;
        this.originScreen = originScreen;
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

    static class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView awardTitle, description;
        ImageView awardIcon;
        ConstraintLayout background;
        public AwardViewHolder(View itemView) {
            super(itemView);
            awardTitle = itemView.findViewById(R.id.award_title);
            description = itemView.findViewById(R.id.award_description);
            awardIcon = itemView.findViewById(R.id.award_logo);
            background = itemView.findViewById(R.id.award_background);
        }
    }
}