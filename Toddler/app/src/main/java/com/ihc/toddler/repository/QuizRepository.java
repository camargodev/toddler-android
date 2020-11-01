package com.ihc.toddler.repository;

import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.entity.TrueOrFalseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.ihc.toddler.entity.MultipleChoiceExercise.A;
import static com.ihc.toddler.entity.MultipleChoiceExercise.B;
import static com.ihc.toddler.entity.MultipleChoiceExercise.C;
import static com.ihc.toddler.entity.TrueOrFalseExercise.TRUE;
import static com.ihc.toddler.entity.TrueOrFalseExercise.FALSE;

public class QuizRepository {

    private static int id = 0;

    public static List<Quiz> getQuizes() {
        return Arrays.asList(new Quiz(1, getSyllableSeparationQuiz()), new Quiz(2, getWordTypesQuiz()));
    }

    private static Quiz getSyllableSeparationQuiz() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new MultipleChoiceExercise("Quantas sílabas\ntem a palavra\ncamelo?", Arrays.asList("1", "2", "3", "4"), C));
        exercises.add(new TrueOrFalseExercise("As sílabas de PATO\nsão PA e TO?", TRUE));
        exercises.add(new MultipleChoiceExercise("Quais são as\nsílabas de AMOR?", Arrays.asList("AM-OR", "AMOR", "A-MOR", "AMO-R"), A));
        return new Quiz("Separação de sílabas", exercises);
    }

    private static Quiz getWordTypesQuiz() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new TrueOrFalseExercise("Uma palavra com\numa sílaba é uma\nunissílaba", FALSE));
        exercises.add(new MultipleChoiceExercise("Se uma palavra é\numa dissílaba, quantas\nsílabas ela tem?", Arrays.asList("1", "2", "3", "4"), B));
        exercises.add(new TrueOrFalseExercise("Uma palavra com 5\nsílabas é uma polissílaba?", TRUE));
        return new Quiz("Tipos de palavras", exercises);
    }

}
