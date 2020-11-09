package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.activity.GenericExerciseActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.persistence.ActivityTracker;

public class QuizUnfinishedEndDialog extends Dialog implements View.OnClickListener {

    public QuizUnfinishedEndDialog(@NonNull GenericExerciseActivity activity) {
        super(activity);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.quiz_unfinished_end_dialog);

        Button goNext = findViewById(R.id.go_back);

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {}
}
