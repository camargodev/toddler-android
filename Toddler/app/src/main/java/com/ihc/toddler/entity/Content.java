package com.ihc.toddler.entity;

import java.util.ArrayList;
import java.util.List;

public class Content {

    List<String> textParts = new ArrayList<>();

    public Content() {
    }

    public Content(List<String> textParts) {
        this.textParts = textParts;
    }

    public List<String> getTextParts() {
        return textParts;
    }

    public void setTextParts(List<String> textParts) {
        this.textParts = textParts;
    }

    public void addPartToText(String part) {
        textParts.add(part);
    }

    public int getNumberOfParts() {
        return textParts.size();
    }
}
