package com.example.simpleapp;

import java.util.List;

public class Question {
    private String question;
    private List<String> options;
    private int answer;

    public Question(String question, List<String> options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }
}
