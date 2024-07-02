package com.github.karabosithole.interactivestory.story;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.yaml.snakeyaml.nodes.Node;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Story Class:
 Purpose: The Story class manages the overall structure and flow of the interactive story.
 It orchestrates the loading of story nodes from YAML files,
 facilitates navigation between nodes based on user choices, and maintains the current state of the story progression.
 Responsibilities:
 Load and store instances of StoryNode objects.
 Manage user navigation through methods like startStory() and makeChoice(int choiceIndex).
 Handle interactions between different story nodes and manage the current state of the story.
 */



public class Story {
    private List<StoryNode> nodes;
    private List<LearningPath> learningPaths;

    // Getters and setters

    public List<StoryNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<StoryNode> nodes) {
        this.nodes = nodes;
    }

    public List<LearningPath> getLearningPaths() {
        return learningPaths;
    }

    public void setLearningPaths(List<LearningPath> learningPaths) {
        this.learningPaths = learningPaths;
    }
}
