package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FirstQuizAnsweredValidator;

import static com.ihc.toddler.entity.AwardTier.BRONZE;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class FirstQuizAnswered extends Award {
    public FirstQuizAnswered(int id) {
        super(id,"Primeiro Quiz", "Parabéns! Você respondeu seu primeiro quiz.", BRONZE, new FirstQuizAnsweredValidator());
    }
}
