package com.ihc.toddler.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.ContentPart;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.manager.ColorManager;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Locale;

public class ContentActivity extends GenericActivity {

    protected TextView contentTextView, currentPartTextView;
    protected Button nextButton, previousButton, titleButton;
    protected ContentManager contentManager = ContentManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);
        mapLayout();
        setCurrentExerciseText();

        if (contentManager.isFirstPart()) hidePreviousButton();

        ContentPart currentPart = contentManager.getCurrentPart();
        titleButton.setText(currentPart.getTitle());
        contentTextView.setText(currentPart.getText());

        titleButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, ColorManager.getRandomColorId()));
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
            new AlertDialog.Builder(this, R.style.AlertDialogTheme)
                    .setTitle("Acabou a aula")
                    .setMessage("Se você entendeu a matéria, vá para os exercícios.")

                    .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent resultsIntent = new Intent(getApplicationContext(), MainActivity.class);
                            finish();
                            startActivity(resultsIntent);
                        }
                    })

                    .setNegativeButton("Voltar", null)
                    .setIcon(R.drawable.small_logo)
                    .show();
            return;
        }
        contentManager.goToNext();
        Intent nextPartIntent = new Intent(this, ContentActivity.class);
        finish();
        startActivity(nextPartIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void setCurrentExerciseText() {
        int current = contentManager.getCurrentPartNumber();
        int total = contentManager.getNumberOfParts();
        String text = "PARTE " + current + " DE " + total;
        currentPartTextView.setText(text);
    }

    protected void mapLayout() {
        contentTextView = findViewById(R.id.content);
        currentPartTextView = findViewById(R.id.part_number);
        nextButton = findViewById(R.id.next);
        previousButton = findViewById(R.id.previous);
        titleButton = findViewById(R.id.talk);
    }

    public void readPart(View view) {
        speechManager.talk(contentTextView.getText().toString());
    }

    public void next(View view) { goToNext(); }

    public void previous(View view) { goToPrevious(); }

    public void readContent(View view) {
        speechManager.talk(contentManager.getCurrentPart().getTitle());
    }
}