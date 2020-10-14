package com.ihc.toddler.activity;

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
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;

import java.util.List;
import java.util.Random;

class ActivityCardAdapter extends RecyclerView.Adapter {

    List<AbstractActivity> activities;

    public ActivityCardAdapter(List<AbstractActivity> activities) {
        this.activities = activities;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.student_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AbstractActivity activity = activities.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        myViewHolder.parent.setBackgroundColor(currentColor);
        myViewHolder.name.setText(activity.getTitle());
        myViewHolder.age.setText((activity instanceof Quiz) ? "Quiz" : "Conteudo");

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,age;
        LinearLayout parent;
        public MyViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
        }
    }
}