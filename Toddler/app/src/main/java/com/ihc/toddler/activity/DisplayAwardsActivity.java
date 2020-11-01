package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.adapter.ResultCardAdapter;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

public class DisplayAwardsActivity extends GenericActivity {

//    private TextView quizTitle, results, message;
//    private Button button;
//    private Quiz quiz = QuizManager.getInstance().getQuiz();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.awards_display_activity);
        mapLayout();
//        quizTitle.setText(quiz.getTitle());
//        message.setText(getMessage());
//        if (isFinished())
//            button.setBackgroundResource(R.drawable.next);
//        else
//            button.setBackgroundResource(R.drawable.prev);

        RecyclerView recyclerView = findViewById(R.id.awards_recycler_view);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(AwardManager.getInstance().getConqueredAwards());

        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    private void mapLayout() {
//        quizTitle = findViewById(R.id.results_title);
//        message = findViewById(R.id.exercise_message);
//        button = findViewById(R.id.exercise_action);
    }

//    public void exerciseAction(View view) {
//        if (isFinished()) {
//            finish();
//        } else {
//            Exercise lastExercise = QuizManager.getInstance().getCurrentExercise();
//            ExerciseView lastExerciseView = ExerciseViewFactory.make(lastExercise);
//            Intent lastExerciseIntent = lastExerciseView.getIntent(this);
//            finish();
//            startActivity(lastExerciseIntent);
//            this.overridePendingTransition(0, 0);
//        }
//    }
//
//    private boolean isFinished() {
//        return quiz.getAnsweredCount() == quiz.getNumberOfExercises();
//    }
//
//    private String getMessage() {
//        double grade;
//        int correct = 0;
//        for (int i = 0; i < quiz.getNumberOfExercises(); i++) {
//            Exercise exercise = quiz.getExercises().get(i);
//            Integer selectedAnswer = quiz.getAnswers().get(i);
//            if (exercise.getAnswer() == selectedAnswer) {
//                correct += 1;
//            }
//        }
//        grade = ((double) correct/ quiz.getNumberOfExercises()) * 10;
//        String stringGrade = String.format("%.2f", grade);
//        return "Sua nota: " + stringGrade + "/10";
//    }
//
//    public void readAction(View view) {
//        speechManager.talk(getMessage());
//    }
//
//    public void readResults(View view) {
//        speechManager.talk(quiz.toString());
//    }
}