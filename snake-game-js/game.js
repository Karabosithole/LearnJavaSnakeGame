const questions = [
    {
        question: "What does JVM stand for?",
        answers: ["A) Java Virtual Machine", "B) Java Visual Model", "C) Java Version Manager", "D) Java Variable Model"],
        correct: 0
    },
    {
        question: "Which of these is not a Java keyword?",
        answers: ["A) public", "B) static", "C) void", "D) main"],
        correct: 3
    },
    {
        question: "What is the extension of Java files?",
        answers: ["A) .jav", "B) .java", "C) .class", "D) .js"],
        correct: 1
    },
    // Add more questions here
];

let currentQuestionIndex = 0;
let score = 0;
let snake = [{ x: 10, y: 10 }];
let apple = { x: 15, y: 15 };
let gameCanvas = document.getElementById("gameCanvas");
let ctx = gameCanvas.getContext("2d");
let box = 20;
let d;
let gameSpeed = 200; // Adjust the speed of the game (lower is faster)
let game;

// Control whether the game is paused
let isPaused = false;

document.addEventListener("keydown", direction);

function direction(event) {
    if (event.keyCode == 37 && d != "RIGHT") {
        d = "LEFT";
    } else if (event.keyCode == 38 && d != "DOWN") {
        d = "UP";
    } else if (event.keyCode == 39 && d != "LEFT") {
        d = "RIGHT";
    } else if (event.keyCode == 40 && d != "UP") {
        d = "DOWN";
    }
}

function draw() {
    if (isPaused) return; // Pause the game if isPaused is true

    ctx.clearRect(0, 0, gameCanvas.width, gameCanvas.height);
    for (let i = 0; i < snake.length; i++) {
        ctx.fillStyle = (i === 0) ? "green" : "white";
        ctx.fillRect(snake[i].x * box, snake[i].y * box, box, box);
        ctx.strokeStyle = "black";
        ctx.strokeRect(snake[i].x * box, snake[i].y * box, box, box);
    }

    ctx.fillStyle = "red";
    ctx.fillRect(apple.x * box, apple.y * box, box, box);

    let snakeX = snake[0].x;
    let snakeY = snake[0].y;

    if (d === "LEFT") snakeX--;
    if (d === "UP") snakeY--;
    if (d === "RIGHT") snakeX++;
    if (d === "DOWN") snakeY++;

    if (snakeX === apple.x && snakeY === apple.y) {
        score++;
        apple = {
            x: Math.floor(Math.random() * (gameCanvas.width / box)),
            y: Math.floor(Math.random() * (gameCanvas.height / box))
        };
        displayQuestion();
    } else {
        snake.pop();
    }

    // Check collision with itself or walls
    if (snakeX < 0 || snakeX >= gameCanvas.width / box || snakeY < 0 || snakeY >= gameCanvas.height / box || collision(snakeX, snakeY, snake)) {
        clearInterval(game);
        alert("Game Over! Score: " + score);
    }

    let newHead = { x: snakeX, y: snakeY };
    snake.unshift(newHead);
}

function collision(x, y, snake) {
    for (let i = 1; i < snake.length; i++) {
        if (snake[i].x === x && snake[i].y === y) {
            return true;
        }
    }
    return false;
}

// Display question when snake eats apple
function displayQuestion() {
    isPaused = true; // Pause the game
    const questionElement = document.getElementById('question');
    const answersElement = document.getElementById('answers');
    const feedbackElement = document.getElementById('feedback');
    const nextButton = document.getElementById('next');

    feedbackElement.textContent = ''; // Clear feedback
    nextButton.style.display = 'none'; // Hide next button

    if (currentQuestionIndex < questions.length) {
        questionElement.textContent = questions[currentQuestionIndex].question;
        questionElement.style.display = 'block';
        answersElement.innerHTML = ''; // Clear previous answers

        questions[currentQuestionIndex].answers.forEach((answer, index) => {
            const button = document.createElement('button');
            button.textContent = answer;
            button.onclick = () => checkAnswer(index);
            answersElement.appendChild(button);
        });
        answersElement.style.display = 'block'; // Show answers
    } else {
        questionElement.textContent = 'Quiz Completed!';
        answersElement.innerHTML = '';
        nextButton.style.display = 'none';
    }
}

function checkAnswer(selectedIndex) {
    const feedbackElement = document.getElementById('feedback');
    const nextButton = document.getElementById('next');
    const currentQuestion = questions[currentQuestionIndex];

    if (selectedIndex === currentQuestion.correct) {
        feedbackElement.textContent = 'Correct!';
    } else {
        feedbackElement.textContent = 'Incorrect! The correct answer is: ' + currentQuestion.answers[currentQuestion.correct];
    }

    currentQuestionIndex++;
    nextButton.style.display = 'block'; // Show next button
}

document.getElementById('next').onclick = () => {
    const questionElement = document.getElementById('question');
    const answersElement = document.getElementById('answers');

    questionElement.style.display = 'none';
    answersElement.style.display = 'none';
    document.getElementById('feedback').textContent = ''; // Clear feedback

    isPaused = false; // Resume the game
};

// Start the game
game = setInterval(draw, gameSpeed);
