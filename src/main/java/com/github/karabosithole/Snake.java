package com.github.karabosithole;

import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

/**
 * The Snake class represents the main window for the Snake game.
 * It extends JFrame to create the game UI and manage the game board.
 */
public class Snake extends JFrame {

    /**
     * Constructor to initialize the Snake game UI.
     */
    public Snake() {
        initUI(); // Initialize the user interface
    }

    /**
     * Initializes the user interface components for the game.
     */
    private void initUI() {
        add(new Board()); // Add the game board to the frame

        setResizable(false); // Disable resizing of the window
        pack(); // Pack the components within the frame

        setTitle("Snake"); // Set the title of the window
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the application on close
    }

    /**
     * The main method to launch the Snake game application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Use EventQueue to ensure that the UI is created on the Event Dispatch Thread
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake(); // Create an instance of Snake
            ex.setVisible(true); // Make the frame visible
        });
    }
}
