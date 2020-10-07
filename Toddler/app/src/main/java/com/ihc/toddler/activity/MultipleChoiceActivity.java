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
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Arrays;

public class MultipleChoiceActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button answerA, answerB, answerC, answerD;
    private QuizManager quizManager = QuizManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercise currentExercise = quizManager.getCurrentExercise();
        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);

        setContentView(exerciseView.getLayoutId());

        mapLayout();
        exerciseView.mapQuestion(questionTextView);
        exerciseView.mapAnswers(Arrays.asList(answerA, answerB, answerC, answerD));
    }

    public void answerA(View view) {
        submitAndGoToNext(1);
    }

    public void answerB(View view) {
        submitAndGoToNext(2);
    }

    public void answerC(View view) { submitAndGoToNext(3); }

    public void answerD(View view) { submitAndGoToNext(4); }

    private void submitAndGoToNext(Integer answer) {
        quizManager.submitAnswer(answer);
        if (quizManager.isLastExercise()) return;
        Exercise nextExercise = quizManager.goToNext().getCurrentExercise();
        ExerciseView nextExerciseView = ExerciseViewFactory.make(nextExercise);
        Intent nextExerciseIntent = nextExerciseView.getIntent(this);
        startActivity(nextExerciseIntent);
    }

    private void mapLayout() {
        questionTextView = findViewById(R.id.question);
        answerA = findViewById(R.id.ans_a);
        answerB = findViewById(R.id.ans_b);
        answerC = findViewById(R.id.ans_c);
        answerD = findViewById(R.id.ans_d);
    }
}