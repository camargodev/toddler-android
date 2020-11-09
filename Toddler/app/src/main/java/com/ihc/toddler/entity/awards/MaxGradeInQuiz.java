package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.MaxGradeValidator;

import static com.ihc.toddler.entity.AwardTier.DIAMOND;
import static com.ihc.toddler.entity.AwardTier.GOLD;

public class MaxGradeInQuiz extends Award {
    public MaxGradeInQuiz(int id) {
        super(id,"1 Nota Máxima", "Parabéns! Você tirou a nota mãxima em um questionário.", GOLD, new MaxGradeValidator(1));
    }
}
