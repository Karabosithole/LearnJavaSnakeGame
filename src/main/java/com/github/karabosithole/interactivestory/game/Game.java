package com.github.karabosithole.interactivestory.game;


import com.github.karabosithole.interactivestory.story.Choice;
import com.github.karabosithole.interactivestory.story.StoryNode;

/**Game.java: Main class for your game logic.
 * It manages the overall game flow, interacts with users,
 * and coordinates different game components.
*/

public class Game {
    public static void main(String[] args) {
        // Define story nodes
        StoryNode startNode = new StoryNode("You find yourself in a mysterious room.");

        StoryNode middleNode = new StoryNode("As you explore further, you discover two doors.");
        startNode.addChoice(new Choice("Enter the left door", middleNode));

        StoryNode endNode1 = new StoryNode("You find a treasure chest!");
        middleNode.addChoice(new Choice("Open the chest", endNode1));

        StoryNode endNode2 = new StoryNode("The room collapses!");
        middleNode.addChoice(new Choice("Enter the right door", endNode2));

        // Simulate the game loop (console-based)
        StoryNode currentNode = startNode;
        while (currentNode != null) {
            System.out.println(currentNode.getText());

            if (currentNode.getChoices().isEmpty()) {
                System.out.println("Game Over!");
                break;
            }

            System.out.println("Choices:");
            for (int i = 0; i < currentNode.getChoices().size(); i++) {
                System.out.println((i + 1) + ". " + currentNode.getChoices().get(i).getText());
            }

            // Simulate user input (for demonstration, input is hardcoded)
            int choiceIndex = 0; // replace with actual user input mechanism
            if (choiceIndex >= 1 && choiceIndex <= currentNode.getChoices().size()) {
                Choice chosenChoice = currentNode.getChoices().get(choiceIndex - 1);
                currentNode = chosenChoice.getNextNode();
            } else {
                System.out.println("Invalid choice, please choose again.");
            }
        }
    }
}
