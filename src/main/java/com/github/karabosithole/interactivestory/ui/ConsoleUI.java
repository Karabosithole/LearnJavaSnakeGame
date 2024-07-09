package com.github.karabosithole.interactivestory.ui;

/**ConsoleUI.java: Handles user interaction through the console.
 *It displays text, prompt users for input, and process their responses.
 */

import com.github.karabosithole.interactivestory.question.Question;
import com.github.karabosithole.interactivestory.story.Choice;
import com.github.karabosithole.interactivestory.story.StoryNode;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public boolean askQuestion(Question question) {
        System.out.println(question.getText());
        String userAnswer = scanner.nextLine();
        return userAnswer.equalsIgnoreCase(question.getAnswer());
    }

    @Override
    public int getUserChoice(List<Choice> choices) {
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i).getText());
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice - 1;
    }
}