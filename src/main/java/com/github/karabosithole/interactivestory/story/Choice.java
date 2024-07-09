package com.github.karabosithole.interactivestory.story;

/**Choice.java: Represents a choice that users can make at a particular StoryNode,
defining where the user navigates next.
 */

public class Choice {
    private String description;
    private String text;
    private StoryNode nextNode;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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