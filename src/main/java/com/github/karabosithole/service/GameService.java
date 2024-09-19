package com.github.karabosithole.service;

import com.github.karabosithole.model.AdventureMazeGame;

import java.util.Scanner;

public class GameService {
    private AdventureMazeGame game;

    public GameService(AdventureMazeGame game) {
        this.game = game;
    }

    public void manageGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your move (up/down/left/right): ");
            String move = scanner.nextLine();
            // Convert input to deltaX and deltaY
            // Example: "up" -> deltaX = -1, deltaY = 0
            int deltaX = 0, deltaY = 0;
            switch (move.toLowerCase()) {
                case "up": deltaX = -1; break;
                case "down": deltaX = 1; break;
                case "left": deltaY = -1; break;
                case "right": deltaY = 1; break;
                default: System.out.println("Invalid move!"); continue;
            }

            boolean moved = game.getMaze().movePlayer(deltaX, deltaY);
            if (moved) {
                System.out.println("Moved to position: " + game.getMaze().getPlayerX() + ", " + game.getMaze().getPlayerY());
                // Check for obstacles and questions at the new position
            } else {
                System.out.println("Cannot move there!");
            }
        }
    }

    // Additional methods for game management can be added here
}