package com.github.karabosithole.interactivestory.game;


import com.github.karabosithole.interactivestory.story.*;
import com.github.karabosithole.interactivestory.story.StoryNode;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**Game.java: Main class the game logic.
 * It manages the overall game flow, interacts with users,
 * and coordinates different game components.
*/


import java.util.*;

import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.question.QuestionBank;
import com.github.karabosithole.interactivestory.story.StoryNode;
import com.github.karabosithole.interactivestory.user.User;
import com.github.karabosithole.interactivestory.ui.UserInterface;
import com.github.karabosithole.interactivestory.ui.ConsoleUI;

import java.io.File;
import java.io.IOException;

public class Game {
    private UserInterface ui;
    private StoryNode currentNode;

    public Game() {
        this.ui = new ConsoleUI();
        this.currentNode = Utilities.loadInitialStoryNode();
    }

    public void start() {
        while (!currentNode.isEndNode()) {
            ui.displayText(currentNode.getText());
            ui.displayChoices(currentNode.getChoices());
            int choiceIndex = ui.getChoice(currentNode.getChoices().size());
            currentNode = currentNode.getChoices().get(choiceIndex).getNextNode();
        }
        ui.displayText(currentNode.getText());
        ui.displayText("The End.");
    }
}