package com.ihc.toddler.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.dialog.AwardDescriptionDialog;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.HelpItem;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.HelpManager;
import com.ihc.toddler.manager.SpeechManager;

import java.util.List;

public class HelpItemAdapter extends RecyclerView.Adapter<HelpItemAdapter.HelpItemViewHolder> {

    MainActivity main;
    TextToSpeech textToSpeech;
    HelpManager helpManager;
    SpeechManager speechManager;

    public HelpItemAdapter(MainActivity main, TextToSpeech textToSpeech) {
        this.main = main;
        this.textToSpeech = textToSpeech;
        this.helpManager = HelpManager.getInstance();
        this.speechManager = new SpeechManager(textToSpeech);
    }

    @NonNull
    @Override
    public HelpItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.help_item, viewGroup, false);
        return new HelpItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpItemViewHolder holder, int position) {
        HelpItem item = helpManager.getCurrentHelpItem();
        holder.title.setText(item.getTitle());
        holder.text.setText(item.getText());
        holder.next.setText(item.getButtonText());

//        speechManager.readWithNormalClick(holder.title);
//        speechManager.readWithNormalClick(holder.text);
//        speechManager.readWithLongClick(holder.next, String.valueOf(holder.next.getText()));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class HelpItemViewHolder extends RecyclerView.ViewHolder {
        TextView title, text;
        Button next;
        public HelpItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.welcome_title);
            text = itemView.findViewById(R.id.explaining_click);
            next = itemView.findViewById(R.id.go_next_help);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (helpManager.isLast())
                        return;
                    helpManager.next();
                    notifyDataSetChanged();
                }
            });

            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speechManager.talk((String) text.getText());
                }
            });

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    speechManager.talk((String) title.getText());
                }
            });

            next.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    speechManager.talk((String) next.getText());
                    return false;
                }
            });

        }
    }
}