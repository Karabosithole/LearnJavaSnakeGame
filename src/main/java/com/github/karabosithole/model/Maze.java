package com.github.karabosithole.model;

import java.util.Random;


public class Maze {
    private int width;
    private int height;
    private char[][] layout;
    private int playerX;
    private int playerY;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        layout = new char[height][width];
        playerX = 0; // Starting position
        playerY = 0;
        generateMaze();
    }

    private void generateMaze() {
        Random rand = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                layout[i][j] = (rand.nextBoolean()) ? '.' : '#'; // '.' = path, '#' = wall
            }
        }
        layout[0][0] = '.'; // Start
        layout[height - 1][width - 1] = '.'; // End
    }

    public char[][] getLayout() {
        return layout;
    }

    public boolean movePlayer(int deltaX, int deltaY) {
        int newX = playerX + deltaX;
        int newY = playerY + deltaY;
        if (newX >= 0 && newX < height && newY >= 0 && newY < width && layout[newX][newY] == '.') {
            playerX = newX;
            playerY = newY;
            return true;
        }
        return false; // Move failed
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    // Additional methods for maze display can be added here
}