package com.github.karabosithole.interactivestory.story;

/**Choice.java: Represents a choice that users can make at a particular StoryNode,
defining where the user navigates next.
 */

public class Choice {
    private String text;
    private StoryNode nextNode;

    // Getters and setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public StoryNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StoryNode nextNode) {
        this.nextNode = nextNode;
    }
}