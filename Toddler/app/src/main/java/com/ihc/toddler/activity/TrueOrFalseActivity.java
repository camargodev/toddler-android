package com.ihc.toddler.activity;

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

import java.util.Arrays;

public class TrueOrFalseActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button trueButton, falseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.true_or_false_activity);
        mapLayout();
        Exercise ex = new TrueOrFalseExercise("2 é par?");
        ex.display(questionTextView, Arrays.asList(trueButton, falseButton));
    }

    public void answerA(View view) {
        Toast.makeText(this, "Correto", Toast.LENGTH_LONG).show();
    }

    public void answerB(View view) {
        Toast.makeText(this, "Incorreto", Toast.LENGTH_LONG).show();
    }

    private void mapLayout() {
        questionTextView = findViewById(R.id.question);
        trueButton = findViewById(R.id.ans_true);
        falseButton = findViewById(R.id.ans_false);
    }
}