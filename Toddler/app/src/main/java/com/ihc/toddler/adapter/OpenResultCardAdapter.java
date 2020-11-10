package com.ihc.toddler.adapter;

import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.DisplayResultsActivity;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.ExerciseStatus;
import com.ihc.toddler.manager.ColorManager;
import com.ihc.toddler.manager.ResultOpeningManager;
import com.ihc.toddler.manager.SpeechManager;

import java.util.ArrayList;
import java.util.List;

public class OpenResultCardAdapter extends RecyclerView.Adapter<OpenResultCardAdapter.OpenResultViewHolder> {

//    List<Exercise> exercises;
    Exercise exercise;
    DisplayResultsActivity originScreen;
    SpeechManager manager;
    int color;
//    ResultOpeningManager manager = ResultOpeningManager.getInstance();
//    List<Integer> colors = new ArrayList<>();

    public OpenResultCardAdapter(DisplayResultsActivity originScreen, TextToSpeech textToSpeech) {
        this.originScreen = originScreen;
        this.manager = new SpeechManager(textToSpeech);
//        this.exercises = exercises;
//        manager.init(exercises.size());
//        for (int i =0; i < exercises.size(); i++) colors.add(ColorManager.getRandomColorId());
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OpenResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_highlighted_mux_result, viewGroup, false);
        return new OpenResultViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenResultViewHolder holder, int position) {

        if (exercise == null) return;

        Exercise openExercise = exercise;

        holder.exerciseQuestion.setText(openExercise.getQuestion().replace("\n"," "));
        holder.entireBackground.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.colorAccent));
        holder.revealText.setTextColor(ContextCompat.getColor(originScreen, R.color.cardColor3));

//        if (manager.isOpened(position))
        setFieldsReveleadAnswer(holder, openExercise);

        manager.readWithNormalClick(holder.exerciseQuestion);

        String yourAnswer = holder.youAnsweredLabel.getText() + " " + holder.yourAnswer.getText();
        String correctWas = holder.correctWasLabel.getText() + " " + holder.correctWas.getText();

        manager.readWithNormalClick(holder.youAnsweredLabel, yourAnswer);
        manager.readWithNormalClick(holder.yourAnswer, yourAnswer);
        manager.readWithNormalClick(holder.correctWasLabel, correctWas);
        manager.readWithNormalClick(holder.correctWas, correctWas);


//        else
//            setFieldsHiddenAnswer(holder, openExercise, colors.get(position));


//        originScreen.getOpenResultView().setVisibility(View.VISIBLE);
//
//        holder.exerciseQuestion.setText(openExercise.getQuestion());
//
//        if (openExercise.getStatus() == ExerciseStatus.CORRECT) {
//            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.correct));
//            holder.icon.setBackgroundResource(R.drawable.correct);
//            holder.exerciseDescription.setText("Voce acertou");
//        } else {
//            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.wrong));
//            holder.icon.setBackgroundResource(R.drawable.wrong);
//            holder.exerciseDescription.setText("Voce errou");
//        }
    }

    private void setFieldsHiddenAnswer(OpenResultViewHolder holder, Exercise openExercise, int colorId) {
        holder.entireBackground.setBackgroundColor(ContextCompat.getColor(originScreen, colorId));
        holder.revealText.setTextColor(colorId);
        holder.revealText.setVisibility(View.VISIBLE);
        holder.youAnsweredLabel.setVisibility(View.GONE);
        holder.yourAnswer.setVisibility(View.GONE);
        holder.correctWasLabel.setVisibility(View.GONE);
        holder.correctWas.setVisibility(View.GONE);
        holder.resultLabel.setVisibility(View.GONE);
        holder.icon.setVisibility(View.GONE);
    }

    private void setFieldsReveleadAnswer(OpenResultViewHolder holder, Exercise openExercise) {
        holder.revealText.setVisibility(View.GONE);

        holder.youAnsweredLabel.setVisibility(View.VISIBLE);
        holder.yourAnswer.setVisibility(View.VISIBLE);
        holder.correctWasLabel.setVisibility(View.VISIBLE);
        holder.correctWas.setVisibility(View.VISIBLE);
//        holder.resultLabel.setVisibility(View.VISIBLE);
        holder.icon.setVisibility(View.VISIBLE);
        if (openExercise.getStatus() == ExerciseStatus.CORRECT) {
            holder.entireBackground.setBackgroundColor(ContextCompat.getColor(originScreen, color));
            holder.icon.setBackgroundResource(R.drawable.correct);
            holder.resultLabel.setText("Ebaa =D");
        } else {
            holder.entireBackground.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.gray));
            holder.icon.setBackgroundResource(R.drawable.wrong);
            holder.resultLabel.setText("Oops =(");
        }
        holder.yourAnswer.setText(openExercise.getActualAnswerText());
        holder.correctWas.setText(openExercise.getExpectedAnswerText());



    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class OpenResultViewHolder extends RecyclerView.ViewHolder {
        TextView exerciseQuestion, exerciseDescription, exerciseNumber;
        Button revealText;
        TextView youAnsweredLabel, yourAnswer, correctWasLabel, correctWas, resultLabel;
        ImageView icon;
//        RelativeLayout background;
        ConstraintLayout background, entireBackground;
        public OpenResultViewHolder(View itemView) {
            super(itemView);
            exerciseQuestion = itemView.findViewById(R.id.exercise_question);
            exerciseNumber = itemView.findViewById(R.id.exercise_number);
            background = itemView.findViewById(R.id.result_highlight_bg);
            entireBackground = itemView.findViewById(R.id.result_background);
            revealText = itemView.findViewById(R.id.reveal_result_button);
            youAnsweredLabel = itemView.findViewById(R.id.you_answered_label);
            yourAnswer = itemView.findViewById(R.id.you_answered);
            correctWasLabel = itemView.findViewById(R.id.correct_was_label);
            correctWas = itemView.findViewById(R.id.correct_was);
            icon = itemView.findViewById(R.id.answer_icon);
            resultLabel = itemView.findViewById(R.id.result_label);
//            revealText.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(manager.isOpened(getAdapterPosition())) return;
//                    manager.open(getAdapterPosition());
//                    notifyDataSetChanged();
//                    originScreen.getResultsAdapter().notifyDataSetChanged();
//                }
//            });
        }
    }

    public void setColor(int color) {
        this.color = color;
    }
}