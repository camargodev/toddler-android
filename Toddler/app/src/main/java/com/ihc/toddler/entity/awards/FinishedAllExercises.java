package com.ihc.toddler.entity.awards;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.validator.FinishedAllExercisesValidator;
import com.ihc.toddler.validator.MaxGradeValidator;

import static com.ihc.toddler.entity.AwardTier.DIAMOND;
import static com.ihc.toddler.entity.AwardTier.GOLD;

public class FinishedAllExercises extends Award {
    public FinishedAllExercises(int id) {
        super(id,"Terminou Tudo", "Parabéns! Você fez todos os exercícios disponíveis", GOLD, new FinishedAllExercisesValidator());
    }
}
