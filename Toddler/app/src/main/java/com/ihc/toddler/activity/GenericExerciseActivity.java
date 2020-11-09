package com.ihc.toddler.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import com.ihc.toddler.R;
import com.ihc.toddler.dialog.ContentEndDialog;
import com.ihc.toddler.dialog.QuizEndDialog;
import com.ihc.toddler.dialog.QuizUnfinishedEndDialog;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.manager.ColorManager;
import com.ihc.toddler.manager.QuizManager;
import com.ihc.toddler.manager.SpeechManager;
import com.ihc.toddler.view.ExerciseView;
import com.ihc.toddler.view.ExerciseViewFactory;

import java.util.Locale;

public abstract class GenericExerciseActivity extends GenericActivity {

    protected TextView exerciseTextView;
    protected TextView selectedAnswer;
    protected Button question;
    protected QuizManager quizManager = QuizManager.getInstance();
    protected ExerciseView exerciseView;
    protected Button nextButton, previousButton;
    protected Integer unselectedColor = ColorManager.getRandomColorId();
    protected Integer selectedColor = ColorManager.getRandomColorId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Exercise currentExercise = quizManager.getCurrentExercise();
        exerciseView = ExerciseViewFactory.make(currentExercise);

        setContentView(exerciseView.getLayoutId());


        mapLayout();
        setCurrentExerciseText();
        clearAnswerButtons();
        if (quizManager.isCurrentExerciseAnswered())
            setExerciseAsAnswered();

        if (quizManager.isFirstExercise()) hidePreviousButton();

        exerciseView.mapQuestion(question);

        question.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
        nextButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
        previousButton.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));


        speechManager.readWithNormalClick(exerciseTextView);
        speechManager.readWithLongClick(nextButton, "Próximo");
        speechManager.readWithLongClick(previousButton, "Anterior");
        speechManager.readWithNormalClick(selectedAnswer);

//        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if(status != TextToSpeech.ERROR)
//                    textToSpeech.setLanguage(new Locale("pt", "BR"));
//            }
//        });
//        speechManager = new SpeechManager(textToSpeech);
    }

    protected void hidePreviousButton() {
        previousButton.setVisibility(View.GONE);
    }

    protected void submitAnswer(Button button, Integer answer) {
        clearAnswerButtons();
        quizManager.submitAnswer(answer);
        markAsAnswered(button);
    }

    protected void markAsAnswered(Button button) {

        button.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
//        button.setBackgroundResource(R.drawable.selected_button);
        button.setTextColor(getResources().getColor(R.color.colorAccent));
        int answerIndex = quizManager.getCurrentAnswer() - 1;
        String selectedAnswerText = quizManager.getCurrentExercise().getAnswers().get(answerIndex);
        String text = "RESPOSTA SELECIONADA: " + selectedAnswerText;
        selectedAnswer.setText(text);
        speechManager.readWithNormalClick(selectedAnswer);
    }

    protected void goToPrevious() {
        Exercise previousExercise = quizManager.goToPrevious().getCurrentExercise();
        ExerciseView previousExerciseView = ExerciseViewFactory.make(previousExercise);
        Intent previousExerciseIntent = previousExerciseView.getIntent(this);
        finish();
        startActivity(previousExerciseIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void goToNext() {

            if (quizManager.isLastExercise()) {
                if (quizManager.getNumberOfExercises() != quizManager.getQuiz().getAnsweredCount()) {

                    QuizUnfinishedEndDialog dialog = new QuizUnfinishedEndDialog(this, textToSpeech);
                    dialog.show();

//                    new AlertDialog.Builder(this, R.style.AlertDialogTheme)
//                            .setTitle("Pera lá")
//                            .setMessage("Esse é o último exercício e você ainda não respondeu todos. " +
//                                    "Antes de continuar, garanta que todos estão respondidos.")
//
//                            .setPositiveButton("Ok", null)
//                            .setIcon(R.drawable.small_logo)
//                            .show();
                    return;

                } else {

                    QuizEndDialog dialog = new QuizEndDialog(this, textToSpeech);
                    dialog.show();
//                    new AlertDialog.Builder(this, R.style.AlertDialogTheme)
//                            .setTitle("Acabou?")
//                            .setMessage("Você tem certeza que não quer mudar a resposta de nenhum exercício?")
//
//                            .setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                                Intent resultsIntent = new Intent(getApplicationContext(), DisplayResultsActivity.class);
//                                                finish();
//                                                startActivity(resultsIntent);
//                                }
//                            })
//
//                            // A null listener allows the button to dismiss the dialog and take no further action.
//                            .setNegativeButton("Voltar", null)
//                            .setIcon(R.drawable.small_logo)
//                            .show();
                    return;

                }
            }



        Exercise nextExercise = quizManager.goToNext().getCurrentExercise();
        ExerciseView nextExerciseView = ExerciseViewFactory.make(nextExercise);
        Intent nextExerciseIntent = nextExerciseView.getIntent(this);
        finish();
        startActivity(nextExerciseIntent);
        this.overridePendingTransition(0, 0);
    }

    protected void readQuestion() {
        String toSpeak = question.getText().toString();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
    }

    protected void mapLayout() {
        exerciseTextView = findViewById(R.id.exercise_number);
        selectedAnswer = findViewById(R.id.selected_answer);
        question = findViewById(R.id.talk);
        nextButton = findViewById(R.id.next);
        previousButton = findViewById(R.id.previous);
    }

    protected void setCurrentExerciseText() {
        int current = quizManager.getCurrentExerciseNumber();
        int total = quizManager.getNumberOfExercises();
        String text = "EXERCÍCIO " + current + " DE " + total;
        exerciseTextView.setText(text);
        exerciseTextView.setBackgroundTintList(AppCompatResources.getColorStateList(this, selectedColor));
    }

    protected void setExerciseAsAnswered() {
        int answer = quizManager.getCurrentAnswer();
        markButtonExercise(answer);
    }

    protected void clearAnswerButton(Button button) {
        button.setBackgroundTintList(AppCompatResources.getColorStateList(this, R.color.notAnswered));
//        button.setBackgroundResource(R.drawable.unselected_button);
//        button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        button.setTextColor(getResources().getColor(R.color.colorAccent));
    }

    protected abstract void clearAnswerButtons();
    protected abstract void markButtonExercise(int answer);

}