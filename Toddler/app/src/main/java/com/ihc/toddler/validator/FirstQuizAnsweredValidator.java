package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;

public class FirstQuizAnsweredValidator implements AwardValidator {

    private static final int FIRST = 1;

    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedQuizes().size() == FIRST;
    }
}
