package com.ihc.toddler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
import java.util.Locale;

public class MultipleChoiceActivity extends GenericExerciseActivity {

    private Button answerA, answerB, answerC, answerD;

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exerciseView.mapAnswers(Arrays.asList(answerA, answerB, answerC, answerD));
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(new Locale("pt", "BR"));
            }
        });

    }

    public void answerA(View view) {
        submitAndGoToNext(1);
    }

    public void answerB(View view) {
        submitAndGoToNext(2);
    }

    public void answerC(View view) { submitAndGoToNext(3); }

    public void answerD(View view) { submitAndGoToNext(4); }

    public void readQuestion(View view) {

        String toSpeak = questionTextView.getText().toString();
//        Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void mapLayout() {
        super.mapLayout();
        answerA = findViewById(R.id.ans_a);
        answerB = findViewById(R.id.ans_b);
        answerC = findViewById(R.id.ans_c);
        answerD = findViewById(R.id.ans_d);
    }
}