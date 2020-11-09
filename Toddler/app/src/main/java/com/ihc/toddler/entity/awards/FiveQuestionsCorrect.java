package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.QuestionsCorrectValidator;

import static com.ihc.toddler.entity.AwardTier.SILVER;

public class FiveQuestionsCorrect extends Award {
    public FiveQuestionsCorrect(int id) {
        super(id,"5 Questões Corretas", "Parabéns! Você já acertou 5 questões.", SILVER, new QuestionsCorrectValidator(5));
    }
}
