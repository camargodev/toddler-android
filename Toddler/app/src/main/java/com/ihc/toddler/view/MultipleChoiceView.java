package com.ihc.toddler.view;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MultipleChoiceActivity;
import com.ihc.toddler.entity.Exercise;

import java.util.List;

public class MultipleChoiceView implements ExerciseView {

    private Exercise exercise;

    public MultipleChoiceView(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public int getLayoutId() {
        return R.layout.multiple_choice_activity;
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
        return new Intent(context, MultipleChoiceActivity.class);
    }
}
