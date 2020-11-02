package com.ihc.toddler.entity;

import com.ihc.toddler.R;


public enum AwardTier {

    BRONZE(R.drawable.bronze_achieved, R.drawable.normal_not_achieved),
    SILVER(R.drawable.silver_achieved, R.drawable.normal_not_achieved),
    GOLD(R.drawable.gold_achieved, R.drawable.normal_not_achieved),
    DIAMOND(R.drawable.diamond_achieved, R.drawable.diamond_not_achieved);

    int achievedIconId, notAchievedIconId;

    AwardTier(int achievedIconId, int notAchievedIconId) {
        this.achievedIconId = achievedIconId;
        this.notAchievedIconId = notAchievedIconId;
    }

    public int getAchievedIconId() {
        return achievedIconId;
    }

    public int getNotAchievedIconId() {
        return notAchievedIconId;
    }
}
