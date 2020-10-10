package com.ihc.toddler.manager;

import android.content.Intent;

import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private static QuizManager quizManager = new QuizManager();

    private int currentExercise = 0;
    private Quiz quiz;

    private QuizManager() {}

    private QuizManager(Quiz quiz) {
        this.currentExercise = 0;
        this.quiz = quiz;
    }

    public static QuizManager getInstance() {
        return quizManager;
    }

    public static QuizManager getInstance(Quiz quiz) {
        quizManager = new QuizManager(quiz);
        return quizManager;
    }

    public Exercise getCurrentExercise() {
        return quiz.getExercises().get(currentExercise);
    }

    public QuizManager goToNext() {
        currentExercise += 1;
        return this;
    }

    public QuizManager goToPrevious() {
        currentExercise -= 1;
        return this;
    }

    public boolean isLastExercise() {
        return currentExercise == (quiz.getNumberOfExercises() - 1);
    }

    public boolean isFirstExercise() { return currentExercise ==  0; }

    public void submitAnswer(Integer answer) {
        quiz.submitAnswer(currentExercise, answer);
    }

    public void clearAnswer() {
        quiz.clearAnswer(currentExercise);
    }

    public String getQuizText() {
        return quiz.toString();
    }

    public int getNumberOfExercises() {
        return quiz.getNumberOfExercises();
    }

    public int getCurrentExerciseNumber() {
        return this.currentExercise + 1;
    }

}
