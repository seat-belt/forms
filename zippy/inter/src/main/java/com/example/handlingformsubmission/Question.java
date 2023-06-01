package com.example.handlingformsubmission;

public class Question {
    private String text;
    private int answer;

    public Question(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}