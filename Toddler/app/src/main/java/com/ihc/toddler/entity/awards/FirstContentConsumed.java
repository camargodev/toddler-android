package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FirstContentConsumedValidator;

import static com.ihc.toddler.entity.Tier.SILVER;

public class FirstContentConsumed extends Award {
    public FirstContentConsumed() {
        super("Primeira Aula", "Parabéns! Você assistiu sua primeira aula.", SILVER, new FirstContentConsumedValidator());
    }
}
