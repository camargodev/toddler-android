package com.ihc.toddler.entity;

import java.util.Arrays;

public class TrueOrFalseExercise extends Exercise {

    public static final int TRUE = 1, FALSE = 2;

    public TrueOrFalseExercise(String question, int answer) {
        super(question, 2, Arrays.asList("SIM", "NÃO"), answer);
    }
}
