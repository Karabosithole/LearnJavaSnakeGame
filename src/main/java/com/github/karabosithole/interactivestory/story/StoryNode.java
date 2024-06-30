package com.github.karabosithole.interactivestory.story;

/**StoryNode Class:
 *Purpose: The StoryNode class represents individual nodes or points the interactive story.
 *Each StoryNode encapsulates information about a specific narrative point,
 * including its description, associated choices, and optionally a question or challenge.
 *Responsibilities:
 *Hold information such as id, description, choices, and questionId.
 *Provide methods to retrieve and manipulate this information.
 */


import java.util.ArrayList;
import java.util.List;

    public class StoryNode {
        private String text;
        private List<Choice> choices;
        private String Id;

        public StoryNode(String text) {
            this.text = text;
            this.choices = new ArrayList<>();
        }

        public String getText() {
            return text;
        }

        public List<Choice> getChoices() {
            return choices;
        }

        public void addChoice(Choice choice) {
            choices.add(choice);
        }

        public String getId() {
            return this.Id;
        }
    }


