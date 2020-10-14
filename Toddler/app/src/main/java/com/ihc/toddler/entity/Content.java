package com.ihc.toddler.entity;

import java.util.List;

public class Content extends AbstractActivity {

    List<ContentPart> parts;

    public Content(String title, List<ContentPart> parts) {
        super();
        super.title = title;
        this.parts = parts;
    }

    public List<ContentPart> getTextParts() {
        return parts;
    }

    public int getNumberOfParts() {
        return parts.size();
    }
}
