package com.github.karabosithole.interactivestory.question;

/**Question.java:
 *Represents a question or challenge
 * that users may encounter at certain points in the story.
 */

import java.util.List;

public class Question {
    private String id;
    private String text;
    private String answer;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}