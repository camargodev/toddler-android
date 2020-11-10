package com.ihc.toddler.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.adapter.AwardDescriptionCardAdapter;
import com.ihc.toddler.adapter.HelpItemAdapter;
import com.ihc.toddler.entity.Award;

public class HelpDialog extends Dialog implements View.OnClickListener {

    private MainActivity main;
    private TextToSpeech textToSpeech;

    public HelpDialog(@NonNull MainActivity main, TextToSpeech textToSpeech) {
        super(main);
        this.main = main;
        this.textToSpeech = textToSpeech;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.help_dialog);

        RecyclerView recyclerView = findViewById(R.id.help_item_view);

        HelpItemAdapter adapter = new HelpItemAdapter(main, textToSpeech, this);

        RecyclerView.LayoutManager manager = new GridLayoutManager(main, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
    }
}
