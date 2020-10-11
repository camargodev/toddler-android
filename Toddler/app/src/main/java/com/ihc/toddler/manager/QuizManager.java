package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
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

    public Quiz getQuiz() { return quiz; }

    public int getNumberOfExercises() {
        return quiz.getNumberOfExercises();
    }

    public int getCurrentExerciseNumber() {
        return this.currentExercise + 1;
    }

    public boolean isCurrentExerciseAnswered() {
        return !quiz.getAnswers().get(currentExercise).equals(Quiz.BLANK_ANSWER);
    }

    public int getCurrentAnswer() {
        return quiz.getAnswers().get(currentExercise);
    }

}
