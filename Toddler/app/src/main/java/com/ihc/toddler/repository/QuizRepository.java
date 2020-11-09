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
import static com.ihc.toddler.entity.MultipleChoiceExercise.D;
import static com.ihc.toddler.entity.TrueOrFalseExercise.TRUE;
import static com.ihc.toddler.entity.TrueOrFalseExercise.FALSE;

public class QuizRepository {

    private static int id = 0;

    public static List<Quiz> getQuizes() {
        return Arrays.asList(new Quiz(1, getSyllableSeparationQuiz()),
                             new Quiz(2, getWordTypesQuiz()),
                             new Quiz(3, getSyllableType1()),
                             new Quiz(4, getSyllableType2()),
                             new Quiz(5, getSyllableType3()));
    }

    private static Quiz getSyllableSeparationQuiz() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new MultipleChoiceExercise("Quantas sílabas\ntem a palavra\ncamelo?", Arrays.asList("1", "2", "3", "4"), C));
        exercises.add(new TrueOrFalseExercise("As sílabas de PATO\nsão PA e TO?", TRUE));
        exercises.add(new MultipleChoiceExercise("Quais são as\nsílabas de BALÃO?", Arrays.asList("BA-LÃO", "BAL-ÃO", "BALÃ-O", "BA-LÃ-O"), A));
        exercises.add(new TrueOrFalseExercise("CATARATA tem 4 sílabas?", TRUE));
        exercises.add(new TrueOrFalseExercise("A última sílaba de SAPATO\né ATO?", FALSE));
        exercises.add(new MultipleChoiceExercise("Qual é a primeira sílaba\nde CARRO?", Arrays.asList("CA", "CAR", "RRO", "RO"), B));
        return new Quiz("Separação de sílabas", exercises);
    }

    private static Quiz getWordTypesQuiz() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new TrueOrFalseExercise("Uma palavra com\numa sílaba é uma\nunissílaba", FALSE));
        exercises.add(new MultipleChoiceExercise("Se uma palavra é\numa dissílaba, quantas\nsílabas ela tem?", Arrays.asList("1", "2", "3", "4"), B));
        exercises.add(new TrueOrFalseExercise("Uma palavra com 5\nsílabas é uma polissílaba?", TRUE));
        return new Quiz("Tipos de palavras", exercises);
    }

    private static Quiz getSyllableType1() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new MultipleChoiceExercise("Qual é a sílaba tônica\nda palavra CEBOLA?", Arrays.asList("CE", "BO", "BOL", "LA"), B));
        exercises.add(new TrueOrFalseExercise("A palavra mar tem uma sílaba tônica", TRUE));
        return new Quiz("Sílabas tônicas", exercises);
    }

    private static Quiz getSyllableType2() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new TrueOrFalseExercise("Toda palavra tem no mínimo\numa sílaba átona", FALSE));
        exercises.add(new MultipleChoiceExercise("Quantas sílabas átonas\ntem a palavra CEBOLA?", Arrays.asList("0", "1", "2", "3"), C));
        exercises.add(new TrueOrFalseExercise("A palavra sal tem uma sílaba átona", FALSE));
        return new Quiz("Sílabas átonas", exercises);
    }

    private static Quiz getSyllableType3() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(new TrueOrFalseExercise("A sílaba tônica de CÁLICE É LI", FALSE));
        exercises.add(new MultipleChoiceExercise("Quantas são as sílabas átonas\nda palavra PARANÁ?", Arrays.asList("NÁ", "PA E NÁ", "RA e NÁ", "PA e RA"), D));
        exercises.add(new TrueOrFalseExercise("A sílaba átona de JILÓ tem é JI", TRUE));
        return new Quiz("Tonalidade com Acentos", exercises);
    }

}
