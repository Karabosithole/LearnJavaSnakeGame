package com.github.karabosithole.interactivestory.ui;

/**UserInterface.java:
 *Defines an interface for UI-related operations,
 * allowing flexibility in implementing different UI types (e.g., console, GUI).
 */



import com.github.karabosithole.interactivestory.question.Question;
import com.github.karabosithole.interactivestory.story.Choice;

import java.util.List;

public interface UserInterface {
    void displayStory(String story);

    void displayQuestion(Question question);

    void displayChoices(List<Choice> choices);

    String getUserInput();
}