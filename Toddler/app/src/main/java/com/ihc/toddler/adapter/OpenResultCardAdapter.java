package com.ihc.toddler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;

public class OpenResultCardAdapter extends RecyclerView.Adapter<OpenResultCardAdapter.OpenResultViewHolder> {

    List<Exercise> exercises;
    DisplayResultsActivity originScreen;
    List<Boolean> revealed = new ArrayList<>();

    public OpenResultCardAdapter(DisplayResultsActivity originScreen, List<Exercise> exercises) {
        this.originScreen = originScreen;
        this.exercises = exercises;
        for (int i = 0; i < exercises.size(); i++) revealed.add(false);
    }

//    public void setOpenExercise(List<Exercise> exercises) {
//        this.exercises = exercises;
//    }

    @NonNull
    @Override
    public OpenResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_highlighted_mux_result, viewGroup, false);
        return new OpenResultViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenResultViewHolder holder, int position) {

        Exercise openExercise = exercises.get(position);

        holder.exerciseNumber.setText("Exercício " + String.valueOf(position+1));
        holder.exerciseQuestion.setText(openExercise.getQuestion().replace("\n"," "));

        if (revealed.get(position))
            setFieldsReveleadAnswer(holder, openExercise);
        else
            setFieldsHiddenAnswer(holder, openExercise);


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

    private void setFieldsHiddenAnswer(OpenResultViewHolder holder, Exercise openExercise) {
        holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.cardColor3));
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
        holder.resultLabel.setVisibility(View.VISIBLE);
        holder.icon.setVisibility(View.VISIBLE);
        if (openExercise.getStatus() == ExerciseStatus.CORRECT) {
            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.correct));
            holder.icon.setBackgroundResource(R.drawable.correct);
            holder.resultLabel.setText("Ebaa =D");
        } else {
            holder.background.setBackgroundColor(ContextCompat.getColor(originScreen, R.color.wrong));
            holder.icon.setBackgroundResource(R.drawable.wrong);
            holder.resultLabel.setText("Oops =(");
        }
        holder.yourAnswer.setText(openExercise.getActualAnswerText());
        holder.correctWas.setText(openExercise.getExpectedAnswerText());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    class OpenResultViewHolder extends RecyclerView.ViewHolder {
        TextView exerciseQuestion, exerciseDescription, exerciseNumber, revealText;
        TextView youAnsweredLabel, yourAnswer, correctWasLabel, correctWas, resultLabel;
        ImageView icon;
//        RelativeLayout background;
        ConstraintLayout background;
        public OpenResultViewHolder(View itemView) {
            super(itemView);
            exerciseQuestion = itemView.findViewById(R.id.exercise_question);
            exerciseNumber = itemView.findViewById(R.id.exercise_number);
            background = itemView.findViewById(R.id.result_highlight_bg);
            revealText = itemView.findViewById(R.id.reveal_result_text);
            youAnsweredLabel = itemView.findViewById(R.id.you_answered_label);
            yourAnswer = itemView.findViewById(R.id.you_answered);
            correctWasLabel = itemView.findViewById(R.id.correct_was_label);
            correctWas = itemView.findViewById(R.id.correct_was);
            icon = itemView.findViewById(R.id.answer_icon);
            resultLabel = itemView.findViewById(R.id.result_label);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (revealed.get(getAdapterPosition())) return;
                    revealed.set(getAdapterPosition(), true);
                    notifyDataSetChanged();
                }
            });
//            exerciseDescription = itemView.findViewById(R.id.result_description);
//            icon = itemView.findViewById(R.id.small_emoticon_bg);
//            background = itemView.findViewById(R.id.colorful_background);
        }
    }
}