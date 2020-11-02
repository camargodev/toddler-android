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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ihc.toddler.R;
import com.ihc.toddler.activity.ContentActivity;
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
    Context originScreen;
    TextToSpeech textToSpeech;
    List<Boolean> areQuestionsRevealed;

    public ResultCardAdapter(Quiz quiz, Context originScreen, TextToSpeech textToSpeech) {
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
        return new QuizViewHolder(itemView, textToSpeech);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        if (!areQuestionsRevealed.get(position)) {
            int color = ContextCompat.getColor(originScreen, R.color.gray);
            holder.topPart.setBackgroundColor(color);
            return;
        }

        Exercise exercise = quiz.getExercises().get(position);
        Integer selectedAnswer = quiz.getAnswers().get(position);

        String questionHeader = (position+1) + ": "+ exercise.getQuestion().replace("\n", " ");
        holder.number.setText(questionHeader);

        if (exercise.getStatus().equals(ExerciseStatus.CORRECT)) {
            int color = ContextCompat.getColor(originScreen, R.color.correct);
            holder.topPart.setBackgroundColor(color);
            holder.emoticon.setText(":)");
            String correctString = "Você acertou! A resposta é: " + exercise.getAnswers().get(exercise.getAnswer()-1);
            holder.description.setText(correctString);
        } else {
            int color = ContextCompat.getColor(originScreen, R.color.wrong);
            holder.topPart.setBackgroundColor(color);
            holder.emoticon.setText(":(");
            String incorrectString = "Poxa, você marcou " + exercise.getAnswers().get(selectedAnswer-1)
                    +   " e o correto é " + exercise.getAnswers().get(exercise.getAnswer()-1);
            holder.description.setText(incorrectString);
        }

    }

    @Override
    public int getItemCount() {
        return quiz.getNumberOfExercises();
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView number, description, emoticon, interrogationPoint;
        FrameLayout parent, topPart;
        ImageView emoticonBackground;
        public QuizViewHolder(View itemView, final TextToSpeech textToSpeech) {
            super(itemView);

            topPart = itemView.findViewById(R.id.exercise_top_part);
            number = itemView.findViewById(R.id.exercise_number);
            description = itemView.findViewById(R.id.exercise_description);
            emoticon = itemView.findViewById(R.id.small_emoticon);
            interrogationPoint = itemView.findViewById(R.id.hidden_result_text);
            emoticonBackground = itemView.findViewById(R.id.small_emoticon_bg);

            interrogationPoint.setVisibility(View.VISIBLE);
            emoticon.setVisibility(View.INVISIBLE);
            description.setVisibility(View.INVISIBLE);
            number.setVisibility(View.INVISIBLE);
            emoticonBackground.setVisibility(View.INVISIBLE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int position = getLayoutPosition();
                    if (!areQuestionsRevealed.get(position)) {
                        areQuestionsRevealed.set(position, true);
                        interrogationPoint.setVisibility(View.INVISIBLE);
                        emoticon.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                        number.setVisibility(View.VISIBLE);
                        emoticonBackground.setVisibility(View.VISIBLE);
                        notifyDataSetChanged();
                    } else {
                        new SpeechManager(textToSpeech).talk(description.getText().toString());
                    }
                }
            });
        }
    }
}