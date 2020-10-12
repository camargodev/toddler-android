package com.ihc.toddler.entity;

import java.util.List;

public class Content extends AbstractActivity {

    List<ContentPart> parts;

    public Content(List<ContentPart> parts) {
        super();
        this.parts = parts;
    }

    public List<ContentPart> getTextParts() {
        return parts;
    }

    public int getNumberOfParts() {
        return parts.size();
    }
}
