package com.ihc.toddler.manager;

import com.ihc.toddler.R;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class SpecificColorManager {


    public static int getCorrectColor() {
        return R.color.correct;
    }

    public static int getNextActivityColor() {
        return R.color.cardColor6;
    }

    public static int getAlreadyDoneColor() {
        return R.color.correct;
    }

    public static int getLeftColor() {
        return R.color.wrong;
    }

    public static int getRandomCardColor() {
        int color = ColorManager.getRandomColorId();
        while (color == getNextActivityColor())
            color = ColorManager.getRandomColorId();
        return color;
    }
}
