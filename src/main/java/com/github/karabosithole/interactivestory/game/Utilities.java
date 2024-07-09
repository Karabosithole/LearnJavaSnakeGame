package com.github.karabosithole.interactivestory.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.story.StoryNode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Utilities.java:
 * Utility methods that support various functionalities across the game.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.karabosithole.interactivestory.story.StoryNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Utilities {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean isPositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int getValidIntegerInput(int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter a choice (" + min + " - " + max + "): ");
            String input = scanner.nextLine();
            if (isPositiveInteger(input)) {
                choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    break;
                }
            }
            System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
        }
        return choice;
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}