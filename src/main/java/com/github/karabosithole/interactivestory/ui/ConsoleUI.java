package com.github.karabosithole.interactivestory.ui;

/**ConsoleUI.java: Handles user interaction through the console.
 *It displays text, prompt users for input, and process their responses.
 */

import com.github.karabosithole.interactivestory.question.Question;
import com.github.karabosithole.interactivestory.story.Choice;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UserInterface {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayStory(String story) {
        System.out.println(story);
    }

    @Override
    public void displayQuestion(Question question) {
        System.out.println(question.getText());
        for (int i = 0; i < question.getChoices().size(); i++) {
            System.out.println((i + 1) + ". " + question.getChoices().get(i).getText());
        }
    }

    @Override
    public void displayChoices(List<Choice> choices) {
        for (int i = 0; i < choices.size(); i++) {
            System.out.println((i + 1) + ". " + choices.get(i).getText());
        }
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}
