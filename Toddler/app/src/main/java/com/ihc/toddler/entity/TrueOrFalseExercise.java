package com.ihc.toddler.entity;

import java.util.Arrays;

public class TrueOrFalseExercise extends Exercise {

    public TrueOrFalseExercise(String question) {
        super(question, 2, Arrays.asList("SIM", "NÃO"));
    }
}
