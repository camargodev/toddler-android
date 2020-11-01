package com.ihc.toddler.validator;

import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityDataConsumer;

public class FiveQuestionsCorrectValidator implements AwardValidator {
    @Override
    public boolean shouldAddAward() {
        int totalCorrectCount = 0;
        for (Quiz quiz : ActivityDataConsumer.getAllConsumedQuizes()) {
            totalCorrectCount += quiz.getCorrectCount();
        }
        return totalCorrectCount >= 5;
    }
}
