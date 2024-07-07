package com.github.karabosithole.interactivestory.story;

/**StoryNode Class:
 *Purpose: The StoryNode class represents individual nodes or points the interactive story.
 *Each StoryNode encapsulates information about a specific narrative point,
 * including its description, associated choices, and optionally a question or challenge.
 *Responsibilities:
 *Hold information such as id, description, choices, and questionId.
 *Provide methods to retrieve and manipulate this information.
 */



import java.util.List;

public class StoryNode {
    private String text;
    private List<Choice> choices;
    private boolean endNode; // Note the change here

    // Getters and setters

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

    public boolean isEndNode() { // No change needed here
        return endNode;
    }

    public void setEndNode(boolean endNode) { // No change needed here
        this.endNode = endNode;
    }
}