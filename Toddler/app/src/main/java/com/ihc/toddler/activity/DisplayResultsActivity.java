package com.ihc.toddler.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.OpenResultCardAdapter;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.LevelManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.ResultOpeningManager;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.repository.QuizRepository;

public class DisplayResultsActivity extends GenericActivity {

    private RecyclerView openResultView;
    private TextView quizTitle, results, message, yourGradeLabel, yourGrade, clickToReview, currentExercise;
    private Button revealGrade;
    private ConstraintLayout goToMenu;
    private Quiz quiz = QuizManager.getInstance().getQuiz();
    private OpenResultCardAdapter openResultCardAdapter;
    private ResultCardAdapter resultsAdapter;
    private boolean resultsOpened;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_display_activity);
        mapLayout();

        ActivityTracker.getInstance().persistActivity(quiz);
        quiz.submitQuiz();

        AwardManager.getInstance().triggerAwardValidations();

        quizTitle.setText(quiz.getTitle());
//        message.setText(getMessage());
//        button.setBackgroundResource(R.drawable.next);

        RecyclerView resultsListView = findViewById(R.id.correct_questions_view);

        openResultView = findViewById(R.id.open_result_recycler_view);
        openResultView.setVisibility(View.INVISIBLE);

        resultsAdapter = new ResultCardAdapter(quiz, this, textToSpeech);
        openResultCardAdapter = new OpenResultCardAdapter(this);

        RecyclerView.LayoutManager resultListManager = new GridLayoutManager(this, 4);
        resultsListView.setLayoutManager(resultListManager);
        resultsListView.setAdapter(resultsAdapter);

        RecyclerView.LayoutManager openResultManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        openResultView.setLayoutManager(openResultManager);
        openResultView.setAdapter(openResultCardAdapter);

        revealGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < quiz.getNumberOfExercises(); i++)
                    ResultOpeningManager.getInstance().open(i);
                resultsOpened = true;

                resultsAdapter.notifyDataSetChanged();

                revealGrade.setVisibility(View.INVISIBLE);
                yourGradeLabel.setVisibility(View.VISIBLE);
                yourGrade.setVisibility(View.VISIBLE);

                clickToReview.setText("Clique em um exercício para revisa-lo");

                yourGrade.setText(getGradeMessage());
                goToMenu.setBackgroundTintList(AppCompatResources.getColorStateList(DisplayResultsActivity.this, R.color.cardColor3));
            }
        });

        goToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultsOpened) finish();
            }
        });

    }

    private void mapLayout() {
        quizTitle = findViewById(R.id.results_title);
        yourGrade = findViewById(R.id.your_grade);
        yourGradeLabel = findViewById(R.id.your_grade_is);
        revealGrade = findViewById(R.id.reveal_grades);
        goToMenu = findViewById(R.id.go_back_to_menu);
        clickToReview = findViewById(R.id.click_to_review_text);
        currentExercise =  findViewById(R.id.current_exercise);

        yourGradeLabel.setVisibility(View.INVISIBLE);
        yourGrade.setVisibility(View.INVISIBLE);
//        message = findViewById(R.id.exercise_message);
//        button = findViewById(R.id.exercise_action);
    }

    public void exerciseAction(View view) {
        this.overridePendingTransition(0, 0);
        finish();
    }

    private String getGradeMessage() {
        double grade = ((double) quiz.getCorrectCount() / quiz.getNumberOfExercises()) * 10;
        @SuppressLint("DefaultLocale") String stringGrade = String.format("%.1f", grade);
        return stringGrade;
    }

    public void readAction(View view) {
        speechManager.talk(getGradeMessage());
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

    public void setExerciseInHighlight(Exercise exercise, int position) {
        clickToReview.setVisibility(View.INVISIBLE);
        openResultView.setVisibility(View.VISIBLE);
        openResultCardAdapter.setExercise(exercise);
        currentExercise.setText("Questão " + (position+1));
    }
}