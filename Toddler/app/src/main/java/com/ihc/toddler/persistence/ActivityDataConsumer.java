package com.ihc.toddler.persistence;

import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Quiz;

import java.util.ArrayList;
import java.util.List;

public class ActivityDataConsumer extends ActivityTracker {

    public static List<Content> getAllConsumedContents() {
        return new ArrayList<>(contents.values());
    }

    public static List<Quiz> getAllConsumedQuizes() {
        return new ArrayList<>(quizes.values());
    }

}
