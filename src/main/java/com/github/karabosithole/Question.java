package com.github.karabosithole;

public class Question {
    private String questionText;
    private String[] choices;
    private int correctAnswerIndex;

    public Question(String questionText, String[] choices, int correctAnswerIndex) {
        this.questionText = questionText;
        this.choices = choices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

