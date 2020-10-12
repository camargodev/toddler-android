package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.ContentPart;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.entity.TrueOrFalseExercise;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button startContent, startQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startContent = findViewById(R.id.start_content);
        startQuiz = findViewById(R.id.start_quiz);
    }

    public void startContent(View view) {

        Content content = ContentRepository.getContent();

        ContentManager.getInstance(content);
        Intent firstPart = new Intent(this, ContentActivity.class);
        startActivity(firstPart);

    }

    public void startQuiz(View view) {
        Quiz quiz = QuizRepository.getQuiz();
        QuizManager manager = QuizManager.getInstance(quiz);

        Exercise currentExercise = manager.getCurrentExercise();
        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);
        Intent firstQuestion = exerciseView.getIntent(this);
        startActivity(firstQuestion);

    }
}