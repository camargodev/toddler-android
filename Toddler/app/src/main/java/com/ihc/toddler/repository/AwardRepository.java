package com.ihc.toddler.repository;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.AwardTier;
import com.ihc.toddler.entity.awards.FirstContentConsumed;
import com.ihc.toddler.entity.awards.FirstQuizAnswered;
import com.ihc.toddler.entity.awards.FiveQuestionsCorrect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwardRepository {

    protected static final Integer FIRST_CONTENT_AWARD = 1, FIRST_QUIZ_AWARD = 2, FIVE_QUESTIONS_CORRECT_AWARD = 3;

    protected static List<Award> awardList;

    static {
        awardList = Arrays.asList(new FirstContentConsumed(FIRST_CONTENT_AWARD), new FirstQuizAnswered(FIRST_QUIZ_AWARD), new FiveQuestionsCorrect(FIVE_QUESTIONS_CORRECT_AWARD));
    }

    public static List<Award> getAll() {
        return awardList;
    }

    public static List<Award> getByTier(AwardTier tier) {
        List<Award> awardsByTier = new ArrayList<>();
        for (Award award : awardList)
            if (award.getAwardTier().equals(tier))
                awardsByTier.add(award);
        return awardsByTier;
    }



}
