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
import static com.ihc.toddler.entity.TrueOrFalseExercise.TRUE;
import static com.ihc.toddler.entity.TrueOrFalseExercise.FALSE;

public class QuizRepository {

    public static Quiz getQuiz() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new MultipleChoiceExercise("Quantas sílabas\ntem a palavra\nCASA?", Arrays.asList("1", "2", "3", "4"), B));
        exercises.add(new TrueOrFalseExercise("As sílabas de PATO\nsão PA e TO?", TRUE));
        exercises.add(new TrueOrFalseExercise("AMIGO tem\n2 sílabas?", FALSE));
        exercises.add(new MultipleChoiceExercise("Quais são as\nsílabas de AMOR?", Arrays.asList("AM-OR", "AMOR", "A-MOR", "AMO-R"), A));
        exercises.add(new MultipleChoiceExercise("Se uma palavra é\numa dissílaba, quantas\nletras ela tem?", Arrays.asList("1", "2", "3", "4"), B));
        exercises.add(new TrueOrFalseExercise("Uma palavra com 5\nsílabas é uma polissílaba?", TRUE));
        return new Quiz("Separação de sílabas", exercises);
    }
}
