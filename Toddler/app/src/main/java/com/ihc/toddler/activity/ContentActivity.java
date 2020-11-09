package com.ihc.toddler.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.content.res.AppCompatResources;

import com.ihc.toddler.R;
import com.ihc.toddler.dialog.ContentEndDialog;
import com.ihc.toddler.dialog.NewAwardsDialog;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.ContentPart;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.ColorManager;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.persistence.ActivityTracker;

import java.util.List;

public class ContentActivity extends GenericActivity {

    protected TextView contentTextView, currentPartTextView;
    protected Button nextButton, previousButton, titleButton;
    protected ContentManager contentManager = ContentManager.getInstance();
    private int selectedColor = ColorManager.getRandomColorId();

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

        titleButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
        nextButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
        previousButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));

        speechManager.readWithNormalClick(currentPartTextView);
        speechManager.readWithLongClick(nextButton, "Próximo");
        speechManager.readWithLongClick(previousButton, "Anterior");



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
            ContentEndDialog newAwardsDialog = new ContentEndDialog(this, contentManager.getContent());
            newAwardsDialog.show();
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