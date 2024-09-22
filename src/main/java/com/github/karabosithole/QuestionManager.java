package com.github.karabosithole;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    private List<Question> questions; // List of Question objects

    public QuestionManager() {
        initQuestions();
    }

    // Initialize questions with multiple choices
    public void initQuestions() {
        questions = new ArrayList<>();

        // Add a question with its choices and the correct answer
        questions.add(new Question("What does JVM stand for?",
                new String[] {"A) Java Virtual Machine", "B) Java Visual Model", "C) Java Version Manager", "D) Java Variable Model"},
                0)); // Correct answer is index 0 ("Java Virtual Machine")

        questions.add(new Question("What is the difference between JDK and JRE?",
                new String[] {"A) JDK is for development; JRE is for running Java", "B) JDK is faster than JRE", "C) JRE is the latest version of JDK", "D) JDK is for UI, JRE for back-end"},
                0));

        questions.add(new Question("What is a constructor in Java?",
                new String[] {"A) A method to create objects", "B) A special method to initialize objects", "C) A class that builds other classes", "D) A template for creating objects"},
                1));

        questions.add(new Question("What is polymorphism?",
                new String[] {"A) Ability to take many forms", "B) A type of inheritance", "C) Java method overloading", "D) The ability to create abstract methods"},
                0));

        questions.add(new Question("What is an interface?",
                new String[] {"A) A class that extends another class", "B) A blueprint for classes", "C) A method signature", "D) A way to inherit multiple classes"},
                1));
    }

    // Retrieve a random question
    public Question getRandomQuestion() {
        int randomIndex = (int) (Math.random() * questions.size());
        return questions.get(randomIndex);
    }

    // Display the question and handle the user's answer
    public void displayQuestion() {
        Question question = getRandomQuestion();

        // Show the question with multiple choices
        String selectedAnswer = (String) JOptionPane.showInputDialog(
                null,
                question.getQuestionText(),
                "Multiple Choice Question",
                JOptionPane.QUESTION_MESSAGE,
                null,
                question.getChoices(), // The array of choices (A, B, C, D)
                question.getChoices()[0]); // Default selection (optional)

        // Check if the selected answer is correct
        int selectedIndex = java.util.Arrays.asList(question.getChoices()).indexOf(selectedAnswer);
        if (selectedIndex == question.getCorrectAnswerIndex()) {
            JOptionPane.showMessageDialog(null, "Correct!", "Answer", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong answer. The correct answer is: " + question.getChoices()[question.getCorrectAnswerIndex()], "Answer", JOptionPane.ERROR_MESSAGE);
        }
    }
}
