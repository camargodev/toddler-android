package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

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
        Toast.makeText(this, "Resposta A", Toast.LENGTH_LONG).show();
    }

    public void answerB(View view) {
        Toast.makeText(this, "Resposta B", Toast.LENGTH_LONG).show();
    }

    public void answerC(View view) {
        Toast.makeText(this, "Resposta C", Toast.LENGTH_LONG).show();
    }

    public void answerD(View view) {
        Toast.makeText(this, "Resposta D", Toast.LENGTH_LONG).show();
    }

    private void mapLayout() {
        questionTextView = findViewById(R.id.question);
        answerA = findViewById(R.id.ans_a);
        answerB = findViewById(R.id.ans_b);
        answerC = findViewById(R.id.ans_c);
        answerD = findViewById(R.id.ans_d);
    }
}