package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.TrueOrFalseExercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Arrays;

public class TrueOrFalseActivity extends GenericExerciseActivity {

    private Button trueButton, falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(trueButton, falseButton));
    }

    public void answerA(View view) {
        submitAndGoToNext(1);
    }

    public void answerB(View view) { submitAndGoToNext(2); }

    @Override
    protected void mapLayout() {
        super.mapLayout();
        trueButton = findViewById(R.id.ans_true);
        falseButton = findViewById(R.id.ans_false);
    }
}