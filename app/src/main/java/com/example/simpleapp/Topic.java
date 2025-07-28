package com.example.simpleapp;

public class Topic {
    private String name;
    private String description;
    private String codeExample;

    public Topic(String name, String description, String codeExample) {
        this.name = name;
        this.description = description;
        this.codeExample = codeExample;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCodeExample() {
        return codeExample;
    }
}
