package com.estiam.filmquiz.projos;

public class Question {
    private int id;
    private String text;
    private boolean answer;

    //constructeur
    public Question(){}

    public Question(String text, boolean answer){
        this.text=text;
        this.answer=answer;
    }

    //getters et setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

}
