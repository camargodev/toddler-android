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
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.entity.HelpItem;
import com.ihc.toddler.manager.AwardManager;
import com.ihc.toddler.manager.HelpManager;

import java.util.List;

public class HelpItemAdapter extends RecyclerView.Adapter<HelpItemAdapter.HelpItemViewHolder> {

    List<Award> awards;
    MainActivity main;
    TextToSpeech textToSpeech;

    public HelpItemAdapter(MainActivity main, List<Award> awards, TextToSpeech textToSpeech) {
        this.awards = awards;
        this.main = main;
        this.textToSpeech = textToSpeech;
    }

    @NonNull
    @Override
    public HelpItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_award_list_row, viewGroup, false);
        return new HelpItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HelpItemViewHolder holder, int position) {
        HelpItem item = HelpManager.getInstance().getCurrentHelpItem();
        holder.text.setText(item.getText());
        holder.title.setText(item.getTitle());
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

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AwardDescriptionDialog dialog = new AwardDescriptionDialog(originScreen, awards.get(getAdapterPosition()), textToSpeech);
//                    dialog.show();
//                }
//            });
        }
    }
}