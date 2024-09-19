package com.github.karabosithole.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdventureMazeGame {
    private Character player;
    private List<Obstacle> obstacles;
    private List<Question> questions;
    private Maze maze;

    public AdventureMazeGame(Maze maze) {
        this.maze = maze;
    }

    public Maze getMaze() {
        return maze; // Returns the maze instance
    }
    public AdventureMazeGame(Character player, int mazeWidth, int mazeHeight) {
        this.player = player;
        this.maze = new com.github.karabosithole.game.Maze(mazeWidth, mazeHeight);
        this.obstacles = new ArrayList<>();
        this.questions = new ArrayList<>();
        generateObstacles();
        loadQuestions();
    }

    private void generateObstacles() {
        Random rand = new Random();
        int numberOfObstacles = rand.nextInt(5) + 3; // 3 to 7 obstacles
        for (int i = 0; i < numberOfObstacles; i++) {
            obstacles.add(new Obstacle("Monster", rand.nextInt(20) + 1)); // Difficulty between 1 and 20
        }
    }

    private void loadQuestions() {
        // Load or generate questions here
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin"}, 0));
        questions.add(new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, 1));
    }

    public void startGame() {
        // Implement game loop and interactions
        System.out.println("Game Started!");
        while (player.isAlive()) {
            // Implement user input for movement and encountering obstacles/questions
            // Check player's status, maze state, etc.
            break; // Remove after implementing game loop
        }
        if (!player.isAlive()) {
            System.out.println("Game Over!");
        }
    }

    // Additional game methods can be added here
}