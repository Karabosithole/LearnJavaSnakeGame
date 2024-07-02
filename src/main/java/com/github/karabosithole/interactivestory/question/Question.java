package com.github.karabosithole.interactivestory.question;

/**Question.java:
 *Represents a question or challenge
 * that users may encounter at certain points in the story.
 */

import java.util.List;

public class Question {
    private String id;
    private String text;
    private List<Choice> choices;

    // Getters and Setters

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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public static class Choice {
        private String text;
        private boolean correct;

        // Getters and Setters

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isCorrect() {
            return correct;
        }

        public void setCorrect(boolean correct) {
            this.correct = correct;
        }
    }
}