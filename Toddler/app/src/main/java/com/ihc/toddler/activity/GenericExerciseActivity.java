package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Arrays;

public class GenericExerciseActivity extends AppCompatActivity {

    protected TextView questionTextView;
    protected QuizManager quizManager = QuizManager.getInstance();
    protected ExerciseView exerciseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercise currentExercise = quizManager.getCurrentExercise();
        exerciseView = ExerciseViewFactory.make(currentExercise);

        setContentView(exerciseView.getLayoutId());
        mapLayout();

        exerciseView.mapQuestion(questionTextView);
    }

    protected void submitAndGoToNext(Integer answer) {
        quizManager.submitAnswer(answer);
        if (quizManager.isLastExercise()) {
            Intent resultsIntent = new Intent(this, DisplayResultsActivity.class);
            startActivity(resultsIntent);
            return;
        }
        Exercise nextExercise = quizManager.goToNext().getCurrentExercise();
        ExerciseView nextExerciseView = ExerciseViewFactory.make(nextExercise);
        Intent nextExerciseIntent = nextExerciseView.getIntent(this);
        startActivity(nextExerciseIntent);
    }

    protected void mapLayout() {
        questionTextView = findViewById(R.id.question);
    }
}