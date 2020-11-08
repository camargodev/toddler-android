package com.ihc.toddler.manager;

import com.ihc.toddler.activity.MainActivity;
import com.ihc.toddler.dialog.NewAwardsDialog;
import com.ihc.toddler.entity.Award;
import com.ihc.toddler.repository.AwardRepository;

import java.util.ArrayList;
import java.util.List;

public class ResultOpeningManager extends AwardRepository {

    private static final ResultOpeningManager manager = new ResultOpeningManager();
    private List<Boolean> opened = new ArrayList<>();

    private ResultOpeningManager() {}

    public static ResultOpeningManager getInstance() {
        return manager;
    }

    public void init(int size) {
        opened.clear();
        for (int i = 0; i < size; i++) opened.add(false);
    }

    public boolean isOpened(int position) {
        return opened.get(position);
    }

    public void open(int position) {
        opened.set(position, true);
    }

}
