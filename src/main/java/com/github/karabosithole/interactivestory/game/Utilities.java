package com.github.karabosithole.interactivestory.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.story.StoryNode;

import java.io.File;
import java.io.IOException;

/**
 * Utilities.java:
 * Utility methods that support various functionalities across the game.
 */

public class Utilities {
    public static StoryNode loadInitialStoryNode() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File("src/main/resources/story-data.yaml"), StoryNode.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
