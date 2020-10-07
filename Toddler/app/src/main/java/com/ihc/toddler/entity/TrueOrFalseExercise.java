package com.ihc.toddler.entity;

import android.widget.Button;
import android.widget.TextView;

import com.ihc.toddler.R;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TrueOrFalseExercise extends Exercise {

    public TrueOrFalseExercise(String question) {
        super(question, 2, Arrays.asList("True", "False"));
    }
}
