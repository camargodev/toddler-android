package com.ihc.toddler.entity;

public class HelpItem {

    String title, text, buttonText;

    public HelpItem(String title, String text, String  buttonText) {
        this.title = title;
        this.text = text;
        this.buttonText = buttonText;
    }

    public HelpItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
