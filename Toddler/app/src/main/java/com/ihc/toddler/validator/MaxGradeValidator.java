package com.ihc.toddler.validator;

import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.persistence.ActivityDataConsumer;

public class MaxGradeValidator implements AwardValidator {

    private int numMaxNotes;

    public MaxGradeValidator(int numMaxNotes) {
        this.numMaxNotes = numMaxNotes;
    }

    @Override
    public boolean shouldAddAward() {
        int maxNotesCounter = 0;
        for (Quiz quiz : ActivityDataConsumer.getAllConsumedQuizes()) {
            if (quiz.getCorrectCount() == quiz.getNumberOfExercises())
                maxNotesCounter += 1;
        }
        return maxNotesCounter >= numMaxNotes;
    }
}
