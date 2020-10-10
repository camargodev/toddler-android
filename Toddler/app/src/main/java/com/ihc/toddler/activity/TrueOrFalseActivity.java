package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihc.toddler.R;

import java.util.Arrays;

public class TrueOrFalseActivity extends GenericExerciseActivity {

    private Button trueButton, falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(trueButton, falseButton));
    }

    public void answerA(View view) {
        submitAnswer(trueButton, 1);
    }

    public void answerB(View view) { submitAnswer(falseButton, 2); }

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
}