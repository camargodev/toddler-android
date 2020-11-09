package com.ihc.toddler.manager;

import com.ihc.toddler.R;

import java.util.ArrayList;
import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class SpecificColorManager {

    private static List<Integer> colors = new ArrayList<>();

    public static int getCorrectColor() {
        return R.color.correct;
    }

    public static int getNextActivityColor() {
        return getHighlightedColor();
    }

    public static int getHighlightedColor()  {
        return R.color.highlight;
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

    public static void generateColorList(int size)  {
        colors.clear();
        for (int i = 0; i < size; i++) colors.add(getRandomCardColor());
    }

    public static int getColorForCard(int index) {
        return colors.get(index);
    }
}
