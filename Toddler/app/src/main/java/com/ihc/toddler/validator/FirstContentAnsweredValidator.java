package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;

public class FirstContentAnsweredValidator implements AwardValidator {
    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedContents().size() == 0;
    }
}
