# Java Multiple-Choice Quiz Game

## Overview
This is a simple multiple-choice quiz game built in Java using the Swing framework. The game randomly selects a question from a pool of Java-related questions and presents it to the user along with four possible answers. The user must choose the correct answer from the options presented. Immediate feedback is given on whether the answer is correct or incorrect.

For detailed documentation and project motivation, visit the [Wiki Home](https://github.com/Karabosithole/LearnJavaSnakeGame). 

## Features
- Multiple-choice questions related to Java programming.
- Random question selection from a pool of predefined questions.
- Interactive GUI using Java Swing for question display and user input.
- Immediate feedback after each answer.
- Easy to extend with additional questions and answers.

## Installation

### Prerequisites
- Java 8 or higher
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or simply `javac` for command-line compilation

### Steps
1. Clone this repository or download the source code:
   ```bash
   git clone https://github.com/your-username/java-multiple-choice-quiz.git
   ```
2. Open the project in your preferred Java IDE or navigate to the folder in the terminal.
3. Compile and run the `Main` class to start the quiz game.

   Using the terminal:
   ```bash
   javac com/github/karabosithole/Main.java
   java com.github.karabosithole.Main
   ```

## How to Play
1. When the game starts, a question will be displayed with four answer choices (A, B, C, D).
2. Select one of the answers from the dialog box.
3. You will receive immediate feedback on whether your answer was correct or incorrect.
4. The game will then ask the next question after a short delay.

### Example Flow
1. **Question**: What does JVM stand for?
   - A) Java Virtual Machine
   - B) Java Visual Model
   - C) Java Version Manager
   - D) Java Variable Model

   **Answer**: If the user selects "A) Java Virtual Machine," they receive a message indicating whether they were correct.

## Adding More Questions
To add more questions to the game, follow these steps:
1. Open the `QuestionManager` class.
2. In the `initQuestions()` method, add a new `Question` object with your custom question, answer choices, and the index of the correct answer.

```bash
Questions.add(new Question("Your custom question?",
   new String[] {"A) Option1", "B) Option2", "C) Option3", "D) Option4"},
   2)); // Correct answer is the 3rd option (index 2)
```

## Technologies Used
- **Java**: Programming language used to develop the game.
- **Swing**: Java's GUI framework to display dialogs and capture user input.

## Credits
Created by Karabo Sithole.
