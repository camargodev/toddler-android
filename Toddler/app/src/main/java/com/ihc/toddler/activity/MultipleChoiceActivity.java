package com.ihc.toddler.activity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;

import com.ihc.toddler.R;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.ihc.toddler.entity.MultipleChoiceExercise.A;
import static com.ihc.toddler.entity.MultipleChoiceExercise.B;
import static com.ihc.toddler.entity.MultipleChoiceExercise.C;
import static com.ihc.toddler.entity.MultipleChoiceExercise.D;

public class MultipleChoiceActivity extends GenericExerciseActivity {

    private Button answerA, answerB, answerC, answerD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(answerA, answerB, answerC, answerD));

        speechManager.readWithLongClick(answerA);
        speechManager.readWithLongClick(answerB);
        speechManager.readWithLongClick(answerC);
        speechManager.readWithLongClick(answerD);
    }

    public void answerA(View view) {
        submitAnswer(answerA, A);
    }

    public void answerB(View view) {
        submitAnswer(answerB, B);
    }

    public void answerC(View view) { submitAnswer(answerC, C); }

    public void answerD(View view) { submitAnswer(answerD, D); }

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
        clearAnswerButton(answerA);
        clearAnswerButton(answerB);
        clearAnswerButton(answerC);
        clearAnswerButton(answerD);
    }

    @Override
    protected void markButtonExercise(int answer) {
        switch (answer) {
            case A: markAsAnswered(answerA); break;
            case B: markAsAnswered(answerB); break;
            case C: markAsAnswered(answerC); break;
            case D: markAsAnswered(answerD); break;
        }
    }
}