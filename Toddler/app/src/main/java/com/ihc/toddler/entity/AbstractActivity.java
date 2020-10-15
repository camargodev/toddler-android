package com.ihc.toddler.entity;

import java.util.UUID;

public abstract class AbstractActivity {

    private int id;
    protected String title;

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

    public abstract String getTypeName();

    public abstract AbstractActivity clone();
}
