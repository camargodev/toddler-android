package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ihc.toddler.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}