package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.QuizAnsweredValidator;

import static com.ihc.toddler.entity.AwardTier.BRONZE;

public class FirstQuizAnswered extends Award {
    public FirstQuizAnswered(int id) {
        super(id,"Primeiro Exercício", "Parabéns! Você respondeu seu primeiro questionário.", BRONZE, new QuizAnsweredValidator(1));
    }
}
