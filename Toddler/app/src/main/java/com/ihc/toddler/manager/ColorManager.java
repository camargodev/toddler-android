package com.ihc.toddler.manager;

import com.ihc.toddler.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ColorManager {

    static List<Integer> cardColors = Arrays.asList(R.color.cardColor1, R.color.cardColor2, R.color.cardColor3,
            R.color.cardColor4, R.color.cardColor6, R.color.cardColor7);

    static List<Integer> lastColors = new ArrayList<>();
    static final int COLOR_REPETITION_RATIO = 3;

    public static int getRandomColorId() {
        int colorIndex = new Random().nextInt(cardColors.size());

        while (lastColors.contains(colorIndex))
            colorIndex = new Random().nextInt(cardColors.size());

        lastColors.add(colorIndex);
        if (lastColors.size() > COLOR_REPETITION_RATIO)
            lastColors.remove(0);

        return cardColors.get(colorIndex);
    }
}
