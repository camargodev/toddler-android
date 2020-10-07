package com.ihc.toddler.manager;

import android.content.Intent;

import com.ihc.toddler.entity.Exercise;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private static QuizManager quizManager;
    private int currentExercise = 0;
    private List<Exercise> exercises;
    private List<Integer> answers = new ArrayList<>();
    private int answeredCount = 0;

    private static final Integer BLANK_ANSWER = 0;

    private QuizManager() {}

    public static QuizManager getInstance() {
        if (quizManager == null)
            quizManager = new QuizManager();
        return quizManager;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
        for (int i = 0; i < exercises.size(); i++) answers.add(0);
    }

    public Exercise getCurrentExercise() {
        return exercises.get(currentExercise);
    }

    public void goToNext() {
        currentExercise += 1;
    }

    public void goToLast() {
        currentExercise -= 1;
    }

    public boolean isLastExercise() {
        return currentExercise == (exercises.size() - 1);
    }

    public boolean areAllAnswered() {
        return answeredCount == exercises.size();
    }

    public void submitAnswer(Integer answer) {
        if (!isCurrentExerciseAnswered())
            answeredCount += 1;
        answers.set(currentExercise, answer);
    }

    public void clearAnswer() {
        if (isCurrentExerciseAnswered())
            answeredCount -= 1;
        answers.set(currentExercise, BLANK_ANSWER);
    }

    private boolean isCurrentExerciseAnswered() {
        return answers.get(currentExercise) > BLANK_ANSWER;
    }

}
