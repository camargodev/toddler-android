package com.ihc.toddler.entity;

public abstract class Award {

    private int id;
    private String title;
    private String description;
    private Tier tier;

    public Award(String title, String description, Tier tier) {
        this.title = title;
        this.description = description;
        this.tier = tier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
}
