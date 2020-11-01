package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.awards.FirstQuizAnswered;
import com.ihc.toddler.validator.AwardValidator;
import com.ihc.toddler.validator.FirstQuizAnsweredValidator;
import com.ihc.toddler.validator.NullValidator;

import java.util.ArrayList;
import java.util.List;

public class AwardManager {

    private static final AwardManager manager = new AwardManager();
    private List<Award> conqueredAwards = new ArrayList<>();

    private AwardValidator firstQuizAwardValidator = new FirstQuizAnsweredValidator();

    private AwardManager() {}

    public static AwardManager getInstance() {
        return manager;
    }

    public void addAward(Award award) {
        if (shouldAddAward(award))
            conqueredAwards.add(award);
    }

    public List<Award> getConqueredAwards() {
        return conqueredAwards;
    }

    public boolean shouldAddAward(Award award) {
        AwardValidator validator = new NullValidator();
        if (award instanceof FirstQuizAnswered)
            validator = firstQuizAwardValidator;
        return validator.shouldAddAward();
    }
}
