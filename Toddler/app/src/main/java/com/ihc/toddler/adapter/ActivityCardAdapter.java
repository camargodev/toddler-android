package com.ihc.toddler.adapter;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.persistence.ActivityTracker;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class ActivityCardAdapter extends RecyclerView.Adapter<ActivityCardAdapter.ActivityViewHolder> {

    List<AbstractActivity> activities;
    Context originScreen;
    TextToSpeech textToSpeech;
    boolean next;

    public ActivityCardAdapter(List<AbstractActivity> activities, Context originScreen, TextToSpeech textToSpeech) {
        this.activities = activities;
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
    }

    public ActivityCardAdapter(List<AbstractActivity> activities, Context originScreen, TextToSpeech textToSpeech, boolean next) {
        this.activities = activities;
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
        this.next = next;
    }


    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        int layoutId = next ? R.layout.long_card_activity_list_row : R.layout.card_activity_list_row;
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(layoutId, viewGroup, false);
        return new ActivityViewHolder(itemView, position, activities, textToSpeech);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        AbstractActivity activity = activities.get(position);
        int color = ContextCompat.getColor(originScreen, getRandomColorId());
        int gray = ContextCompat.getColor(originScreen, R.color.gray);

        holder.title.setText(activity.getTitle());
//        holder.type.setText(activity.getTypeName());
        if (activity instanceof Quiz) {
            holder.icon.setBackgroundResource(R.drawable.homework);
        }
        if (ActivityTracker.getInstance().isActivityConsumed(activity))
            color = gray;
        holder.topPart.setBackgroundColor(color);
        if (ActivityTracker.getInstance().isActivityConsumed(activity)) {
            holder.icon.setBackgroundResource(R.drawable.correct);
            holder.icon.setBackgroundTintList(AppCompatResources.getColorStateList(originScreen, R.color.gray));
        }
//        holder.type.setText(String.valueOf(activity.getId()));

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView title, type;
        FrameLayout parent, topPart;
        ImageView icon;
        public ActivityViewHolder(View itemView, final int position, final List<AbstractActivity> activities, final TextToSpeech textToSpeech) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            topPart = itemView.findViewById(R.id.top_part);
            title = itemView.findViewById(R.id.activity_title);
            type = itemView.findViewById(R.id.activity_type);
            icon = itemView.findViewById(R.id.small_logo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AbstractActivity activity = activities.get(getAdapterPosition());
                    if (activity instanceof Quiz) {
                        QuizManager manager = QuizManager.getInstance((Quiz) activity);
                        Exercise currentExercise = manager.getCurrentExercise();
                        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);
                        Intent firstQuestion = exerciseView.getIntent(v.getContext());
                        v.getContext().startActivity(firstQuestion);
                    } else {
                        ContentManager.getInstance((Content) activity);
                        Intent firstPart = new Intent(v.getContext(), ContentActivity.class);
                        v.getContext().startActivity(firstPart);
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AbstractActivity activity = activities.get(getAdapterPosition());
                    String toTalk = activity.getTitle();
                    new SpeechManager(textToSpeech).talk(toTalk);
                    return false;
                }
            });
        }
    }
}