package com.github.karabosithole;

public class Snake {
    // Arrays to determine the position of the snake
    int[] snakexLength = new int[750];
    int[] snakeyLength = new int[750];

    // Length of the snake and movement counter
    int lengthOfSnake;
    int moves;

    // Direction of the snake's movement
    boolean left;
    boolean right;
    boolean up;
    boolean down;

    // Indicates whether the snake has died
    boolean death;

    // Constructor to initialize the snake's state
    public Snake() {
        this.left = false;
        this.right = false;
        this.up = false;
        this.down = false;
        this.death = false;
        this.lengthOfSnake = 5;
        this.moves = 0;
    }

    // Method to move the snake right
    public void moveRight() {
        if (this.moves != 0 && !this.death) {
            this.moves++;
            if (!this.left) {
                this.right = true;
            } else {
                this.right = false;
                this.left = true;
            }
            this.up = false;
            this.down = false;
        }
    }

    // Method to move the snake left
    public void moveLeft() {
        if (this.moves != 0 && !this.death) {
            this.moves++;
            if (!this.right) {
                this.left = true;
            } else {
                this.left = false;
                this.right = true;
            }
            this.up = false;
            this.down = false;
        }
    }

    // Method to move the snake up
    public void moveUp() {
        if (this.moves != 0 && !this.death) {
            this.moves++;
            if (!this.down) {
                this.up = true;
            } else {
                this.up = false;
                this.down = true;
            }
            this.left = false;
            this.right = false;
        }
    }

    // Method to move the snake down
    public void moveDown() {
        if (this.moves != 0 && !this.death) {
            this.moves++;
            if (!this.up) {
                this.down = true;
            } else {
                this.down = false;
                this.up = true;
            }
            this.left = false;
            this.right = false;
        }
    }

    // Method to handle snake death
    public void dead() {
        // Prevent the snake from moving
        this.right = false;
        this.left = false;
        this.up = false;
        this.down = false;
        this.death = true;
    }

    // Method to move the snake right
    public void movementRight() {
        // Move the head to the next index
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakeyLength
            this.snakeyLength[i + 1] = this.snakeyLength[i];
        }
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakexLength
            if (i == 0) {
                this.snakexLength[i] = this.snakexLength[i] + 6;
            } else {
                this.snakexLength[i] = this.snakexLength[i - 1];
            }
            // Check for boundary collision on the right
            if (this.snakexLength[0] > 637) {
                // Wrap the head back into the board
                this.snakexLength[0] -= 6;
                // Snake dies
                dead();
            }
        }
    }

    // Method to move the snake left
    public void movementLeft() {
        // Move the head to the next index
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakeyLength
            this.snakeyLength[i + 1] = this.snakeyLength[i];
        }
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakexLength
            if (i == 0) {
                this.snakexLength[i] = this.snakexLength[i] - 6;
            } else {
                this.snakexLength[i] = this.snakexLength[i - 1];
            }
            // Check for boundary collision on the left
            if (this.snakexLength[0] < 25) {
                // Wrap the head back into the board
                this.snakexLength[0] += 6;
                // Snake dies
                dead();
            }
        }
    }

    // Method to move the snake up
    public void movementUp() {
        // Move the head to the next index
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakexLength
            this.snakexLength[i + 1] = this.snakexLength[i];
        }
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakeyLength
            if (i == 0) {
                this.snakeyLength[i] = this.snakeyLength[i] - 6;
            } else {
                this.snakeyLength[i] = this.snakeyLength[i - 1];
            }
            // Check for boundary collision at the top
            if (this.snakeyLength[0] < 73) {
                // Wrap the head back into the board
                this.snakeyLength[0] += 6;
                // Snake dies
                dead();
            }
        }
    }

    // Method to move the snake down
    public void movementDown() {
        // Move the head to the next index
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakexLength
            this.snakexLength[i + 1] = this.snakexLength[i];
        }
        for (int i = this.lengthOfSnake - 1; i >= 0; i--) {
            // Shift the position of snakeyLength
            if (i == 0) {
                this.snakeyLength[i] = this.snakeyLength[i] + 6;
            } else {
                this.snakeyLength[i] = this.snakeyLength[i - 1];
            }
            // Check for boundary collision at the bottom
            if (this.snakeyLength[0] > 679) {
                // Wrap the head back into the board
                this.snakeyLength[0] -= 6;
                // Snake dies
                dead();
            }
        }
    }
}
