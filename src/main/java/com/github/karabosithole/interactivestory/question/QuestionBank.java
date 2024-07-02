package com.github.karabosithole.interactivestory.question;

/**QuestionBank.java: Manages a collection of questions,
 providing methods to retrieve questions randomly or sequentially.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBank {
    private Map<String, Question> questions = new HashMap<>();

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    public Question getQuestion(String id) {
        return questions.get(id);
    }

    // Method to load questions from YAML (implementation to be added)
}