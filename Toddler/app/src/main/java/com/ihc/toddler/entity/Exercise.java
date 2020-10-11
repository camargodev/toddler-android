package com.ihc.toddler.entity;

import java.util.List;

public abstract class Exercise extends AbstractActivity {

    protected String question;
    protected int numberOfAnswers;
    protected List<String> answers;

    public Exercise(String question, int numberOfAnswers, List<String> answers) {
        super();
        this.question = question;
        this.numberOfAnswers = numberOfAnswers;
        this.answers = answers;
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
