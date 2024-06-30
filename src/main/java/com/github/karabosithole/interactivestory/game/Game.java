package com.github.karabosithole.interactivestory.game;


import com.github.karabosithole.interactivestory.story.Choice;
import com.github.karabosithole.interactivestory.story.Story;
import com.github.karabosithole.interactivestory.story.StoryNode;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**Game.java: Main class for your game logic.
 * It manages the overall game flow, interacts with users,
 * and coordinates different game components.
*/

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Story story;
    private StoryNode currentNode;

    public Game(Story story) {
        this.story = story;
        this.currentNode = findNodeById("start");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (currentNode != null) {
            displayCurrentNode();
            if (currentNode.getChoices() == null || currentNode.getChoices().isEmpty()) {
                System.out.println("The end.");
                break;
            }

            int choice = getUserChoice(scanner);
            currentNode = findNodeById(currentNode.getChoices().get(choice - 1).getNextNodeId());
        }

        scanner.close();
    }

    private void displayCurrentNode() {
        System.out.println(currentNode.getDescription());
        if (currentNode.getChoices() != null && !currentNode.getChoices().isEmpty()) {
            for (int i = 0; i < currentNode.getChoices().size(); i++) {
                System.out.println((i + 1) + ": " + currentNode.getChoices().get(i).getText());
            }
        }
    }

    private int getUserChoice(Scanner scanner) {
        int choice = -1;
        while (choice < 1 || choice > currentNode.getChoices().size()) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        }
        return choice;
    }

    private StoryNode findNodeById(String nodeId) {
        for (StoryNode node : story.getNodes()) {
            if (node.getId().equals(nodeId)) {
                return node;
            }
        }
        return null; // Or handle it appropriately
    }

    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(Story.class));
        InputStream inputStream = Game.class.getClassLoader().getResourceAsStream("story.yaml");
        Story story = yaml.load(inputStream);

        Game game = new Game(story);
        game.start();
    }
}

