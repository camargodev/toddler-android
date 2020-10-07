package com.ihc.toddler.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.TrueOrFalseExercise;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new MultipleChoiceExercise("Quanto é 3+3?", Arrays.asList("1", "3", "6", "9")));
        exercises.add(new TrueOrFalseExercise("2 é par?"));
        exercises.add(new MultipleChoiceExercise("Quantas sílabas tem em casa?", Arrays.asList("1", "2", "3", "4")));
        exercises.add(new TrueOrFalseExercise("7 é maior que 10?"));

        QuizManager manager = QuizManager.getInstance();
        manager.setExercises(exercises);

        Exercise currentExercise = manager.getCurrentExercise();
        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);
        Intent firstQuestion = exerciseView.getIntent(this);
        startActivity(firstQuestion);
    }
}