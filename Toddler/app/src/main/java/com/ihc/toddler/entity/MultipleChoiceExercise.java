package com.ihc.toddler.entity;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;

import java.util.List;

public class MultipleChoiceExercise extends Exercise {

    public static final int A = 1, B = 2, C = 3, D = 4;

    public MultipleChoiceExercise(String question, List<String> answers, int answer) {
        super(question, 4, answers, answer);
    }

}
