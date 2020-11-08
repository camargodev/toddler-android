package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;

public class QuizAnsweredValidator implements AwardValidator {

    private int quizAnswered;

    public QuizAnsweredValidator(int quizAnswered) {
        this.quizAnswered = quizAnswered;
    }

    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedQuizes().size() >= quizAnswered;
    }
}
