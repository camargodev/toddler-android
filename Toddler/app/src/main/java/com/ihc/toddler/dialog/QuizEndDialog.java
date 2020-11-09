package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.activity.DisplayResultsActivity;
import com.ihc.toddler.activity.GenericExerciseActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.persistence.ActivityTracker;

public class QuizEndDialog extends Dialog implements View.OnClickListener {

    private GenericExerciseActivity activity;
    private TextToSpeech textToSpeech;

    public QuizEndDialog(@NonNull GenericExerciseActivity activity, TextToSpeech textToSpeech) {
        super(activity);
        this.activity = activity;
        this.textToSpeech = textToSpeech;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.quiz_end_dialog);

        Button goBack = findViewById(R.id.go_back);
        Button goNext = findViewById(R.id.go_next);
        TextView title = findViewById(R.id.quiz_end_title);
        TextView text = findViewById(R.id.quiz_end_text);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultsIntent = new Intent(activity.getApplicationContext(), DisplayResultsActivity.class);
                activity.finish();
                activity.startActivity(resultsIntent);
                dismiss();
            }
        });

        SpeechManager speechManager = new SpeechManager(textToSpeech);
        speechManager.readWithNormalClick(title);
        speechManager.readWithNormalClick(text);

        speechManager.readWithLongClick(goBack, "Voltar");
        speechManager.readWithLongClick(goNext, "Terminar");
    }

    @Override
    public void onClick(View v) {}
}
