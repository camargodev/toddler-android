package com.ihc.toddler.entity;

import com.ihc.toddler.validator.AwardValidator;

public abstract class Award {

    private int id;
    private String title;
    private String description;
    private AwardTier awardTier;
    private AwardValidator validator;
    private boolean isAccomplished;

    public Award(int id, String title, String description, AwardTier awardTier, AwardValidator validator) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.awardTier = awardTier;
        this.validator = validator;
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

    public String getTitle() {
        return title;
    }

    public AwardTier getAwardTier() {
        return awardTier;
    }

    public boolean isAchievable() {
        return validator.shouldAddAward();
    }

    public boolean isAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(boolean accomplished) {
        isAccomplished = accomplished;
    }
}
