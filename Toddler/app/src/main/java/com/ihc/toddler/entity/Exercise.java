package com.ihc.toddler.entity;

import java.util.List;

public abstract class Exercise {

    protected String question;
    protected int numberOfAnswers;
    protected List<String> answers;
    protected int answer;
    protected ExerciseStatus status = ExerciseStatus.NOT_ANSWERED;

    public Exercise(String question, int numberOfAnswers, List<String> answers, int answer) {
        super();
        this.question = question;
        this.numberOfAnswers = numberOfAnswers;
        this.answers = answers;
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
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

    public void setStatus(ExerciseStatus status) {
        this.status = status;
    }
}
