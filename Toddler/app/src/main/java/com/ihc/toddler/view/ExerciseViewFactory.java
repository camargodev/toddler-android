package com.ihc.toddler.view;

import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;

public class ExerciseViewFactory {

    public static ExerciseView make(Exercise exercise) {
        if (exercise instanceof MultipleChoiceExercise)
            return new MultipleChoiceView(exercise);
        return new TrueOrFalseView(exercise);
    }


}
