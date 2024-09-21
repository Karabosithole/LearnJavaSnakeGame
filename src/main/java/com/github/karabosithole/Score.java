package com.github.karabosithole;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score {
    private int score;

    // Constructor to initialize the score
    public Score() {
        this.score = 0;
    }

    // Method to increase the score by one
    public void increaseScore() {
        this.score++;
    }

    // Method to reset the score to zero
    public void resetScore() {
        this.score = 0;
    }

    // Method to return the current score for display in Gameplay
    public int getScore() {
        return this.score;
    }

    // Method to retrieve high scores from the file
    public String getHighScore() {
        FileReader readFile = null;
        BufferedReader reader = null;
        try {
            // Read from highscore.dat file
            readFile = new FileReader("highscore.dat");
            reader = new BufferedReader(readFile);

            String line = reader.readLine();
            String allLines = line;

            while (line != null) {
                // Read line by line
                line = reader.readLine();
                // Error handling
                if (line == null)
                    break;
                // Concatenate lines
                allLines = allLines.concat("\n" + line);
            }

            // Return the string exactly as it appears in highscore.dat
            return allLines;
        } catch (Exception e) {
            // Return default high scores if highscore.dat is missing
            return "0\n0\n0\n0\n0\n0\n0\n0\n0\n0";
        } finally {
            try {
                // Close the reader
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to sort high scores
    public void sortHighScore() {
        FileReader readFile = null;
        BufferedReader reader = null;
        FileWriter writeFile = null;
        BufferedWriter writer = null;
        List<Integer> list = new ArrayList<Integer>();
        try {
            readFile = new FileReader("highscore.dat");
            reader = new BufferedReader(readFile);

            String line = reader.readLine();

            // Transfer contents of highscore.dat to an ArrayList
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }

            // Sort the ArrayList
            Collections.sort(list);
            // Reverse it for descending order
            Collections.reverse(list);

            // Write the sorted scores back to highscore.dat
            writeFile = new FileWriter("highscore.dat");
            writer = new BufferedWriter(writeFile);

            int size = list.size();

            // Only the top 10 scores will be written back
            for (int i = 0; i < 10; i++) {
                // Fill in remaining scores with 0
                if (i > size - 1) {
                    String def = "0";
                    writer.write(def);
                } else {
                    // Write each score from the list
                    String str = String.valueOf(list.get(i));
                    writer.write(str);
                }
                if (i < 9) { // Prevent creating a blank line at the end of the file
                    writer.newLine();
                }
            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                // Close the reader
                if (reader != null)
                    reader.close();
                // Close the writer
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                return;
            }
        }
    }

    // Method to save a new score to the file
    public void saveNewScore() {
        String newScore = String.valueOf(this.getScore());

        // Create file for high scores
        File scoreFile = new File("highscore.dat");

        // If the highscore.dat file doesn't exist
        if (!scoreFile.exists()) {
            try {
                // Create a new file
                scoreFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter writeFile = null;
        BufferedWriter writer = null;

        try {
            // Write the new score to the file
            writeFile = new FileWriter(scoreFile, true);
            writer = new BufferedWriter(writeFile);
            writer.write(newScore);
        } catch (Exception e) {
            return;
        } finally {
            try {
                if (writer != null)
                    writer.close();
            } catch (Exception e) {
                return;
            }
        }
    }
}

