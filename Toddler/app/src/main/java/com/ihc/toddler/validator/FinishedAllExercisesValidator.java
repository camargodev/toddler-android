package com.ihc.toddler.validator;

import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityDataConsumer;
import com.ihc.toddler.repository.QuizRepository;

public class FinishedAllExercisesValidator implements AwardValidator {
    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedQuizes().size() == QuizRepository.getQuizes().size();
    }
}
