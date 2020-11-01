package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FiveQuestionsCorrectValidator;

import static com.ihc.toddler.entity.Tier.GOLD;
import static com.ihc.toddler.entity.Tier.SILVER;

public class FiveQuestionsCorrect extends Award {
    public FiveQuestionsCorrect() {
        super("5 Acertos", "Parabéns! Você já acertou 5 questões.", GOLD, new FiveQuestionsCorrectValidator());
    }
}
