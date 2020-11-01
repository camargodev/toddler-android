package com.ihc.toddler.entity;

import com.ihc.toddler.validator.AwardValidator;

public abstract class Award {

    private int id;
    private String title;
    private String description;
    private Tier tier;
    private AwardValidator validator;

    public Award(int id, Award award) {
        this(award.title, award.description, award.tier, award.validator);
        this.id = id;
    }

    public Award(String title, String description, Tier tier, AwardValidator validator) {
        this.title = title;
        this.description = description;
        this.tier = tier;
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

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public boolean isAccomplished() {
        return validator.shouldAddAward();
    }
}
