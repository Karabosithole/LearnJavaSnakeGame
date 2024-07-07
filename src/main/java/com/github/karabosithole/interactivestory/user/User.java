package com.github.karabosithole.interactivestory.user;
/**User.java: Represents a user or player in your game.
 * holds user-specific data.
*/
public class User {
    private String name;
    private int score;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
