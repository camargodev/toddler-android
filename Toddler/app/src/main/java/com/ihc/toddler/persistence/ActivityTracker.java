package com.ihc.toddler.persistence;

import com.ihc.toddler.entity.AbstractActivity;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityTracker {

    private static ActivityTracker activityTracker = new ActivityTracker();

    private ActivityTracker() {}

    private HashMap<Integer, Content> contents = new HashMap<>();
    private HashMap<Integer, Quiz> quizes = new HashMap<>();

    public static ActivityTracker getInstance() {
        return activityTracker;
    }

    public void addActivity(AbstractActivity activity) {
        if (isActivityConsumed(activity))
            return;
        if (activity instanceof Quiz)
            quizes.put(activity.getId(), (Quiz) activity);
        else
            contents.put(activity.getId(), (Content) activity);
    }

    public boolean isActivityConsumed(AbstractActivity activity) {
        if (activity instanceof Quiz)
            return quizes.containsKey(activity.getId());
        else
            return contents.containsKey(activity.getId());
    }



}
