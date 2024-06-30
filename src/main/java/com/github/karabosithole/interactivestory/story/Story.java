package com.github.karabosithole.interactivestory.story;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**Story Class:
 Purpose: The Story class manages the overall structure and flow of your interactive story. It orchestrates the loading of story nodes from YAML files, facilitates navigation between nodes based on user choices, and maintains the current state of the story progression.
 Responsibilities:
 Load and store instances of StoryNode objects.
 Manage user navigation through methods like startStory() and makeChoice(int choiceIndex).
 Handle interactions between different story nodes and manage the current state of the story.
 */

public class Story {


    private Map<String, StoryNode> nodes; // Map to store StoryNode objects by their IDs
    private Map<String, LearningPath> learningPaths; // Map to store LearningPath objects by their IDs
    private StoryNode currentNode; // Current node the user is interacting with

    public Story(String storyDataFile) {
        nodes = new HashMap<>();
        learningPaths = new HashMap<>();
        loadStoryFromYAML(storyDataFile);
        currentNode = nodes.get("start"); // Start the story from the beginning
    }

    // Method to load story data from YAML file
    private <StoryData> void loadStoryFromYAML(String storyDataFile) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            // Read YAML file and map to StoryData object
            StoryData storyData = mapper.readValue(new File(storyDataFile), StoryData.class);

            // Populate nodes map with StoryNode objects
            for (StoryNode node : storyData.getNodes()) {
                nodes.put(node.getId(), node);
            }

            // Populate learningPaths map with LearningPath objects
            for (LearningPath path : storyData.getLearningPaths()) {
                learningPaths.put(path.getId(), path);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file loading errors if needed
        }
    }
}
