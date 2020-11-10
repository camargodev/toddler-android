package com.ihc.toddler.manager;

import com.ihc.toddler.R;

import java.util.ArrayList;
import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class SpecificColorManager  {

    private static List<Integer> colors = new ArrayList<>();
    private static int last = 0;
    private final static boolean colorful  = false;

    public static int getWrongColor() {
        if (colorful)
            return R.color.gray;
        return R.color.wrong;
    }

    public static int getCorrectColor() {
        if (colorful)
            return getRandomCardColor();
        return R.color.correct;
    }

    public static int getNextActivityColor() {
        return getHighlightedColor();
    }

    public static int getHighlightedColor()  {
        if (colorful)
            return getRandomCardColor();
        return R.color.highlight;
    }

    public static int getAlreadyDoneColor() {
        return getCorrectColor();
    }

    public static int getLeftColor() {
        return getWrongColor();
    }

    public static int getRandomCardColor() {
        if (colorful)
            return ColorManager.getRandomColorId();
        last = last % 4;
        int color = R.color.cardColor3;
        if (last == 0 || last == 1) color = R.color.cardColor7;
        last += 1;
        return color;
    }

    public static void generateColorList(int size)  {
        colors.clear();
        if (colorful) {
            for (int i = 0; i < size; i++)
                colors.add(getRandomCardColor());
        } else {
            for (int i = 0; i < size; i++)
                if (i % 2 == 0) colors.add(R.color.cardColor3);
                else colors.add(R.color.cardColor7);
        }
    }

    public static int getColorForCard(int index) {
        return colors.get(index);
    }
}
