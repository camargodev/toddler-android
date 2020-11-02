package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FirstContentConsumedValidator;

import static com.ihc.toddler.entity.AwardTier.BRONZE;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class FirstContentConsumed extends Award {
    public FirstContentConsumed(int id) {
        super(id,"Primeira Aula", "Parabéns! Você assistiu sua primeira aula.", BRONZE, new FirstContentConsumedValidator());
    }
}
