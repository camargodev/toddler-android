package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihc.toddler.R;

import java.util.Arrays;

public class MultipleChoiceActivity extends GenericExerciseActivity {

    private Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(answerA, answerB, answerC, answerD));
    }

    public void answerA(View view) {
        submitAnswer(answerA, 1);
    }

    public void answerB(View view) {
        submitAnswer(answerB, 2);
    }

    public void answerC(View view) { submitAnswer(answerC, 3); }

    public void answerD(View view) { submitAnswer(answerD, 4); }

    public void readQuestion(View view) {
        super.readQuestion();
    }

    public void next(View view) { goToNext(); }

    public void previous(View view) { goToPrevious(); }

    @Override
    protected void mapLayout() {
        super.mapLayout();
        answerA = findViewById(R.id.ans_a);
        answerB = findViewById(R.id.ans_b);
        answerC = findViewById(R.id.ans_c);
        answerD = findViewById(R.id.ans_d);
    }

    @Override
    protected void clearAnswerButtons() {
        answerA.setBackgroundResource(android.R.drawable.btn_default);
        answerB.setBackgroundResource(android.R.drawable.btn_default);
        answerC.setBackgroundResource(android.R.drawable.btn_default);
        answerD.setBackgroundResource(android.R.drawable.btn_default);
    }
}