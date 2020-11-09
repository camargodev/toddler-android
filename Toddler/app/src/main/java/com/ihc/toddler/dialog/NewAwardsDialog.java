package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.fragment.DisplayAwardsFragment;
import com.ihc.toddler.repository.AwardRepository;

import java.util.List;

public class NewAwardsDialog extends Dialog implements View.OnClickListener {

    private MainActivity main;
    private List<Award> awards;
    private TextToSpeech textToSpeech;

    public NewAwardsDialog(@NonNull MainActivity main, List<Award> awards , TextToSpeech textToSpeech) {
        super(main);
        this.main = main;
        this.awards = awards;
        this.textToSpeech = textToSpeech;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.awards_achieved_dialog);

        Button goToAwards = findViewById(R.id.go_to_my_awards);
        TextView newAwardsTitle = findViewById(R.id.new_awards_title);

        goToAwards.setOnClickListener(this);
        newAwardsTitle.setText(buildTitle());

        RecyclerView recyclerView = findViewById(R.id.new_awards_view);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(main, awards, textToSpeech);

        RecyclerView.LayoutManager manager = new GridLayoutManager(main, 3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_to_my_awards) {
            main.setFragment(new DisplayAwardsFragment(), MainActivity.AWARDS);
            dismiss();
        }
    }

    private String buildTitle() {
        if (awards.size() > 1) return awards.size() +  " novas conquistas";
        return awards.size() +  " nova conquista";
    }
}
