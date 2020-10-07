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

public class TrueOrFalseActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button trueButton, falseButton;
    private QuizManager quizManager = QuizManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercise currentExercise = quizManager.getCurrentExercise();
        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);

        setContentView(exerciseView.getLayoutId());

        mapLayout();
        exerciseView.mapQuestion(questionTextView);
        exerciseView.mapAnswers(Arrays.asList(trueButton, falseButton));
    }

    public void answerA(View view) {
        submitAndGoToNext(1);
    }

    public void answerB(View view) { submitAndGoToNext(2); }

    private void submitAndGoToNext(Integer answer) {
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

    private void mapLayout() {
        questionTextView = findViewById(R.id.question);
        trueButton = findViewById(R.id.ans_true);
        falseButton = findViewById(R.id.ans_false);
    }
}