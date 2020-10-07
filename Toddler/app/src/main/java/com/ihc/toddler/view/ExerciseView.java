package com.ihc.toddler.view;

import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public interface ExerciseView {

    int getLayoutId();
    void mapQuestion(TextView textView);
    void mapAnswers(List<Button> buttons) throws Exception;
}
