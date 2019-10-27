package com.example.planningpoker;

public class User {
    public String question;
    public String number;

    public User(String question, String number) {
        this.question = question;
        this.number = number;
    }

    public User() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
