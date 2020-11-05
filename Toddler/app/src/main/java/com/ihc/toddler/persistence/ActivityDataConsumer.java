package com.ihc.toddler.persistence;

import com.ihc.toddler.entity.ActivitiesStats;
import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.Quiz;
import com.ihc.toddler.repository.ContentRepository;
import com.ihc.toddler.repository.QuizRepository;

import java.util.ArrayList;
import java.util.List;

public class ActivityDataConsumer extends ActivityTracker {

    private static final int totalNumberOfContents = ContentRepository.getContents().size();
    private static final int totalNumberOfQuizes = QuizRepository.getQuizes().size();

    public static List<Content> getAllConsumedContents() {
        return new ArrayList<>(contents.values());
    }

    public static List<Quiz> getAllConsumedQuizes() {
        return new ArrayList<>(quizes.values());
    }

    public static ActivitiesStats getContentStats() {
        return new ActivitiesStats(totalNumberOfContents, contents.size());
    }

    public static ActivitiesStats getQuizStats() {
        return new ActivitiesStats(totalNumberOfQuizes, quizes.size());
    }

}
