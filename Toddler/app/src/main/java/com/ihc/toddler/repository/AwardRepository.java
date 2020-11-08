package com.ihc.toddler.repository;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.AwardTier;
import com.ihc.toddler.entity.awards.FinishedAllExercises;
import com.ihc.toddler.entity.awards.FirstContentConsumed;
import com.ihc.toddler.entity.awards.FirstQuizAnswered;
import com.ihc.toddler.entity.awards.FiveContentConsumed;
import com.ihc.toddler.entity.awards.FiveQuestionsCorrect;
import com.ihc.toddler.entity.awards.FiveQuizAnswered;
import com.ihc.toddler.entity.awards.MaxGradeInQuiz;
import com.ihc.toddler.entity.awards.TenQuestionsCorrect;
import com.ihc.toddler.entity.awards.ThreeMaxGradeInQuiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwardRepository {

    private enum AwardDatabase {

        FINISHED_ALL(new FinishedAllExercises(1)),
        FIRST_CONTENT(new FirstContentConsumed(2)),
        FIRST_QUIZ(new FirstQuizAnswered(3)),
        FIVE_CONTENT(new FiveContentConsumed(4)),
        FIVE_QUESTIONS_CORRECT(new FiveQuestionsCorrect(5)),
        FIVE_QUIZ(new FiveQuizAnswered(6)),
        ONE_MAX_GRADE(new MaxGradeInQuiz(7)),
        TEN_QUESTIONS_CORRECT(new TenQuestionsCorrect(8)),
        THREE_MAX(new ThreeMaxGradeInQuiz(9));

        Award award;
        AwardDatabase(Award award) {
            this.award = award;
        }
    }

    protected static List<Award> awardList = new ArrayList<>();

    static {
        for (AwardDatabase entry : AwardDatabase.values())
            awardList.add(entry.award);
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

    protected List<Award> getByIdList(List<Integer> ids) {
        List<Award> awards = new ArrayList<>();
        for (Integer id : ids)
            for (Award award : awardList)
                if (award.getId() == id)
                    awards.add(award);
        return awards;
    }



}
