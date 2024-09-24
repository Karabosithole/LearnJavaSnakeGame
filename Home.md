# Snake Game Project Wiki

## Overview
The Snake Game is a fun and interactive project developed in Java, where players control a snake to eat apples and answer trivia questions after each successful catch. This project was designed to reinforce my Java skills through hands-on practice while creating an engaging and educational game.

---

## Project Motivation

### Why I Did the Project
I created the Snake Game primarily to learn Java by practicing through an actual project. As someone with ADHD, I find that hands-on, interactive learning works best for me, so developing a game allowed me to make the learning process fun and effective. My goal was to deepen my understanding of Java concepts while simultaneously creating an enjoyable experience.

### Target Audience
This game is aimed at casual gamers and trivia enthusiasts who enjoy quick, fun games that also challenge their knowledge. It could also be useful for educators seeking innovative ways to engage students with learning through gamification.

---

## Learning Objectives
In this project, I focused on achieving several learning goals:
- **Object-Oriented Programming (OOP)**: Understanding and applying OOP principles in Java, including classes, inheritance, and polymorphism.
- **GUI Development**: Designing a graphical user interface using Java's Swing library to create an interactive gaming experience.
- **Event Handling**: Managing real-time player input and game events like key presses and game over states.
- **Game Logic**: Implementing the core game mechanics such as movement, apple consumption, score calculation, and trivia integration.

---

## Development Process

### Tools and Technologies
- **Java (JDK 17)**: The main programming language used to develop the Snake Game.
- **Swing**: Java’s built-in GUI toolkit for building the graphical interface.
- **Git**: For version control and collaboration.
- **IDE**: Used IntelliJ IDEA for development.

### Key Design Decisions
- **Modular Code Structure**: To make the code more readable and maintainable, I broke down the project into separate classes such as `Snake`, `Apple`, `GameBoard`, and `TriviaQuestion`.
- **Trivia Integration**: After each apple consumption, the player is presented with a trivia question to enhance the gameplay and make it both fun and educational.

---

## Challenges and Solutions

### Challenge: Real-Time Event Handling
One of the challenges I faced was managing the game loop while simultaneously handling real-time player input without slowing down the game. 

**Solution**: I solved this by using `KeyListener` and an efficient game loop structure that checks for input asynchronously, ensuring smooth gameplay.

### Challenge: Collision Detection
Detecting when the snake collided with itself or the game boundaries posed a problem due to the continuous movement logic.

**Solution**: I implemented precise boundary checks and a method that checks for collisions with the snake's own body, ensuring the game ends correctly when necessary.

### Challenge: Trivia Question Timing
Integrating trivia questions after the snake eats an apple was tricky in terms of pausing the game and resuming after the answer.

**Solution**: I added a trivia screen that pops up when the snake eats an apple, which halts the game temporarily and resumes only when the player answers the question.

---

## Reflections

This project reaffirmed my love for learning through practice and play. As someone with ADHD, I often find traditional learning methods challenging, but creating something interactive and engaging made the entire process enjoyable. Through this project, I not only strengthened my Java programming skills but also learned how to work on a project that requires real-time interaction and user input.

This experience reinforced my belief that gamification can be a powerful tool for learning. It also taught me the value of persistence—when facing challenges like handling event-driven programming and implementing complex game logic, I learned how to break problems down and solve them step by step.

---

## Future Improvements

While the Snake Game is fully functional, I see a few areas for potential enhancement:
- **Mobile Compatibility**: I plan to adapt the game to work on mobile devices, using frameworks like LibGDX for Java-based game development on Android.
- **Multiplayer Mode**: Adding a multiplayer mode where two players can control different snakes, competing to collect the most apples while answering trivia questions.
- **Question Bank Expansion**: I aim to expand the trivia question bank to cover more categories and difficulty levels, making the game even more educational.

---

## How to Play

1. **Movement**: Use the arrow keys to control the direction of the snake.
2. **Objective**: Eat apples to score points.
3. **Trivia**: After each apple is eaten, answer a trivia question to continue the game.
4. **Game Over**: The game ends if the snake collides with itself or the game boundary.

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/karabosithole/snake-game.git
