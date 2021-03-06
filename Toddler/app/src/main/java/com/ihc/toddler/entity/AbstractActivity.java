package com.ihc.toddler.entity;

public abstract class AbstractActivity {

    protected int id;
    protected String title;
    protected ActivityType type;
    protected Subject subject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public abstract String getTypeName();

    public abstract AbstractActivity clone();

    public ActivityType getType() {
        return type;
    }
}
