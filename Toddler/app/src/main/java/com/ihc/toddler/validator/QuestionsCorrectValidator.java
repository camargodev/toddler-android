package com.ihc.toddler.validator;

import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityDataConsumer;

public class QuestionsCorrectValidator implements AwardValidator {

    private int numQuestions;

    public QuestionsCorrectValidator(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    @Override
    public boolean shouldAddAward() {
        int totalCorrectCount = 0;
        for (Quiz quiz : ActivityDataConsumer.getAllConsumedQuizes()) {
            totalCorrectCount += quiz.getCorrectCount();
        }
        return totalCorrectCount >= numQuestions;
    }
}
