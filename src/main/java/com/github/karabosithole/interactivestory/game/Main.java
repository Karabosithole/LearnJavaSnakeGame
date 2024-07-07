package com.github.karabosithole.interactivestory.game;

/**Main.java:
 * Entry point of the application.
 * It initializes necessary components and starts the game.
*/

import com.github.karabosithole.interactivestory.story.Story;
import com.github.karabosithole.interactivestory.ui.ConsoleUI;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}