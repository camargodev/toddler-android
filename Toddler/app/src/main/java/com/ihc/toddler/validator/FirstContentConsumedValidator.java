package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;

public class FirstContentConsumedValidator implements AwardValidator {

    private static final int FIRST = 1;

    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedContents().size() == FIRST;
    }
}
