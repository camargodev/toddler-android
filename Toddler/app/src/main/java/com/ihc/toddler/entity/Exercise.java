package com.ihc.toddler.entity;

import java.util.List;

public abstract class Exercise {

    protected String question;
    protected int numberOfAnswers;
    protected List<String> answers;
    protected int answer;

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

}
