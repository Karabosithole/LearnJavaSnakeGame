# Resources Directory

This directory contains YAML configuration files that define the story nodes and questions for the interactive Java learning game. The files are used to manage the storyline and the learning content that players will interact with.

## Files

### 1. story-data.yaml

This file contains the structure of the story, including the nodes and choices that guide the player through the narrative. Each node represents a point in the story where the player can make a decision, and each choice leads to another node or a question.

#### Structure

- `story`: The root element for the story data.
    - `nodes`: A list of story nodes.
        - `id`: A unique identifier for the node.
        - `description`: The narrative text displayed to the player.
        - `choices`: A list of choices available at this node.
            - `text`: The text for the choice.
            - `nextNodeId`: The `id` of the next node if this choice is selected.
            - `questionId`: (Optional) The `id` of the question to be answered if this choice is selected.

#### Example

```yaml
story:
  nodes:
    - id: "start"
      description: "You wake up in a mysterious forest. What do you do?"
      choices:
        - text: "Explore the forest"
          nextNodeId: "explore_forest"
        - text: "Stay where you are"
          nextNodeId: "stay_put"
    - id: "explore_forest"
      description: "You find a hidden path leading to a cave. Before you enter, solve this coding challenge:"
      questionId: "java_variable_question"
      choices:
        - text: "Enter the cave"
          nextNodeId: "enter_cave"
        - text: "Go back"
          nextNodeId: "start"

### 2. questions.yaml

This file contains the questions that are used to test the player's knowledge of Java concepts. Each question includes a text prompt and multiple choices, with one or more correct answers.

#### Structure

- `questions`: The root element for the question data.
    - `id`: A unique identifier for the question.
    - `text`: The text of the question.
    - `choices`: A list of possible answers.
        - `text`: The text of the choice.
        - `correct`: A boolean indicating if this choice is correct.

#### Example

```yaml
questions:
  - id: "java_variable_question"
    text: "Which of the following correctly declares an integer variable in Java?"
    choices:
      - text: "int number = 5;"
        correct: true
      - text: "var number = '5';"
        correct: false
      - text: "integer number = 5;"
        correct: false

## Purpose

The story-data.yaml file defines the narrative flow of the game, allowing players to navigate through different story nodes based on their choices. The questions.yaml file provides educational content that challenges the player to apply their Java knowledge at key points in the story.

## Usage

- **Load Story Data:** The game loads the story data from story-data.yaml to determine the narrative structure and available choices.
- **Load Question Data:** The game loads the question data from questions.yaml to present coding challenges to the player.
- **Navigate Story:** Players navigate through the story nodes by making choices, answering questions, and progressing based on their decisions and knowledge.

By organizing the story and questions in YAML files, the game can be easily updated and expanded with new content, providing a dynamic and interactive learning experience.
