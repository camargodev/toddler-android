package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.entity.TrueOrFalseExercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisplayResultsActivity extends GenericActivity {

    private TextView quizTitle, results, message;
    private Button button;
    private Quiz quiz = QuizManager.getInstance().getQuiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_display_activity);
        mapLayout();
        quizTitle.setText(quiz.getTitle());
        results.setText(quiz.toString());
        message.setText(getMessage());
        if (isFinished())
            button.setBackgroundResource(R.drawable.next);
        else
            button.setBackgroundResource(R.drawable.prev);
    }

    private void mapLayout() {
        quizTitle = findViewById(R.id.results_title);
        results = findViewById(R.id.results);
        message = findViewById(R.id.exercise_message);
        button = findViewById(R.id.exercise_action);
    }

    public void exerciseAction(View view) {
        if (isFinished()) {
            finish();
        } else {
            Exercise lastExercise = QuizManager.getInstance().getCurrentExercise();
            ExerciseView lastExerciseView = ExerciseViewFactory.make(lastExercise);
            Intent lastExerciseIntent = lastExerciseView.getIntent(this);
            finish();
            startActivity(lastExerciseIntent);
            this.overridePendingTransition(0, 0);
        }
    }

    private boolean isFinished() {
        return quiz.getAnsweredCount() == quiz.getNumberOfExercises();
    }

    private String getMessage() {
        if (isFinished()) return "Você terminou os exercícios.\nParabéns! Vá para o menu.";
        return "Ainda faltam exercícios.\nVolte e responda-os.";
    }

    public void readAction(View view) {
        speechManager.talk(getMessage());
    }

    public void readResults(View view) {
        speechManager.talk(quiz.toString());
    }
}