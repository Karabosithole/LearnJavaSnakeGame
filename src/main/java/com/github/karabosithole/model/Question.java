package com.github.karabosithole.model;

public class Question {
    private String questionText;
    private String[] answers;
    private int correctAnswerIndex;

    public Question(String questionText, String[] answers, int correctAnswerIndex) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    // Method to ask question and check answer
    public boolean askQuestion(int answerIndex) {
        return isCorrect(answerIndex);
    }
}