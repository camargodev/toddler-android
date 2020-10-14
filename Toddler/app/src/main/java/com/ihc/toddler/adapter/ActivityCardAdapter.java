package com.ihc.toddler.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Quiz;

import java.util.List;
import java.util.Random;

public class ActivityCardAdapter extends RecyclerView.Adapter<ActivityCardAdapter.ActivityViewHolder> {

    List<AbstractActivity> activities;

    public ActivityCardAdapter(List<AbstractActivity> activities) {
        this.activities = activities;
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
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.parent.setBackgroundColor(currentColor);
        holder.name.setText(activity.getTitle());
        holder.age.setText((activity instanceof Quiz) ? "Quiz" : "Conteudo");

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        LinearLayout parent;
        public ActivityViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.activity_title);
            age = itemView.findViewById(R.id.activity_type);
        }
    }
}