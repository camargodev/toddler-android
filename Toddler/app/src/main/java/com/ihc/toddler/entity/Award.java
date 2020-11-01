package com.ihc.toddler.entity;

import com.ihc.toddler.validator.AwardValidator;

public abstract class Award {

    private int id;
    private String title;
    private String description;
    private AwardTier awardTier;
    private AwardValidator validator;

    public Award(int id, Award award) {
        this(award.title, award.description, award.awardTier, award.validator);
        this.id = id;
    }

    public Award(String title, String description, AwardTier awardTier, AwardValidator validator) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AwardTier getAwardTier() {
        return awardTier;
    }

    public void setAwardTier(AwardTier awardTier) {
        this.awardTier = awardTier;
    }

    public boolean isAccomplished() {
        return validator.shouldAddAward();
    }
}
