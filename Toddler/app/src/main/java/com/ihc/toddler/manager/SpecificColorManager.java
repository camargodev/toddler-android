package com.ihc.toddler.manager;

import com.ihc.toddler.R;

import java.util.ArrayList;
import java.util.List;

import static com.ihc.toddler.manager.ColorManager.getRandomColorId;

public class SpecificColorManager  {

    private static List<Integer> colors = new ArrayList<>();
    private static int last = 0;

    public static int getWrongColor() { return R.color.gray; }

    public static int getCorrectColor() {
        return getRandomCardColor();
    }

    public static int getNextActivityColor() {
        return getHighlightedColor();
    }

    public static int getHighlightedColor()  {
        return getRandomCardColor();
    }

    public static int getAlreadyDoneColor() {
        return getRandomCardColor();
    }

    public static int getLeftColor() {
        return R.color.gray;
    }

    public static int getRandomCardColor() {
        return ColorManager.getRandomColorId();
//        last = last % 4;
//        int color = R.color.cardColor3;
//        if (last == 0 || last == 1) color = R.color.cardColor7;
//        last += 1;
//        return color;
    }

    public static void generateColorList(int size)  {
        colors.clear();
        for (int i = 0; i < size; i++)
            colors.add(getRandomCardColor());
    }

    public static int getColorForCard(int index) {
        return colors.get(index);
    }
}
