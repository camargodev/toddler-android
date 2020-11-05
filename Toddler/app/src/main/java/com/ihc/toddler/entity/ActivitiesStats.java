package com.ihc.toddler.entity;

public class ActivitiesStats {

    int totalNumberOfActivities;
    int numberOfConsumesActivities;

    public ActivitiesStats(int totalNumberOfActivities, int numberOfConsumesActivities) {
        this.totalNumberOfActivities = totalNumberOfActivities;
        this.numberOfConsumesActivities = numberOfConsumesActivities;
    }

    public int getTotalNumberOfActivities() {
        return totalNumberOfActivities;
    }

    public int getNumberOfConsumedActivities() {
        return numberOfConsumesActivities;
    }
}
