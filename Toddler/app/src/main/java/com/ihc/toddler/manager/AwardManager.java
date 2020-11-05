package com.ihc.toddler.manager;

import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.dialog.NewAwardsDialog;
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

    public void notifyAward(MainActivity context) {
        if (awardsToNotify.size() == 0) return;
        List<Award> awards = getByIdList(awardsToNotify);

        NewAwardsDialog newAwardsDialog = new NewAwardsDialog(context, awards);
        newAwardsDialog.show();

        awardsToNotify.clear();
    }


}
