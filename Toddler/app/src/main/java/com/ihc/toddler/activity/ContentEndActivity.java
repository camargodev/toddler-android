package com.ihc.toddler.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihc.toddler.R;
import com.ihc.toddler.manager.QuizManager;

import javax.xml.datatype.Duration;

public class ContentEndActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_end_activity);
    }

    public void backToMenu(View view) {
        finish();
    }

    public void readText(View view) {
        speechManager.talk(getResources().getString(R.string.content_end));
    }
}