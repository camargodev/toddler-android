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
    private static final String BLANK_ANSWER_TEXT = "Not answered";

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

    public QuizManager goToNext() {
        currentExercise += 1;
        return this;
    }

    public QuizManager goToLast() {
        currentExercise -= 1;
        return this;
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

    public List<String> getAnswersTexts() {
        List<String> texts = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            Integer currentAnswer = answers.get(i);
            if (currentAnswer.equals(BLANK_ANSWER))
                texts.add(BLANK_ANSWER_TEXT);
            else
                texts.add(exercises.get(i).getAnswers().get(currentAnswer-1));
        }
        return texts;
    }

    private boolean isCurrentExerciseAnswered() {
        return answers.get(currentExercise) > BLANK_ANSWER;
    }

}
