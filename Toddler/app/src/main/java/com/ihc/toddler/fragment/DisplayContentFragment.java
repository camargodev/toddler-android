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
import com.ihc.toddler.entity.ActivitiesStats;
import com.ihc.toddler.persistence.ActivityDataConsumer;
import com.ihc.toddler.repository.ContentRepository;

import java.util.ArrayList;
import java.util.List;

public class DisplayContentFragment extends DisplayActivitiesFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activities_display_fragment, container, false);
    }

    @Override
    protected List<AbstractActivity> getActivities() {
        List<AbstractActivity> activities = new ArrayList<>();
        activities.addAll(ContentRepository.getContents());
        return activities;
    }

    @Override
    protected void setTitles(TextView next, TextView more) {
        next.setText("Próxima Aula");
        more.setText("Mais Aulas");
    }

    @Override
    protected String getLabel() {
        return "aulas";
    }

    @Override
    protected ActivitiesStats getStats() {
        return ActivityDataConsumer.getContentStats();
    }

    @Override
    protected String getSwitchText() {
        return "Mostrar aulas já assistidas";
    }

    @Override
    protected String getAlreadyDoneTextToSpeak(int num) {
        return "Você já assistiu " + num + " aulas";
    }

    @Override
    protected String getLeftTextToSpeak(int num) {
        return "Faltam " + num + " aulas";
    }


}