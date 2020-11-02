package com.ihc.toddler.repository;

import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.ContentPart;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.MultipleChoiceExercise;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.entity.TrueOrFalseExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentRepository {

    public static List<Content> getContents() {
        return Arrays.asList(new Content(1, getSyllableSeparationContent()),
                new Content(2, getWordTypeContent1()),
                new Content(3, getWordTypeContent2()),
                new Content(4, getWordTypeContent3()),
                new Content(5, getWordTypeContent4()));
    }

    private static Content getSyllableSeparationContent() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("O que é uma sílaba?",
                "Uma sílaba é uma parte de uma palavra. " +
                        "Uma sílaba é formada por uma ou mais letras " +
                        "e no português, sempre possui uma vogal.\n\n" +
                        "Relembrando: as vogais são\nA, E, I, O e U"));
        parts.add(new ContentPart("Separação de sílabas",
                "As sílabas são separadas por um tracinho (-).\n\n" +
                        "Exemplos:\nFELIZ = FE - LIZ\n" +
                        "BANANA = BA - NA - NA"));
        return new Content("Separação de sílabas", parts);
    }

    private static Content getWordTypeContent1() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Monossílaba" ,
                "É uma palavra com apenas uma sílaba.\n\nExemplo: MAR\n"));
        return new Content("Tipos de palavras 1", parts);
    }

    private static Content getWordTypeContent2() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Dissílaba" ,
                "É uma palavra com duas sílabas.\n\nExemplo: FE-LIZ\n"));
        return new Content("Tipos de palavras 2", parts);
    }

    private static Content getWordTypeContent3() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Trissílaba" ,
                "É palavra com três sílabas.\n\nExemplo: BA-TA-TA\n"));
        return new Content("Tipos de palavras 3", parts);
    }

    private static Content getWordTypeContent4() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Polissílaba" ,
                "É uma palavra com 4 ou mais sílabas.\n\nExemplo: BRA-SI-LEI-RO"));
        return new Content("Tipos de palavras 4", parts);
    }
}
