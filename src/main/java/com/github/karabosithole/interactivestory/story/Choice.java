package com.github.karabosithole.interactivestory.story;

/**Choice.java: Represents a choice that users can make at a particular StoryNode,
defining where the user navigates next.
 */

public class Choice {

    private String text;
    private StoryNode nextNode;

    public Choice(String text, StoryNode nextNode) {
        this.text = text;
        this.nextNode = nextNode;
    }

    public String getText() {
        return text;
    }

    public StoryNode getNextNode() {
        return nextNode;
    }

}
