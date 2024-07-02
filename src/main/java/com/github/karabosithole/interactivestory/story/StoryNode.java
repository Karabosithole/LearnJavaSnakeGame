package com.github.karabosithole.interactivestory.story;

/**StoryNode Class:
 *Purpose: The StoryNode class represents individual nodes or points the interactive story.
 *Each StoryNode encapsulates information about a specific narrative point,
 * including its description, associated choices, and optionally a question or challenge.
 *Responsibilities:
 *Hold information such as id, description, choices, and questionId.
 *Provide methods to retrieve and manipulate this information.
 */


import java.util.List;

public class StoryNode {
    private String id;
    private String description;
    private List<Choice> choices;
    private String questionId;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
