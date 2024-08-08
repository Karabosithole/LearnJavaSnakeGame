package com.github.karabosithole.interactivestory.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.question.QuestionBank;
import com.github.karabosithole.interactivestory.ui.UserInterface;
import com.github.karabosithole.interactivestory.ui.ConsoleUI;
import com.github.karabosithole.interactivestory.question.Question;
import com.github.karabosithole.interactivestory.story.StoryNode;
import java.io.File;
import java.io.IOException;




/**Game.java: Main class the game logic.
 * It manages the overall game flow, interacts with users,
 * and coordinates different game components.
*/



public class Game {
    private StoryNode currentNode;
    private QuestionBank questionBank;
    private UserInterface ui;

    public Game() {
        ui = new ConsoleUI();
        loadStory("src/main/resources/story-data.yaml");
        loadQuestions("src/main/resources/questions.yaml");
    }

    private void loadStory(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            currentNode = mapper.readValue(new File(filePath), StoryNode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadQuestions(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            questionBank = mapper.readValue(new File(filePath), QuestionBank.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        ui.displayMessage("Welcome to TeachMeJava!");

        while (currentNode != null) {
            ui.displayMessage(currentNode.getText());

            if (!currentNode.getChoices().isEmpty()) {
                int choiceIndex = ui.getUserChoice(currentNode.getChoices());
                currentNode = currentNode.getChoices().get(choiceIndex).getNextNode();
            } else {
                break; // End of the story
            }

            // Ask the corresponding question after making the choice
            Question question = questionBank.getQuestionById(currentNode.getId());
            if (question != null) {
                boolean correct = ui.askQuestion(question);
                while (!correct) {
                    ui.displayMessage("Incorrect answer. Try again.");
                    correct = ui.askQuestion(question);
                }
            }
        }

        ui.displayMessage("The End.");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
