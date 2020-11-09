package com.ihc.toddler.entity;

import com.ihc.toddler.R;


public enum AwardTier {

    BRONZE(R.drawable.bronze_achieved, R.drawable.normal_not_achieved, 5),
    SILVER(R.drawable.silver_achieved, R.drawable.normal_not_achieved, 10),
    GOLD(R.drawable.gold_achieved, R.drawable.normal_not_achieved, 15),
    DIAMOND(R.drawable.diamond_achieved, R.drawable.diamond_not_achieved, 25);

    int achievedIconId, notAchievedIconId, points;

    AwardTier(int achievedIconId, int notAchievedIconId, int points) {
        this.achievedIconId = achievedIconId;
        this.notAchievedIconId = notAchievedIconId;
        this.points = points;
    }

    public int getAchievedIconId() {
        return achievedIconId;
    }

    public int getNotAchievedIconId() {
        return notAchievedIconId;
    }

    public int getPoints() { return points; }
}
