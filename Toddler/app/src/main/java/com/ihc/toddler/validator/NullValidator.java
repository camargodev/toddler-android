package com.ihc.toddler.validator;

public class NullValidator implements AwardValidator {

    @Override
    public boolean shouldAddAward() {
        return false;
    }
}
