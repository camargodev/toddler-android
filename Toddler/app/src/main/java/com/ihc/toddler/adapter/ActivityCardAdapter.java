package com.ihc.toddler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Quiz;

import java.util.List;
import java.util.Random;

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
                .inflate(R.layout.student_list_row, viewGroup, false);
        return new ActivityViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        AbstractActivity activity = activities.get(position);
        holder.parent.setBackgroundColor(ContextCompat.getColor(originScreen, getRandomColorId()));
        holder.title.setText(activity.getTitle());
        holder.type.setText((activity instanceof Quiz) ? "Quiz" : "Conteudo");

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView title, type;
        LinearLayout parent;
        public ActivityViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            title = itemView.findViewById(R.id.activity_title);
            type = itemView.findViewById(R.id.activity_type);
        }
    }
}