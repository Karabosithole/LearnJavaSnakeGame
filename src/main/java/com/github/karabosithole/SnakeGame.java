package com.github.karabosithole;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * The SnakeGame class is the entry point of the Snake game application.
 * It sets up the main game window and initializes the gameplay.
 */
public class SnakeGame {
    public static void main(String[] args) {
        // Create a new JFrame object for the game window
        JFrame obj = new JFrame();

        // Create a Gameplay object, which contains the game logic and rendering
        Gameplay gameplay = new Gameplay();

        // Set the dimensions and properties of the game window
        obj.setBounds(10, 10, 910, 750);
        obj.setBackground(Color.DARK_GRAY); // Set background color
        obj.setResizable(false); // Prevent resizing of the window
        obj.setVisible(true); // Make the window visible
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application when the window is closed
        obj.add(gameplay); // Add the gameplay component to the window
    }
}
