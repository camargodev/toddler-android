package com.ihc.toddler.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Locale;

public abstract class GenericExerciseActivity extends AppCompatActivity {

    protected TextView exerciseTextView;
    protected TextView questionTextView;
    protected QuizManager quizManager = QuizManager.getInstance();
    protected ExerciseView exerciseView;
    protected TextToSpeech textToSpeech;
    protected Button nextButton, previousButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercise currentExercise = quizManager.getCurrentExercise();
        exerciseView = ExerciseViewFactory.make(currentExercise);

        setContentView(exerciseView.getLayoutId());

        mapLayout();
        setCurrentExerciseText();
        clearAnswerButtons();
        if (quizManager.isCurrentExerciseAnswered())
            setExerciseAsAnswered();

        if (quizManager.isFirstExercise()) hidePreviousButton();

        exerciseView.mapQuestion(questionTextView);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(new Locale("pt", "BR"));
            }
        });
    }

    protected void hidePreviousButton() {
        previousButton.setVisibility(View.GONE);
    }

    protected void submitAnswer(Button button, Integer answer) {
        clearAnswerButtons();
        quizManager.submitAnswer(answer);
        markAsAnswered(button);
    }

    protected void markAsAnswered(Button button) {
        button.setBackgroundResource(R.drawable.selected_button);
        button.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    protected void goToPrevious() {
        Exercise previousExercise = quizManager.goToPrevious().getCurrentExercise();
        ExerciseView previousExerciseView = ExerciseViewFactory.make(previousExercise);
        Intent previousExerciseIntent = previousExerciseView.getIntent(this);
        finish();
        startActivity(previousExerciseIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void goToNext() {
        if (quizManager.isLastExercise()) {
            Intent resultsIntent = new Intent(this, DisplayResultsActivity.class);
            finish();
            startActivity(resultsIntent);
            return;
        }
        Exercise nextExercise = quizManager.goToNext().getCurrentExercise();
        ExerciseView nextExerciseView = ExerciseViewFactory.make(nextExercise);
        Intent nextExerciseIntent = nextExerciseView.getIntent(this);
        finish();
        startActivity(nextExerciseIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void readQuestion() {
        String toSpeak = questionTextView.getText().toString();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    protected void mapLayout() {
        exerciseTextView = findViewById(R.id.exercise_number);
        questionTextView = findViewById(R.id.question);
        nextButton = findViewById(R.id.next);
        previousButton = findViewById(R.id.previous);
    }

    protected void setCurrentExerciseText() {
        int current = quizManager.getCurrentExerciseNumber();
        int total = quizManager.getNumberOfExercises();
        String text = "Exercício " + current + " de " + total;
        exerciseTextView.setText(text);
    }

    protected void setExerciseAsAnswered() {
        int answer = quizManager.getCurrentAnswer();
        markButtonExercise(answer);
    }

    protected void clearAnswerButton(Button button) {
        button.setBackgroundResource(R.drawable.unselected_button);
        button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }

    protected abstract void clearAnswerButtons();
    protected abstract void markButtonExercise(int answer);

}