package com.github.karabosithole.interactivestory.story;

/**Choice.java: Represents a choice that users can make at a particular StoryNode,
defining where the user navigates next.
 */

public class Choice {
    private String text;
    private String nextNodeId;

    // Getters and Setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextNodeId() {
        return nextNodeId;
    }

    public void setNextNodeId(String nextNodeId) {
        this.nextNodeId = nextNodeId;
    }
}