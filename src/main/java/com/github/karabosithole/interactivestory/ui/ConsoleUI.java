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
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayText(String text) {
        System.out.println(text);
    }

    @Override
    public void displayChoices(List<Choice> choices) {
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i).getText());
        }
    }

    @Override
    public int getChoice(int numChoices) {
        int choice = -1;
        while (choice < 1 || choice > numChoices) {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
        }
        return choice - 1;
    }
}