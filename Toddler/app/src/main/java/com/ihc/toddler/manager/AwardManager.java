package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.repository.AwardRepository;

public class AwardManager extends AwardRepository {

    private static final AwardManager manager = new AwardManager();

    private AwardManager() {}

    public static AwardManager getInstance() {
        return manager;
    }

    public void triggerContentAwardsValidations() {
        addAwardIfValid(FIRST_CONTENT_AWARD);
    }

    public void triggerQuizAwardsValidations() {
        addAwardIfValid(FIRST_QUIZ_AWARD);
        addAwardIfValid(FIVE_QUESTIONS_CORRECT_AWARD);
    }

    public boolean isAwardAccomplished(Integer awardId) {
        for (Award award : awardList)
            if (award.getId() == awardId)
                return award.isAccomplished();
        return false;
    }

    private void addAwardIfValid(Integer awardId) {
        for (Award award : awardList)
            if (award.getId() == awardId && award.isAchievable())
                award.setAccomplished(true);
    }

}
