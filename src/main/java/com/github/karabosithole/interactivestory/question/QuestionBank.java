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

import java.util.List;

public class QuestionBank {
    private List<Question> questions;

    // Getter and setter

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestionById(String id) {
        for (Question question : questions) {
            if (question.getId().equals(id)) {
                return question;
            }
        }
        return null;
    }
}