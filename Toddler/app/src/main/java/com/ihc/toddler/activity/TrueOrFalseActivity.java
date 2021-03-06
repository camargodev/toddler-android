package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihc.toddler.R;

import java.util.Arrays;

import static com.ihc.toddler.entity.TrueOrFalseExercise.FALSE;
import static com.ihc.toddler.entity.TrueOrFalseExercise.TRUE;

public class TrueOrFalseActivity extends GenericExerciseActivity {

    private Button trueButton, falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(trueButton, falseButton));

        speechManager.readWithLongClick(trueButton);
        speechManager.readWithLongClick(falseButton);
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