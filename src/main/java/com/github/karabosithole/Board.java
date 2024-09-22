package com.github.karabosithole;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * The Board class represents the game board for the Snake game.
 * It handles the game logic, rendering, and user input.
 */
public class Board extends JPanel implements ActionListener {

    // Dimensions of the game board
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900; // Maximum dots on the board
    private final int RAND_POS = 29; // Random position for apple
    private final int DELAY = 140; // Delay for game speed

    private final int x[] = new int[ALL_DOTS]; // X coordinates of the snake
    private final int y[] = new int[ALL_DOTS]; // Y coordinates of the snake

    private int dots; // Current length of the snake
    private int apple_x; // X coordinate of the apple
    private int apple_y; // Y coordinate of the apple

    // Direction flags for the snake movement
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true; // Game state

    private Timer timer; // Timer to control game speed
    private Image ball; // Image for the snake's body
    private Image apple; // Image for the apple
    private Image head; // Image for the snake's head

//    private List<String> questions; // List of questions to ask

    private QuestionManager questionManager; // Use composition
    /**
     * Constructor to initialize the Board.
     */
    public Board() {
        initBoard();
    }

    /**
     * Initializes the game board settings and components.
     */
    private void initBoard() {
        addKeyListener(new TAdapter()); // Add key listener for controls
        setBackground(Color.black); // Set background color
        setFocusable(true); // Make the panel focusable

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT)); // Set preferred size
        loadImages(); // Load images for the game
        initGame(); // Initialize the game state

        questionManager = new QuestionManager();

        // Initialize questions
//        questions = new ArrayList<>();
//        questions.add("What does JVM stand for?");
//        questions.add("What is the difference between JDK and JRE?");
//        questions.add("What is a constructor in Java?");
//        questions.add("What is polymorphism?");
//        questions.add("What is an interface?");
    }

    /**
     * Loads images for the game elements.
     */
    private void loadImages() {
        ImageIcon iid = new ImageIcon("src/main/java/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/main/java/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/main/java/resources/head.png");
        head = iih.getImage();
    }

    /**
     * Initializes the game state and positions.
     */
    private void initGame() {
        dots = 3; // Set initial snake length

        // Initialize snake's starting position
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple(); // Locate the first apple

        timer = new Timer(DELAY, this); // Create timer for game updates
        timer.start(); // Start the timer
    }

    /**
     * Paints the game components on the panel.
     *
     * @param g Graphics object for drawing
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Call parent method

        doDrawing(g); // Custom drawing
    }

    /**
     * Handles the custom drawing of game elements.
     *
     * @param g Graphics object for drawing
     */
    private void doDrawing(Graphics g) {
        if (inGame) {
            // Draw apple
            g.drawImage(apple, apple_x, apple_y, this);

            // Draw the snake
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this); // Draw head
                } else {
                    g.drawImage(ball, x[z], y[z], this); // Draw body
                }
            }

            Toolkit.getDefaultToolkit().sync(); // Sync graphics

        } else {
            gameOver(g); // Show game over message
        }
    }

    /**
     * Displays the game over message.
     *
     * @param g Graphics object for drawing
     */
    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        //question box shows
        g.setColor(Color.white); // Set color for text
        g.setFont(small); // Set font for text
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2); // Center the message
    }

    /**
     * Checks if the snake has eaten an apple and updates the game state.
     */
    private void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            dots++; // Increase snake length
            locateApple(); // Locate new apple

            questionManager.displayQuestion();

//            // Show a random question
//            int randomIndex = (int) (Math.random() * questions.size());
//            String question = questions.get(randomIndex);
//            JOptionPane.showMessageDialog(this, question, "Java Question", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Moves the snake in the current direction.
     */
    private void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)]; // Move body segments
            y[z] = y[(z - 1)];
        }

        // Update head position based on direction
        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }

    /**
     * Checks for collisions with walls or the snake itself.
     */
    private void checkCollision() {
        // Check for collision with body
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false; // Collision detected
            }
        }

        // Check for collision with walls
        if (y[0] >= B_HEIGHT || y[0] < 0 || x[0] >= B_WIDTH || x[0] < 0) {
            inGame = false; // Out of bounds
        }

        if (!inGame) {
            timer.stop(); // Stop the game timer
        }
    }

    /**
     * Locates the apple at a random position on the board.
     */
    private void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE)); // Calculate X position

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE)); // Calculate Y position
    }

    /**
     * Handles the timer event for updating the game state.
     *
     * @param e ActionEvent triggered by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple(); // Check for apple consumption
            checkCollision(); // Check for collisions
            move(); // Move the snake
        }

        repaint(); // Refresh the display
    }

    /**
     * KeyAdapter for handling user input for snake movement.
     */
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode(); // Get the key code

            // Change direction based on key press
            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}