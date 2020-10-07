package com.ihc.toddler.view;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.TrueOrFalseExercise;

import java.util.List;

public class TrueOrFalseView implements ExerciseView {

    private TrueOrFalseExercise exercise;

    public TrueOrFalseView(TrueOrFalseExercise exercise) {
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
    public void mapAnswers(List<Button> buttons) throws Exception {
        if (buttons.size() != exercise.getAnswers().size())
            throw new Exception("Cannot map answers to screen");
        if (buttons.size() != 2)
            throw new Exception("Should only have two answers in true or false");
        for (int i = 0; i < buttons.size(); i++)
            buttons.get(i).setText(exercise.getAnswers().get(i));
    }
}
