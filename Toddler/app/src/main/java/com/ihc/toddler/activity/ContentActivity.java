package com.ihc.toddler.activity;

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
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Locale;

public class ContentActivity extends AppCompatActivity {

    protected TextView contentTextView;
    protected TextToSpeech textToSpeech;
    protected Button nextButton, previousButton;
    protected ContentManager contentManager = ContentManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        mapLayout();

        if (contentManager.isFirstPart()) hidePreviousButton();

        String currentPartText = contentManager.getCurrentPart();
        contentTextView.setText(currentPartText);

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

    protected void goToPrevious() {
        contentManager.goToPrevious();
        Intent previousPartIntent = new Intent(this, ContentActivity.class);
        finish();
        startActivity(previousPartIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void goToNext() {
        if (contentManager.isLastPart()) {
            Intent contentEndActivity = new Intent(this, ContentEndActivity.class);
            finish();
            startActivity(contentEndActivity);
            return;
        }
        contentManager.goToNext();
        Intent nextPartIntent = new Intent(this, ContentActivity.class);
        finish();
        startActivity(nextPartIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void mapLayout() {
        contentTextView = findViewById(R.id.content);
        nextButton = findViewById(R.id.next);
        previousButton = findViewById(R.id.previous);
    }

    public void readContent(View view) {
        String toSpeak = contentTextView.getText().toString();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void next(View view) { goToNext(); }

    public void previous(View view) { goToPrevious(); }

}