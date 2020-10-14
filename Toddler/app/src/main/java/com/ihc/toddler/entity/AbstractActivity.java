package com.ihc.toddler.entity;

import java.util.UUID;

public abstract class AbstractActivity {

    private UUID id;
    protected String title;

    public AbstractActivity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
