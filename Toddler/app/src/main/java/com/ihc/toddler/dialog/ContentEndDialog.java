package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.fragment.DisplayAwardsFragment;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.persistence.ActivityTracker;

import java.util.List;

public class ContentEndDialog extends Dialog implements View.OnClickListener {

    private ContentActivity activity;
    private Content content;

    public ContentEndDialog(@NonNull ContentActivity activity, Content content) {
        super(activity);
        this.activity = activity;
        this.content = content;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_end_dialog);

        Button goBack = findViewById(R.id.go_back);
        Button goNext = findViewById(R.id.go_next);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityTracker.getInstance().persistActivity(content);
                AwardManager.getInstance().triggerAwardValidations();
                activity.finish();
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {}
}
