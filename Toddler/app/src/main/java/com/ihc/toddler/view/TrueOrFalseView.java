package com.ihc.toddler.view;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MultipleChoiceActivity;
import com.ihc.toddler.activity.TrueOrFalseActivity;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.TrueOrFalseExercise;

import java.util.List;

public class TrueOrFalseView implements ExerciseView {

    private Exercise exercise;

    public TrueOrFalseView(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public int getLayoutId() {
        return R.layout.true_or_false_activity;
    }

    @Override
    public void mapQuestion(TextView textView) {
        textView.setText(exercise.getQuestion());
    }

    @Override
    public void mapAnswers(List<Button> buttons) {
        for (int i = 0; i < buttons.size(); i++)
            buttons.get(i).setText(exercise.getAnswers().get(i));
    }

    @Override
    public Intent getIntent(Context context) {
        return new Intent(context, TrueOrFalseActivity.class);
    }
}
