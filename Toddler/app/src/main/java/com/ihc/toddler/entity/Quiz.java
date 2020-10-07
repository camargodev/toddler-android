package com.ihc.toddler.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {

    private String title;

    private List<Exercise> exercises;
    private List<Integer> answers;
    private int answeredCount = 0;

    private static final Integer BLANK_ANSWER = 0;
    private static final String BLANK_ANSWER_TEXT = "Not answered";

    public Quiz(String title, List<Exercise> exercises) {
        this.title = title;
        this.exercises = exercises;
        this.answers = new ArrayList<>((Collections.nCopies(exercises.size(), BLANK_ANSWER)));
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public int getAnsweredCount() {
        return answeredCount;
    }

    public void setAnsweredCount(int answeredCount) {
        this.answeredCount = answeredCount;
    }

    public int getNumberOfExercises() {
        return exercises.size();
    }

    public boolean areAllAnswered() {
        return answeredCount == exercises.size();
    }

    public void submitAnswer(int exerciseIndex, Integer answer) {
        if (!isExerciseAnswered(exerciseIndex))
            answeredCount += 1;
        answers.set(exerciseIndex, answer);
    }

    public void clearAnswer(int exerciseIndex) {
        if (isExerciseAnswered(exerciseIndex))
            answeredCount -= 1;
        answers.set(exerciseIndex, BLANK_ANSWER);
    }

    private boolean isExerciseAnswered(int exerciseIndex) {
        return !answers.get(exerciseIndex).equals(BLANK_ANSWER);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(title);
        if (exercises == null)
            return text.toString();


        for (int i = 0; i < exercises.size(); i++) {
            Exercise exercise = exercises.get(i);
            Integer answer = answers.get(i);
            text.append("\n");
            text.append(exercise.getQuestion());
            text.append(" = ");
            if (answer.equals(BLANK_ANSWER))
                text.append(BLANK_ANSWER_TEXT);
            else
                text.append(exercise.getAnswers().get(answer-1));
        }
        return text.toString();
    }
}