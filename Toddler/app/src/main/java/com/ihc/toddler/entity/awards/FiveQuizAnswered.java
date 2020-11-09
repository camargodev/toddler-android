package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.QuizAnsweredValidator;

import static com.ihc.toddler.entity.AwardTier.BRONZE;

public class FiveQuizAnswered extends Award {
    public FiveQuizAnswered(int id) {
        super(id,"5 Exercícios", "Parabéns! Você respondeu 5 exercícios.", BRONZE, new QuizAnsweredValidator(5));
    }
}
