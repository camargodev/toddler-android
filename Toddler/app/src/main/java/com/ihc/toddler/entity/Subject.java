package com.ihc.toddler.entity;

public enum Subject {


    PORTUGUESE("Português"),
    MATH("Matemática");

    private String name;

    Subject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
