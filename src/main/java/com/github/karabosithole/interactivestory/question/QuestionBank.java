package com.github.karabosithole.interactivestory.question;

/**QuestionBank.java: Manages a collection of questions,
 providing methods to retrieve questions randomly or sequentially.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
    private List<Question> questions;

    public QuestionBank() {
        loadQuestions();
    }

    private void loadQuestions() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            questions = mapper.readValue(new File("src/main/resources/questions.yaml"), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}