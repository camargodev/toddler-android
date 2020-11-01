package com.ihc.toddler.manager;

import com.ihc.toddler.entity.Content;
import com.ihc.toddler.entity.ContentPart;
import com.ihc.toddler.entity.Exercise;
import com.ihc.toddler.entity.Quiz;

public class ContentManager {

    private static ContentManager contentManager = new ContentManager();

    private int currentPart = 0;
    private Content content;

    private ContentManager() {}

    private ContentManager(Content content) {
        this.currentPart = 0;
        this.content = content;
    }

    public static ContentManager getInstance() {
        return contentManager;
    }

    public static ContentManager getInstance(Content content) {
        contentManager = new ContentManager(content);
        return contentManager;
    }

    public ContentPart getCurrentPart() {
        return content.getTextParts().get(currentPart);
    }

    public ContentManager goToNext() {
        currentPart += 1;
        return this;
    }

    public ContentManager goToPrevious() {
        currentPart -= 1;
        return this;
    }

    public boolean isLastPart() {
        return currentPart == (content.getNumberOfParts() - 1);
    }

    public boolean isFirstPart() { return currentPart ==  0; }

    public int getNumberOfParts() {
        return content.getNumberOfParts();
    }

    public int getCurrentPartNumber() {
        return this.currentPart + 1;
    }

    public Content getContent() {
        return content;
    }

}
