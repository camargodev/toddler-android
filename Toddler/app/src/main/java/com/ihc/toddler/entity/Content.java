package com.ihc.toddler.entity;

import java.util.List;

public class Content extends AbstractActivity {

    List<String> textParts;

    public Content(List<String> textParts) {
        super();
        this.textParts = textParts;
    }

    public List<String> getTextParts() {
        return textParts;
    }

    public int getNumberOfParts() {
        return textParts.size();
    }
}
