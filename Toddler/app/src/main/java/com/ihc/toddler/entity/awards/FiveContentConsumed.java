package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.ContentConsumedValidator;

import static com.ihc.toddler.entity.AwardTier.BRONZE;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class FiveContentConsumed extends Award {
    public FiveContentConsumed(int id) {
        super(id,"5 Aulas", "Parabéns! Você assistiu 5 aulas.", SILVER, new ContentConsumedValidator(5));
    }
}
