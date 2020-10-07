package com.ihc.toddler.entity;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TrueOrFalseExercise extends Exercise {

    public TrueOrFalseExercise(String question) {
        super(question, 2, Arrays.asList("True", "False"));
    }

    @Override
    public void display(TextView questionTextView, List<Button> answerButtons) {
        questionTextView.setText(question);
        for (int i = 0; i < numberOfAnswers; i++)
            answerButtons.get(i).setText(answers.get(i));
    }

    @Override
    public int getLayoutId() {
        return R.layout.true_or_false_activity;
    }
}
