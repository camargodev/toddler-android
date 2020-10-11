package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihc.toddler.R;

import java.util.Arrays;

public class TrueOrFalseActivity extends GenericExerciseActivity {

    private Button trueButton, falseButton;

    private static final int TRUE = 1, FALSE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(trueButton, falseButton));
    }

    public void answerA(View view) {
        submitAnswer(trueButton, TRUE);
    }

    public void answerB(View view) { submitAnswer(falseButton, FALSE); }

    public void readQuestion(View view) {
        super.readQuestion();
    }

    public void next(View view) { goToNext(); }

    public void previous(View view) { goToPrevious(); }

    @Override
    protected void mapLayout() {
        super.mapLayout();
        trueButton = findViewById(R.id.ans_true);
        falseButton = findViewById(R.id.ans_false);
    }

    @Override
    protected void clearAnswerButtons() {
        clearAnswerButton(trueButton);
        clearAnswerButton(falseButton);
    }

    @Override
    protected void markButtonExercise(int answer) {
        switch (answer) {
            case TRUE: markAsAnswered(trueButton); break;
            case FALSE: markAsAnswered(falseButton); break;
        }
    }
}