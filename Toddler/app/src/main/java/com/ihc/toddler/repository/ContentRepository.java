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
                new Content(5, getWordTypeContent4()),
                new Content(6, getVogalMeets()),
                new Content(7, getSyllableType1()),
                new Content(8, getSyllableType2()),
                new Content(9, getSyllableType3()));
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
        return new Content("Monossílabas", parts);
    }

    private static Content getWordTypeContent2() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Dissílaba" ,
                "É uma palavra com duas sílabas.\n\nExemplo: FE-LIZ\n"));
        return new Content("Dissílabas", parts);
    }

    private static Content getWordTypeContent3() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Trissílaba" ,
                "É palavra com três sílabas.\n\nExemplo: BA-TA-TA\n"));
        return new Content("Trissílabas", parts);
    }

    private static Content getWordTypeContent4() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Tipos de palavras" ,
                "Podemos classificar palavras de acordo " +
                        "com o número de sílabas.\n" +
                        "Os tipos são: monossílaba, dissílaba, trissílaba e polissílaba."));
        parts.add(new ContentPart("Polissílaba" ,
                "É uma palavra com 4 ou mais sílabas.\n\nExemplo: BRA-SI-LEI-RO"));
        return new Content("Polissílabas", parts);
    }

    private static Content getVogalMeets() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("O que é um encontro vocal?" ,
                "É quando, em uma palavra, duas ou mais vogais se encontram.\n" +
                        "Um encontro vocal pode ser um ditongo, um tritongo ou um hiato."));
        parts.add(new ContentPart("Ditongo" ,
                "É o encontro de duas vogais em uma só sílaba." +
                        "\nExemplos: pai (ditongo = AI), mãe (ditongo = ÃE), cenoura (ditongo = OU)"));
        parts.add(new ContentPart("Tritongo" ,
                "É o encontro de três vogais em uma só sílaba." +
                        "\nExemplos: Paraguai (tritongo = UAI), quão (trigonto= UÃO)"));
        parts.add(new ContentPart("Hiato" ,
                "É o encontro de duas vogais em sílabas diferentes." +
                        "\nExemplos: saída (o A e o Í estão em sílabas diferentes)"));
        return new Content("Encontros vocais", parts);
    }

    private static Content getSyllableType1() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("O que é uma sílaba tônica?" ,
                "É a sílaba cuja pronúncia é feita com " +
                        "maior intensidade.\n" +
                        "Sempre há apenas uma sílaba tônica por palavra."));
        parts.add(new ContentPart("Exemplo" ,
                "Na palavra BORBOLETA, as sílabas são: bor-bo-le-ta." +
                        "\nA sílaba tônica é LE, pois é a que mais destacamos ao falar."));
        return new Content("Sílabas Tônicas", parts);
    }

    private static Content getSyllableType2() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("O que é uma sílaba átona?" ,
                "São as sílabas cuja pronúncia é feita com " +
                        "menor intensidade.\n" +
                        "É o contrário da sílaba tônica. " +
                        "Toda sílaba de uma palavra que não a tônica é átona."));
        parts.add(new ContentPart("Exemplo" ,
                "Na palavra BORBOLETA, as sílabas são: bor-bo-le-ta." +
                        "\nAs sílabas tônica é BOR, BO e TA, pois LE é a sílaba tônica, " +
                        "então todas as outras são átonas."));
        return new Content("Sílabas Átonas", parts);
    }

    private static Content getSyllableType3() {
        List<ContentPart> parts = new ArrayList<>();
        parts.add(new ContentPart("Sílabas Tônicas e Acentos" ,
                "Quando uma palavra possui acento grave (ˆ) ou agudo(´), " +
                        "a sílaba que contém esse acento é sempre a tônica.\n" +
                        "Cada palavra só pode ter um sílaba tônica " +
                        "e portanto só pode ter um acento."));
        parts.add(new ContentPart("Exemplo" ,
                "Na palavra ÚLTIMO, as sílabas são: úl-ti-mo." +
                        "\nA sílaba ÚL possui um acento, portanto é a tônica."));
        return new Content("Tonalidade com Acentos", parts);
    }
}
