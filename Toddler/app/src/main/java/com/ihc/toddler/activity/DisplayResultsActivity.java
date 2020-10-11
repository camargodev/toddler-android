package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.TrueOrFalseExercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayResultsActivity extends AppCompatActivity {

    private TextView quizTitle, results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_display_activity);
        mapLayout();
        quizTitle.setText(QuizManager.getInstance().getQuiz().getTitle());
        results.setText(QuizManager.getInstance().getQuiz().toString());
    }

    private void mapLayout() {
        quizTitle = findViewById(R.id.results_title);
        results = findViewById(R.id.results);
    }
}