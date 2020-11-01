package com.ihc.toddler.repository;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.AwardTier;
import com.ihc.toddler.entity.awards.FirstContentConsumed;
import com.ihc.toddler.entity.awards.FirstQuizAnswered;
import com.ihc.toddler.entity.awards.FiveQuestionsCorrect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class AwardRepository {

    private static List<Award> awardList;
    private static HashMap<AwardTier, List<Award>> awardsByTier = new HashMap<>();

    static {
        awardList = Arrays.asList(new FirstContentConsumed(), new FirstQuizAnswered(), new FiveQuestionsCorrect());
        for (AwardTier tier : AwardTier.values())
            awardsByTier.put(tier, new ArrayList<Award>());
        for (Award award : awardList)
            Objects.requireNonNull(awardsByTier.get(award.getAwardTier())).add(award);
    }

    public static List<Award> getAll() {
        return awardList;
    }

    public static List<Award> getByTier(AwardTier tier) {
        return awardsByTier.get(tier);
    }



}
