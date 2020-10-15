package com.ihc.toddler.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Quiz;

import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class ActivityCardAdapter extends RecyclerView.Adapter<ActivityCardAdapter.ActivityViewHolder> {

    List<AbstractActivity> activities;
    Context originScreen;

    public ActivityCardAdapter(List<AbstractActivity> activities, Context originScreen) {
        this.activities = activities;
        this.originScreen = originScreen;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_activity_list_row, viewGroup, false);
        return new ActivityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        AbstractActivity activity = activities.get(position);
        int color = ContextCompat.getColor(originScreen, getRandomColorId());
        holder.topPart.setBackgroundColor(color);
        holder.title.setText(activity.getTitle());
        holder.title.setTextColor(color);
        if (activity instanceof Quiz)
            holder.icon.setBackgroundResource(R.drawable.homework);

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        LinearLayout parent, topPart;
        ImageView icon;
        public ActivityViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            topPart = itemView.findViewById(R.id.top_part);
            title = itemView.findViewById(R.id.activity_title);
            icon = itemView.findViewById(R.id.small_logo);
        }
    }
}