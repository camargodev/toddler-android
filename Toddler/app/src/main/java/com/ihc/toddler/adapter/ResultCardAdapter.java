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
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.manager.ContentManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.repository.QuizRepository;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class ResultCardAdapter extends RecyclerView.Adapter<ResultCardAdapter.QuizViewHolder> {

    Quiz quiz;
    Context originScreen;
    TextToSpeech textToSpeech;

    public ResultCardAdapter(Quiz quiz, Context originScreen, TextToSpeech textToSpeech) {
        this.quiz = quiz;
        this.originScreen = originScreen;
        this.textToSpeech = textToSpeech;
    }

    @NonNull
    @Override
    public QuizViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_activity_list_row, viewGroup, false);
        return new QuizViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizViewHolder holder, int position) {
        Exercise exercise = quiz.getExercises().get(position);
        int color = ContextCompat.getColor(originScreen, getRandomColorId());

        holder.topPart.setBackgroundColor(color);
        holder.description.setText(exercise.getQuestion());
        holder.number.setText("Exercise " + (position+1));
    }

    @Override
    public int getItemCount() {
        return quiz.getNumberOfExercises();
    }

    static class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView number, description;
        FrameLayout parent, topPart;
        public QuizViewHolder(View itemView) {
            super(itemView);
            topPart = itemView.findViewById(R.id.exercise_top_part);
            number = itemView.findViewById(R.id.exercise_number);
            description = itemView.findViewById(R.id.exercise_description);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    AbstractActivity activity = activities.get(getAdapterPosition());
//                    if (activity instanceof Quiz) {
//                        Quiz quiz = QuizRepository.getQuiz();
//                        QuizManager manager = QuizManager.getInstance(quiz);
//
//                        Exercise currentExercise = manager.getCurrentExercise();
//                        ExerciseView exerciseView = ExerciseViewFactory.make(currentExercise);
//                        Intent firstQuestion = exerciseView.getIntent(v.getContext());
//                        v.getContext().startActivity(firstQuestion);
//                    } else {
//                        ContentManager.getInstance((Content) activity);
//                        Intent firstPart = new Intent(v.getContext(), ContentActivity.class);
//                        v.getContext().startActivity(firstPart);
//                    }
//                }
//            });
//
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    AbstractActivity activity = activities.get(getAdapterPosition());
//                    String toTalk = activity.getTypeName() + "   " + activity.getTitle();
//                    new SpeechManager(textToSpeech).talk(toTalk);
//                    return false;
//                }
//            });
        }
    }
}