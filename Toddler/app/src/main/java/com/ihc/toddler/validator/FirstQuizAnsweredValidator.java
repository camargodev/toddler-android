package com.ihc.toddler.validator;

public class FirstQuizAnsweredValidator implements AwardValidator {

    private boolean firstQuiz = true;

    @Override
    public boolean shouldAddAward() {
        boolean savedFirst = firstQuiz;
        firstQuiz = false;
        return savedFirst;
    }
}
