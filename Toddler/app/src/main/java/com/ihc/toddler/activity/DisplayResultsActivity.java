package com.ihc.toddler.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.OpenResultCardAdapter;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.repository.QuizRepository;

public class DisplayResultsActivity extends GenericActivity {

    private RecyclerView openResultView;
    private TextView quizTitle, results, message;
    private Button button;
    private Quiz quiz = QuizManager.getInstance().getQuiz();
    private OpenResultCardAdapter openResultCardAdapter;
    private ResultCardAdapter resultsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_display_activity);
        mapLayout();

        ActivityTracker.getInstance().persistActivity(quiz);
        quiz.submitQuiz();

        AwardManager.getInstance().triggerAwardValidations();

        quizTitle.setText(quiz.getTitle());
        message.setText(getMessage());
        button.setBackgroundResource(R.drawable.next);

        RecyclerView resultsListView = findViewById(R.id.correct_questions_view);

        openResultView = findViewById(R.id.open_result_recycler_view);

        resultsAdapter = new ResultCardAdapter(quiz, this, textToSpeech);
        openResultCardAdapter = new OpenResultCardAdapter(this, quiz.getExercises());

        RecyclerView.LayoutManager resultListManager = new GridLayoutManager(this, 3);
        resultsListView.setLayoutManager(resultListManager);
        resultsListView.setAdapter(resultsAdapter);

        RecyclerView.LayoutManager openResultManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        openResultView.setLayoutManager(openResultManager);
        openResultView.setAdapter(openResultCardAdapter);
    }

    private void mapLayout() {
        quizTitle = findViewById(R.id.results_title);
        message = findViewById(R.id.exercise_message);
        button = findViewById(R.id.exercise_action);
    }

    public void exerciseAction(View view) {
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

    public OpenResultCardAdapter getOpenResultCardAdapter() {
        return openResultCardAdapter;
    }

    public RecyclerView getOpenResultView() {
        return openResultView;
    }

    public ResultCardAdapter getResultsAdapter() {
        return resultsAdapter;
    }
}