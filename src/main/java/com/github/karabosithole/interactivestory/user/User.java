package com.github.karabosithole.interactivestory.user;
/**User.java: Represents a user or player in your game.
 * holds user-specific data.
*/
public class User {
    private String currentNode;
    private int score;

    // Getters and Setters

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Method to update user's state
}
