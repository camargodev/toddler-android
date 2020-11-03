package com.ihc.toddler.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.repository.AwardRepository;

import java.util.List;

public class NewAwardsDialog extends Dialog implements View.OnClickListener {

    private MainActivity main;
    private Button goToAwards;
    private List<Award> awards;

    public NewAwardsDialog(@NonNull MainActivity main, List<Award> awards) {
        super(main);
        this.main = main;
        this.awards = awards;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.awards_achieved_dialog);
        goToAwards = findViewById(R.id.go_to_my_awards);
        goToAwards.setOnClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.new_awards_view);

        AwardCardAdapter activityCardAdapter = new AwardCardAdapter(main, awards);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(main, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.go_to_my_awards) {
            Toast.makeText(main, "Will go to my awards", Toast.LENGTH_SHORT).show();
            dismiss();
        }
    }
}
