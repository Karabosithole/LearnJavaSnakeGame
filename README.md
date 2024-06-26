interactive-story/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── interactivestory/
│   │   │   │   │   ├── game/
│   │   │   │   │   │   ├── Game.java               # Main game class
│   │   │   │   │   │   ├── Main.java               # Entry point
│   │   │   │   │   │   └── Utilities.java          # Utility methods
│   │   │   │   │   │
│   │   │   │   │   ├── story/
│   │   │   │   │   │   ├── StoryNode.java          # Story node class
│   │   │   │   │   │   ├── Choice.java             # Choice class
│   │   │   │   │   │   └── LearningPath.java       # Learning path class
│   │   │   │   │   │
│   │   │   │   │   ├── user/
│   │   │   │   │   │   └── User.java               # User class
│   │   │   │   │   │
│   │   │   │   │   ├── question/
│   │   │   │   │   │   ├── Question.java           # Question class
│   │   │   │   │   │   └── QuestionBank.java       # Store and manage questions
│   │   │   │   │   │
│   │   │   │   │   └── ui/
│   │   │   │   │       ├── ConsoleUI.java          # Console UI handling
│   │   │   │   │       └── UserInterface.java      # UI interface
│   │   │   │   │
│   │   │   │   └── resources/                      # Resource files (configurations, etc.)
│   │   │   │       ├── story-data.yaml             # Story data
│   │   │   │       ├── questions.yaml              # Questions data
│   │   │   │       └── README.md                   # Documentation
│   │   │   │
│   │   └── test/                                   # Test sources
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── interactivestory/
│   │       │           ├── game/
│   │       │           │   └── GameTest.java       # Test cases for Game class
│   │       │           ├── story/
│   │       │           │   └── StoryNodeTest.java  # Test cases for StoryNode class
│   │       │           ├── user/
│   │       │           │   └── UserTest.java       # Test cases for User class
│   │       │           ├── question/
│   │       │           │   ├── QuestionTest.java   # Test cases for Question class
│   │       │           │   └── QuestionBankTest.java# Test cases for QuestionBank class
│   │       │           └── ui/
│   │       │               └── ConsoleUITest.java  # Test cases for ConsoleUI class
│   │       │
│   │       └── resources/                          # Test resources
│   │
├── build.gradle                                    # Gradle build script
└── README.md                                       # Project documentation
# TeachMeJava
