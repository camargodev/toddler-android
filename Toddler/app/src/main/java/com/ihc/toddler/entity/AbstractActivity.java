package com.ihc.toddler.entity;

import java.util.UUID;

public abstract class AbstractActivity {

    private UUID id;

    public AbstractActivity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
