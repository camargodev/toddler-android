package com.ihc.toddler.entity;

import java.util.List;

public abstract class Exercise {

    protected String question;
    protected int numberOfAnswers;
    protected List<String> answers;
    protected int expectedAnswer, actualAnswer;
    protected ExerciseStatus status = ExerciseStatus.NOT_ANSWERED;

    public Exercise(String question, int numberOfAnswers, List<String> answers, int expectedAnswer) {
        super();
        this.question = question;
        this.numberOfAnswers = numberOfAnswers;
        this.answers = answers;
        this.expectedAnswer = expectedAnswer;
    }

    public int getExpectedAnswer() {
        return expectedAnswer;
    }

    public String getActualAnswerText() {
        return answers.get(actualAnswer-1);
    }

    public String getExpectedAnswerText() {
        return answers.get(expectedAnswer-1);
    }

    public void setExpectedAnswer(int expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public ExerciseStatus getStatus() {
        return status;
    }

    public int getActualAnswer() {
        return actualAnswer;
    }

    public void setActualAnswer(int actualAnswer) {
        this.actualAnswer = actualAnswer;
    }

    public void setStatus(ExerciseStatus status) {
        this.status = status;
    }
}
