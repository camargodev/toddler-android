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

    private static final int[] POINTS_TO_ACHIEVE_LEVEL = {0, 5, 15, 25, 50, 75, 100, 150, 200, 300};

    public int getCurrentLevel() {
        int currentLevel = 0;
        while (totalPoints >= POINTS_TO_ACHIEVE_LEVEL[currentLevel])
            currentLevel += 1;
        return currentLevel;
    }

    public int getPointsToNextLevel(){
        int level = getCurrentLevel();
        int nextLevelPoints = POINTS_TO_ACHIEVE_LEVEL[level];
        return nextLevelPoints - totalPoints;
    }

    public int getProgressForNextLevel() {
        int level = getCurrentLevel();
        int myLevelPoints = POINTS_TO_ACHIEVE_LEVEL[level-1];
        int nextLevelPoints = POINTS_TO_ACHIEVE_LEVEL[level];
        int totalForNextLevel = nextLevelPoints - myLevelPoints;
        int advanceOnCurrentLevel = totalPoints - myLevelPoints;
        return (advanceOnCurrentLevel/totalForNextLevel) * 100;
    }




}
