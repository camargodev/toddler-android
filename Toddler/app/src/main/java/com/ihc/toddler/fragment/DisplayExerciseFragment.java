package com.ihc.toddler.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ihc.toddler.R;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class DisplayExerciseFragment extends DisplayActivitiesFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activities_display_fragment, container, false);
    }

    @Override
    protected List<AbstractActivity> getActivities() {
        List<AbstractActivity> activities = new ArrayList<>();
        activities.addAll(QuizRepository.getQuizes());
        return activities;
    }

    @Override
    protected void setTitles(TextView next, TextView more) {
        next.setText("Próximo Exercício");
        more.setText("Mais Exercícios");
    }
}