package com.ihc.toddler.entity;

import java.util.List;

public class Content extends AbstractActivity {

    List<ContentPart> parts;

    public Content(int id, Content content) {
        this(content.title, content.parts);
        super.id = id;
    }

    public Content(String title, List<ContentPart> parts) {
        super();
        super.type = ActivityType.CONTENT;
        super.title = title;
        this.parts = parts;
    }

    public List<ContentPart> getTextParts() {
        return parts;
    }

    public int getNumberOfParts() {
        return parts.size();
    }

    @Override
    public String getTypeName() {
        return "Aula " + super.getId();
    }

    @Override
    public AbstractActivity clone() {
        return new Content(this.title, this.parts);
    }
}
