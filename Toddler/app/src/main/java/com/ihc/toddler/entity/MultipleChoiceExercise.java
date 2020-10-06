package com.ihc.toddler.entity;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MultipleChoiceExercise extends Exercise {

    public MultipleChoiceExercise(String question, List<String> answers) {
        super(question, 4, answers);
    }

    @Override
    public void display(TextView questionTextView, List<Button> answerButtons) {
        questionTextView.setText(question);
        for (int i = 0; i < numberOfAnswers; i++)
            answerButtons.get(i).setText(answers.get(i));
    }

}
