package com.ihc.toddler.view;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.MultipleChoiceExercise;

import java.util.List;

public class MultipleChoiceView implements ExerciseView {

    private MultipleChoiceExercise exercise;

    public MultipleChoiceView(MultipleChoiceExercise exercise) {
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
    public void mapAnswers(List<Button> buttons) throws Exception {
        if (buttons.size() != exercise.getAnswers().size())
            throw new Exception("Cannot map answers to screen");
        for (int i = 0; i < buttons.size(); i++)
            buttons.get(i).setText(exercise.getAnswers().get(i));
    }
}
