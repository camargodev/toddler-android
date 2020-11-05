package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Award;

public class LevelManager {

    int totalPoints = 0;

    private static final LevelManager manager = new LevelManager();

    private LevelManager() {}

    public static LevelManager getInstance() {
        return manager;
    }

    public void computeAward(Award award) {
        totalPoints += award.getAwardTier().getPoints();
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getCurrentLevel() {
        int currentLevel = 1;
        int currentLevelPoints = 5;
        int leftPoints = totalPoints;
        while (leftPoints > currentLevelPoints) {
            leftPoints -= currentLevelPoints;
            currentLevelPoints *= 2;
            currentLevel += 1;
        }
        return currentLevel;
    }



}
