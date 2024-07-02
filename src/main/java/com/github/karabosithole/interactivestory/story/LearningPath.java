package com.github.karabosithole.interactivestory.story;

/**LearningPath.java:
 *Defines a sequence of StoryNode IDs that form a specific path or
 *  narrative arc through your story.
 * It helps structure how users progress through the narrative.
 */
import java.util.List;

public class LearningPath {
    private String id;
    private List<String> nodes;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
