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

import java.util.Arrays;

public class MultipleChoiceActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button answerA, answerB, answerC, answerD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapLayout();
        Exercise ex = new MultipleChoiceExercise("Quanto é 3x3?", Arrays.asList("1", "3", "6", "9"));
        ex.display(questionTextView, Arrays.asList(answerA, answerB, answerC, answerD));
    }

    public void answerA(View view) {
        Toast.makeText(this, "Incorreto", Toast.LENGTH_LONG).show();
    }

    public void answerB(View view) {
        Toast.makeText(this, "Incorreto", Toast.LENGTH_LONG).show();
    }

    public void answerC(View view) {
        Toast.makeText(this, "Incorreto", Toast.LENGTH_LONG).show();
    }

    public void answerD(View view) {
        Toast.makeText(this, "Correto", Toast.LENGTH_LONG).show();
        Intent nextTask = new Intent(this, TrueOrFalseActivity.class);
        finish();
        startActivity(nextTask);
    }

    private void mapLayout() {
        questionTextView = findViewById(R.id.question);
        answerA = findViewById(R.id.ans_a);
        answerB = findViewById(R.id.ans_b);
        answerC = findViewById(R.id.ans_c);
        answerD = findViewById(R.id.ans_d);
    }
}