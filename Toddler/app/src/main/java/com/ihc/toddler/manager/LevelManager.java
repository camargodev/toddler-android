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
        int leftPoints = totalPoints;
        while (leftPoints > getPointsByLevel(currentLevel)) {
            leftPoints -= getPointsByLevel(currentLevel);
            currentLevel += 1;
        }
        return currentLevel;
    }

    public int getPointsToNextLevel(){
        int level = getCurrentLevel();
        int nextLevelPoints = getPointsByLevel(level+1);
        return nextLevelPoints - totalPoints;
    }

    public int getPointsByLevel(int level) {
        if (level == 1) return 5;
        return 2 * getPointsByLevel(level-1);
    }




}
