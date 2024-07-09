package com.github.karabosithole.interactivestory.story;

/**LearningPath.java:
 *Defines a sequence of StoryNode IDs that form a specific path or
 *  narrative arc through your story.
 * It helps structure how users progress through the narrative.
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class LearningPath {
    private StoryNode startNode;

    public LearningPath(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            startNode = mapper.readValue(new File(filePath), StoryNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StoryNode getStartNode() {
        return startNode;
    }}