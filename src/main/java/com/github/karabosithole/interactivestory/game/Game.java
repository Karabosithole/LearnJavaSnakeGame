package com.github.karabosithole.interactivestory.game;


import com.github.karabosithole.interactivestory.story.Choice;
import com.github.karabosithole.interactivestory.story.Story;
import com.github.karabosithole.interactivestory.story.StoryNode;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

/**Game.java: Main class the game logic.
 * It manages the overall game flow, interacts with users,
 * and coordinates different game components.
*/


import java.util.Scanner;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

//public class Game {
//    private Story story;
//    private StoryNode currentNode;
//
//    public Game(Story story) {
//        this.story = story;
//        this.currentNode = findNodeById("start");
//    }
//
//    public void start() {
//        Scanner scanner = new Scanner(System.in);
//
//        while (currentNode != null) {
//            displayCurrentNode();
//            if (currentNode.getChoices() == null || currentNode.getChoices().isEmpty()) {
//                System.out.println("The end.");
//                break;
//            }
//
//            int choice = getUserChoice(scanner);
//            currentNode = findNodeById(currentNode.getChoices().get(choice - 1).getNextNodeId());
//        }
//
//        scanner.close();
//    }
//
//    private void displayCurrentNode() {
//        System.out.println(currentNode.getDescription());
//        if (currentNode.getChoices() != null && !currentNode.getChoices().isEmpty()) {
//            for (int i = 0; i < currentNode.getChoices().size(); i++) {
//                System.out.println((i + 1) + ": " + currentNode.getChoices().get(i).getText());
//            }
//        }
//    }
//
//    private int getUserChoice(Scanner scanner) {
//        int choice = -1;
//        while (choice < 1 || choice > currentNode.getChoices().size()) {
//            System.out.print("Enter your choice: ");
//            choice = scanner.nextInt();
//        }
//        return choice;
//    }
//
//    private StoryNode findNodeById(String nodeId) {
//        for (StoryNode node : story.getNodes()) {
//            if (node.getId().equals(nodeId)) {
//                return node;
//            }
//        }
//        return null; // Or handle it appropriately
//    }
//}
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.question.QuestionBank;
import com.github.karabosithole.interactivestory.story.StoryNode;
import com.github.karabosithole.interactivestory.user.User;
import com.github.karabosithole.interactivestory.ui.UserInterface;
import com.github.karabosithole.interactivestory.ui.ConsoleUI;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Game {
    private User user;
    private Map<String, StoryNode> storyNodes;
    private QuestionBank questionBank;
    private UserInterface ui;

    public Game() {
        user = new User();
        ui = new ConsoleUI();
    }

    public void loadStoryData(String storyDataFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        StoryData storyData = mapper.readValue(new File(storyDataFile), StoryData.class);
        this.storyNodes = storyData.getNodes();
    }

    public void loadQuestions(String questionsFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        QuestionBank loadedQuestions = mapper.readValue(new File(questionsFile), QuestionBank.class);
        this.questionBank = loadedQuestions;
    }

    public void start() {
        // Initialize game and load data
        try {
            loadStoryData("src/main/resources/story-data.yaml");
            loadQuestions("src/main/resources/questions.yaml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        user.setCurrentNode("start");
        ui.displayStory(storyNodes.get(user.getCurrentNode()).getDescription());

        while (true) {
            StoryNode currentNode = storyNodes.get(user.getCurrentNode());
            if (currentNode.getQuestionId() != null) {
                ui.displayQuestion(questionBank.getQuestion(currentNode.getQuestionId()));
                // handle question answer
            }

            ui.displayChoices(currentNode.getChoices());
            String userChoice = ui.getUserInput();
            // process user choice and update currentNode
        }
    }
}