package com.github.karabosithole.interactivestory.game;
import com.github.karabosithole.interactivestory.*;
/**Main.java:
 * Entry point of your application.
 * It initializes necessary components and starts the game.
*/

import com.github.karabosithole.interactivestory.story.Story;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        Yaml yaml = new Yaml(new Constructor(Story.class));
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("story.yaml");
        Story story = yaml.load(inputStream);

        // Now you can access the nodes and learning paths from the story object
        System.out.println(story.getNodes());
        System.out.println(story.getLearningPaths());
    }
}
