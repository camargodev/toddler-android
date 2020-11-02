package com.ihc.toddler.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.persistence.ActivityTracker;

public class DisplayResultsActivity extends GenericActivity {

    private TextView quizTitle, results, message;
    private Button button;
    private Quiz quiz = QuizManager.getInstance().getQuiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_display_activity);
        mapLayout();

        ActivityTracker.getInstance().persistActivity(quiz);
        quiz.submitQuiz();

        AwardManager.getInstance().triggerQuizAwardsValidations();

        quizTitle.setText(quiz.getTitle());
        message.setText(getMessage());
        button.setBackgroundResource(R.drawable.next);

        RecyclerView recyclerView = findViewById(R.id.results_recycler_view);

        ResultCardAdapter activityCardAdapter = new ResultCardAdapter(quiz, this, textToSpeech);

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    private void mapLayout() {
        quizTitle = findViewById(R.id.results_title);
        message = findViewById(R.id.exercise_message);
        button = findViewById(R.id.exercise_action);
    }

    public void exerciseAction(View view) {
        Intent awardsIntent = new Intent(this, DisplayAwardsFragment.class);
        startActivity(awardsIntent);
        this.overridePendingTransition(0, 0);
        finish();
    }

    private String getMessage() {
        double grade = ((double) quiz.getCorrectCount() / quiz.getNumberOfExercises()) * 10;
        @SuppressLint("DefaultLocale") String stringGrade = String.format("%.2f", grade);
        return "Sua nota: " + stringGrade + "/10";
    }

    public void readAction(View view) {
        speechManager.talk(getMessage());
    }

    public void readResults(View view) {
        speechManager.talk(quiz.toString());
    }
}