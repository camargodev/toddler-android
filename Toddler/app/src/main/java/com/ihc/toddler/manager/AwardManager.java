package com.ihc.toddler.manager;

import android.content.Context;
import android.widget.Toast;

import com.ihc.toddler.entity.Award;
import com.ihc.toddler.repository.AwardRepository;

import java.util.ArrayList;
import java.util.List;

public class AwardManager extends AwardRepository {

    private static final AwardManager manager = new AwardManager();
    private List<Integer> awardsToNotify = new ArrayList<>();

    private AwardManager() {}

    public static AwardManager getInstance() {
        return manager;
    }

    public void triggerAwardValidations() {
        for (Award award : getAll())
            if (award.isAchievable() && !award.isAccomplished()) {
                award.setAccomplished(true);
                awardsToNotify.add(award.getId());
            }
    }

    public boolean isAwardAccomplished(Integer awardId) {
        for (Award award : getAll())
            if (award.getId() == awardId)
                return award.isAccomplished();
        return false;
    }

    public void notifyAward(Context context) {
        if (awardsToNotify.size() == 0) return;
        String message = "Você tem " + awardsToNotify.size() + " novos trofeus";
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        awardsToNotify.clear();
    }


}
