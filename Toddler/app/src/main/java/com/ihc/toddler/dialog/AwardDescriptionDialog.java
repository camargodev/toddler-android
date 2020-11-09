package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.adapter.AwardCardAdapter;
import com.ihc.toddler.adapter.AwardDescriptionCardAdapter;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.fragment.DisplayAwardsFragment;
import com.ihc.toddler.manager.SpeechManager;

import org.w3c.dom.Text;

import java.util.List;

public class AwardDescriptionDialog extends Dialog implements View.OnClickListener {

    private Context main;
    private Award award;
    private TextToSpeech textToSpeech;

    public AwardDescriptionDialog(@NonNull Context main, Award award, TextToSpeech textToSpeech) {
        super(main);
        this.main = main;
        this.award = award;
        this.textToSpeech = textToSpeech;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.awards_description_dialog);

        RecyclerView recyclerView = findViewById(R.id.award_description_view);

        AwardDescriptionCardAdapter activityCardAdapter = new AwardDescriptionCardAdapter(main, award, textToSpeech);

        RecyclerView.LayoutManager manager = new GridLayoutManager(main, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(activityCardAdapter);

    }

    @Override
    public void onClick(View v) {
    }
}
