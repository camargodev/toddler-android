package com.ihc.toddler.validator;

import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityDataConsumer;

public class MaxGradeValidator implements AwardValidator {
    @Override
    public boolean shouldAddAward() {
        for (Quiz quiz : ActivityDataConsumer.getAllConsumedQuizes()) {
            if (quiz.getCorrectCount() == quiz.getNumberOfExercises())
                return true;
        }
        return false;
    }
}
