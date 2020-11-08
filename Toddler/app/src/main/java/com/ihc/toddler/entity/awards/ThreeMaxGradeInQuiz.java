package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.MaxGradeValidator;

import static com.ihc.toddler.entity.AwardTier.DIAMOND;

public class ThreeMaxGradeInQuiz extends Award {
    public ThreeMaxGradeInQuiz(int id) {
        super(id,"3 Nota Máximas", "Parabéns! Você tirou a nota mãxima em 3 questionários.", DIAMOND, new MaxGradeValidator(3));
    }
}
