package com.ihc.toddler.entity;

public class ContentPart {

    String title, text;

    public ContentPart(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
