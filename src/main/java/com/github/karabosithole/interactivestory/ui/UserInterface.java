package com.github.karabosithole.interactivestory.ui;

/**UserInterface.java:
 *Defines an interface for UI-related operations,
 * allowing flexibility in implementing different UI types (e.g., console, GUI).
 */



import com.github.karabosithole.interactivestory.question.Question;
import com.github.karabosithole.interactivestory.story.Choice;
import com.github.karabosithole.interactivestory.story.StoryNode;

import java.util.List;

public interface UserInterface {
    void displayText(String text);
    void displayChoices(List<Choice> choices);
    int getChoice(int numChoices);
}