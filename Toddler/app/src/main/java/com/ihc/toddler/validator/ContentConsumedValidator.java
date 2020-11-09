package com.ihc.toddler.validator;

import com.ihc.toddler.persistence.ActivityDataConsumer;

public class ContentConsumedValidator implements AwardValidator {

    private int numContents;

    public ContentConsumedValidator(int numContents) {
        this.numContents = numContents;
    }

    @Override
    public boolean shouldAddAward() {
        return ActivityDataConsumer.getAllConsumedContents().size() >= numContents;
    }
}
