package com.github.karabosithole.utils;

import com.github.karabosithole.model.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {

    public static List<Question> loadQuestions(String filePath) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String questionText = parts[0];
                String[] answers = {parts[1], parts[2], parts[3]};
                int correctAnswerIndex = Integer.parseInt(parts[4]);
                questions.add(new Question(questionText, answers, correctAnswerIndex));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
