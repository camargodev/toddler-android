package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Award;

import java.util.ArrayList;
import java.util.List;

public class AwardManager {

    private static final AwardManager manager = new AwardManager();
    private List<Award> awards = new ArrayList<>();

    private  AwardManager() {}

    public static AwardManager getInstance() {
        return manager;
    }

    public void addAward(Award award) {
        awards.add(award);
    }

    public List<Award> getAllAwards() {
        return awards;
    }

}
