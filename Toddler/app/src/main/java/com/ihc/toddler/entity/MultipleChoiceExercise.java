package com.ihc.toddler.entity;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;

import java.util.List;

public class MultipleChoiceExercise extends Exercise {

    public MultipleChoiceExercise(String question, List<String> answers) {
        super(question, 4, answers);
    }

}
