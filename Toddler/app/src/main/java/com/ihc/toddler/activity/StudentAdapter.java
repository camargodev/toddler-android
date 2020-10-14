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

import java.util.List;
import java.util.Random;

class StudentAdapter extends RecyclerView.Adapter {

    List<studentData> studentDataList;

    public StudentAdapter(List<studentData> studentDataList) {
        this.studentDataList=studentDataList;
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
        studentData data = studentDataList.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        Random rnd = new Random();
        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        myViewHolder.parent.setBackgroundColor(currentColor);
        myViewHolder.name.setText(data.name);
        myViewHolder.age.setText(String.valueOf(data.age));

    }

//    @Override
//    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
//        studentData data=studentDataList.get(i);
//        Random rnd = new Random();
//        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        viewHolder.parent.setBackgroundColor(currentColor);
//        viewHolder.name.setText(data.name);
//        viewHolder.age.setText(String.valueOf(data.age));
//    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
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