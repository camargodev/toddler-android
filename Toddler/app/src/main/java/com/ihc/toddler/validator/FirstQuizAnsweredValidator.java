package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;
import com.ihc.toddler.persistence.ActivityTracker;

public class FirstQuizAnsweredValidator implements AwardValidator {
    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedQuizes().size() == 0;
    }
}
