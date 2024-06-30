package com.github.karabosithole.interactivestory.game;

/**Main.java:
 * Entry point of your application.
 * It initializes necessary components and starts the game.
*/

import com.github.karabosithole.interactivestory.story.Story;
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
        Yaml yaml = new Yaml(new Constructor(Story.class));
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(Paths.get(Main.class.getClassLoader().getResource("story.yaml").toURI()));
            Story story = yaml.load(inputStream);
            Game game = new Game(story);
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

