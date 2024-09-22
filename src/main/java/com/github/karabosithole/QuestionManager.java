package com.github.karabosithole;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    private List<String> questions; // List of questions to ask


    public QuestionManager(){
        initQuestions();

    }

    public void initQuestions(){
        questions = new ArrayList<>();
        questions.add("What does JVM stand for?");
        questions.add("What is the difference between JDK and JRE?");
        questions.add("What is a constructor in Java?");
        questions.add("What is polymorphism?");
        questions.add("What is an interface?");

    }

    // Retrieve a random question
    public String getRandomQuestion() {
        int randomIndex = (int) (Math.random() * questions.size());
        return questions.get(randomIndex);
    }

    // Display a question (could be customized further)
    public void displayQuestion() {
        String question = getRandomQuestion();
        JOptionPane.showMessageDialog(null, question, "Java Question", JOptionPane.INFORMATION_MESSAGE);
    }

}
