package com.github.karabosithole.interactivestory.story;

/**LearningPath.java:
 *Defines a sequence of StoryNode IDs that form a specific path or
 *  narrative arc through your story.
 * It helps structure how users progress through the narrative.
 */
import java.util.List;
public class LearningPath {
    private List<StoryNode> pathNodes;

    // Getters and setters

    public List<StoryNode> getPathNodes() {
        return pathNodes;
    }

    public void setPathNodes(List<StoryNode> pathNodes) {
        this.pathNodes = pathNodes;
    }
}
