package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.QuestionsCorrectValidator;

import static com.ihc.toddler.entity.AwardTier.GOLD;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class TenQuestionsCorrect extends Award {
    public TenQuestionsCorrect(int id) {
        super(id,"10 Questões Corretas", "Parabéns! Você já acertou 10 questões.", GOLD, new QuestionsCorrectValidator(10));
    }
}
