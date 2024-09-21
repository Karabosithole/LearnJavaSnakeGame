package com.github.karabosithole;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // Instantiation of snake object
    Snake snake = new Snake();

    // Instantiation of apple object
    Apple apple = new Apple();

    // Image for the snake's head
    private ImageIcon snakeHead;

    private Timer timer;
    private int delay = 500; // Delay for the game timer
    private ImageIcon snakeBody;

    // Flag for speed-up feature
    AtomicBoolean speedUp = new AtomicBoolean(true);

    // Coordinates for the snake's head
    private int snakeHeadXPos = 379;

    // Image for the apple
    private ImageIcon appleImage;

    // Random number generator for apple position
    private Random random = new Random();

    private int xPos = random.nextInt(100);
    private int yPos = random.nextInt(100);

    // Title image for the game
    private ImageIcon titleImage;

    // Score object for the game
    Score score = new Score();

    // Variable to hold the high score
    private String highScore;

    // Images for controller instructions
    private ImageIcon arrowImage;
    private ImageIcon shiftImage;

    public Gameplay() {
        // Initialize game settings
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        // Check if the game has started
        if (snake.moves == 0) {
            for (int i = 0; i < 5; i++) {
                snake.snakexLength[i] = snakeHeadXPos;
                snakeHeadXPos -= 6;
                snake.snakeyLength[i] = 355;
            }
        }

        // Draw game borders and title
        g.setColor(Color.WHITE);
        g.drawRect(24, 10, 852, 55);
        titleImage = new ImageIcon("com.github.karabosithole/images/title.png");
//        System.out.println("Title Image: " + (titleImage != null));
        titleImage.paintIcon(this, g, 25, 11);
        g.setColor(Color.WHITE);
        g.drawRect(24, 71, 620, 614);
        g.setColor(Color.black);
        g.fillRect(25, 72, 619, 613);
        g.setColor(Color.WHITE);
        g.drawRect(653, 71, 223, 614);
        g.setColor(Color.black);
        g.fillRect(654, 72, 221, 613);

        // Display score and high score
        g.setColor(Color.white);
        g.setFont(new Font("Helvetica", Font.BOLD, 20));
        g.drawString("SCORE : " + score.getScore(), 720, 110);
        g.drawRect(653, 130, 221, 1);
        score.sortHighScore();
        highScore = score.getHighScore();
        g.drawString("HIGHSCORE", 705, 180);
        drawString(g, highScore, 705, 200);

        // Display control instructions
        g.drawRect(653, 490, 221, 1);
        g.setFont(new Font("Helvetica", Font.BOLD, 25));
        g.drawString("CONTROLS", 690, 530);
        arrowImage = new ImageIcon("com.github.karabosithole/images/keyboardArrow.png");
        arrowImage.paintIcon(this, g, 670, 560);
        g.setFont(new Font("Helvetica", Font.PLAIN, 16));
        g.drawString("Movement", 770, 590);
        shiftImage = new ImageIcon("com.github.karabosithole/images/shift.png");
        shiftImage.paintIcon(this, g, 695, 625);
        g.drawString("Boost", 770, 640);

        // Draw the snake
        snakeHead = new ImageIcon("com.github.karabosithole/images/snakeHead4.png");
        snakeHead.paintIcon(this, g, snake.snakexLength[0], snake.snakeyLength[0]);
        for (int i = 0; i < snake.lengthOfSnake; i++) {
            if (i == 0 && (snake.right || snake.left || snake.up || snake.down)) {
                snakeHead = new ImageIcon("com.github.karabosithole/images/snakeHead4.png");
                snakeHead.paintIcon(this, g, snake.snakexLength[i], snake.snakeyLength[i]);
            }
            if (i != 0) {
                snakeBody = new ImageIcon("com.github.karabosithole/images/snakeimage4.png");
                snakeBody.paintIcon(this, g, snake.snakexLength[i], snake.snakeyLength[i]);
            }
        }

        appleImage = new ImageIcon("com.github.karabosithole/images/apple4.png");

        // Check if the snake eats the apple
        if ((apple.applexPos[xPos]) == snake.snakexLength[0] && (apple.appleyPos[yPos] == snake.snakeyLength[0])) {
            snake.lengthOfSnake++;
            score.increaseScore();
            xPos = random.nextInt(100);
            yPos = random.nextInt(100);

            // Speed up the snake every time the score reaches a multiple of 10
            if (score.getScore() % 5 == 0 && score.getScore() != 0) {
                if (delay > 100) {
                    delay = delay - 100;
                } else if (delay == 100) {
                    delay = delay - 50;
                } else if (delay <= 50 && delay > 20) {
                    delay = delay - 10;
                } else {
                    delay = 20;
                }
                timer.setDelay(delay);
            }
        }

        // If the game hasn't started, the apple won't be visible
        if (snake.moves != 0) {
            appleImage.paintIcon(this, g, apple.applexPos[xPos], apple.appleyPos[yPos]);
        }

        // Display message to start the game
        if (snake.moves == 0) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 26));
            g.drawString("Press Spacebar to Start the Game!", 70, 300);
        }

        // Check if the snake collides with itself
        for (int i = 1; i < snake.lengthOfSnake; i++) {
            // If collision occurs
            if (snake.snakexLength[i] == snake.snakexLength[0] && snake.snakeyLength[i] == snake.snakeyLength[0]) {
                // Call the dead function
                snake.dead();
            }
        }

        // Check if the game is over
        if (snake.death) {
            // Save score to high score file
            score.saveNewScore();

            // Display game over message
            g.setColor(Color.RED);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("Game Over!", 190, 340);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Courier New", Font.BOLD, 18));
            g.drawString("Your Score : " + score.getScore(), 250, 370);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 20));
            g.drawString("Press Spacebar to restart!", 187, 400);
        }
        g.dispose();
    }

    // Method to draw a string on the screen with line breaks
    public void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        timer.start();

        // Control snake movement
        // Move the snake to the right
        if (snake.right) {
            snake.movementRight();
            repaint();
        }
        // Move the snake to the left
        if (snake.left) {
            snake.movementLeft();
            repaint();
        }
        // Move the snake up
        if (snake.up) {
            snake.movementUp();
            repaint();
        }
        // Move the snake down
        if (snake.down) {
            snake.movementDown();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not implemented
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key presses
        switch (e.getKeyCode()) {
            // If user presses shift
            case KeyEvent.VK_SHIFT:
                if (speedUp.compareAndSet(true, false)) {
                    if (delay > 100) {
                        timer.setDelay(delay / 10);
                    } else {
                        timer.setDelay(10);
                    }
                }
                break;
            // If user presses space
            case KeyEvent.VK_SPACE:
                // Start the game
                if (snake.moves == 0) {
                    snake.moves++;
                    snake.right = true;
                }
                // Restart game after death
                if (snake.death) {
                    snake.moves = 0;
                    snake.lengthOfSnake = 5;
                    score.resetScore();
                    repaint();
                    snake.death = false;
                }
                break;
            // If user presses right arrow
            case KeyEvent.VK_RIGHT:
                snake.moveRight();
                break;
            // If user presses left arrow
            case KeyEvent.VK_LEFT:
                snake.moveLeft();
                break;
            // If user presses up arrow
            case KeyEvent.VK_UP:
                snake.moveUp();
                break;
            // If user presses down arrow
            case KeyEvent.VK_DOWN:
                snake.moveDown();
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not implemented
    }
}
