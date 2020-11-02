package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FiveQuestionsCorrectValidator;

import static com.ihc.toddler.entity.AwardTier.GOLD;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class FiveQuestionsCorrect extends Award {
    public FiveQuestionsCorrect(int id) {
        super(id,"5 Acertos", "Parabéns! Você já acertou 5 questões.", SILVER, new FiveQuestionsCorrectValidator());
    }
}
