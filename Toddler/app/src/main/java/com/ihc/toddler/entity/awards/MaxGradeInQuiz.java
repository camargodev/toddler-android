package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FiveQuestionsCorrectValidator;
import com.ihc.toddler.validator.MaxGradeValidator;

import static com.ihc.toddler.entity.AwardTier.DIAMOND;
import static com.ihc.toddler.entity.AwardTier.GOLD;
import static com.ihc.toddler.entity.AwardTier.SILVER;

public class MaxGradeInQuiz extends Award {
    public MaxGradeInQuiz(int id) {
        super(id,"Nota máxima", "Parabéns! Você tirou a nota mãxima em um exercício.", DIAMOND, new MaxGradeValidator());
    }
}
