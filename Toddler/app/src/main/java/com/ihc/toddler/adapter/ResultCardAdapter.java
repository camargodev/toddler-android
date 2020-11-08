package com.ihc.toddler.adapter;

import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
import com.ihc.toddler.activity.DisplayResultsActivity;
import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.ExerciseStatus;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.repository.QuizRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.ArrayList;
import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class ResultCardAdapter extends RecyclerView.Adapter<ResultCardAdapter.QuizViewHolder> {

    Quiz quiz;
    DisplayResultsActivity originScreen;
    TextToSpeech textToSpeech;
    List<Boolean> areQuestionsRevealed;

    public ResultCardAdapter(Quiz quiz, DisplayResultsActivity originScreen, TextToSpeech textToSpeech) {
        this.quiz = quiz;
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
        this.areQuestionsRevealed = new ArrayList<>();
        for (int i = 0; i <quiz.getNumberOfExercises(); i++)
            this.areQuestionsRevealed.add(false);
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_result_list_row, viewGroup, false);
        return new QuizViewHolder(itemView, originScreen, textToSpeech);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {

        holder.resultExerciseNumber.setText(String.valueOf(position+1));

        if (!areQuestionsRevealed.get(position)) {
            int color = ContextCompat.getColor(originScreen, R.color.gray);
            holder.background.setBackgroundColor(color);
            return;
        }

        Exercise exercise = quiz.getExercises().get(position);

        int color, icon;

        if (exercise.getStatus().equals(ExerciseStatus.CORRECT)) {
            color = ContextCompat.getColor(originScreen, R.color.correct);
            icon = R.drawable.correct;
        } else {
            color = ContextCompat.getColor(originScreen, R.color.wrong);
            icon = R.drawable.wrong;
        }

        holder.background.setBackgroundColor(color);
        holder.resultIcon.setBackgroundResource(icon);

    }

    @Override
    public int getItemCount() {
        return quiz.getNumberOfExercises();
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView interrogationPoint, resultExerciseNumber;
        ImageView resultIcon;
        ConstraintLayout background;
        public QuizViewHolder(View itemView, final DisplayResultsActivity originScreen, final TextToSpeech textToSpeech) {
            super(itemView);

            interrogationPoint = itemView.findViewById(R.id.hidden_result_text);
            resultIcon = itemView.findViewById(R.id.result_icon);
            background = itemView.findViewById(R.id.result_background);
            resultExerciseNumber = itemView.findViewById(R.id.result_exercise_number);

            interrogationPoint.setVisibility(View.VISIBLE);
            resultIcon.setVisibility(View.INVISIBLE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getLayoutPosition();
                    if (!areQuestionsRevealed.get(position)) {
                        areQuestionsRevealed.set(position, true);
                        interrogationPoint.setVisibility(View.INVISIBLE);
                        resultIcon.setVisibility(View.VISIBLE);
                        notifyDataSetChanged();
                    } else {
//                        new SpeechManager(textToSpeech).talk(description.getText().toString());
                    }

//                    originScreen.getOpenResultCardAdapter().setOpenExercise(QuizManager.getInstance().getQuiz().getExercises().get(position));
                    originScreen.getOpenResultCardAdapter().notifyDataSetChanged();
                }
            });
        }
    }
}