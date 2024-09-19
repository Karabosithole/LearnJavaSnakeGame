package com.github.karabosithole.model;

public class Obstacle {
    private String type; // e.g., Monster, Trap
    private int difficulty;

    public Obstacle(String type, int difficulty) {
        this.type = type;
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int encounterObstacle(Character character) {
        // For simplicity, assume the player always loses health equal to the difficulty
        character.reduceHealth(difficulty);
        return character.getHealth(); // Return remaining health
    }

    // Additional methods for obstacle effects can be added here
}