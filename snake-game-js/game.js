const questions = [
    {
        question: "What does JVM stand for?",
        answers: ["A) Java Virtual Machine", "B) Java Visual Model", "C) Java Version Manager", "D) Java Variable Model"],
        correct: 0 // Index of the correct answer
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

function displayQuestion() {
    const questionElement = document.getElementById('question');
    const answersElement = document.getElementById('answers');
    const feedbackElement = document.getElementById('feedback');
    const nextButton = document.getElementById('next');

    feedbackElement.textContent = ''; // Clear feedback
    nextButton.style.display = 'none'; // Hide next button

    const currentQuestion = questions[currentQuestionIndex];
    questionElement.textContent = currentQuestion.question;
    answersElement.innerHTML = ''; // Clear previous answers

    currentQuestion.answers.forEach((answer, index) => {
        const button = document.createElement('button');
        button.textContent = answer;
        button.onclick = () => checkAnswer(index);
        answersElement.appendChild(button);
    });
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

    nextButton.style.display = 'block'; // Show next button
}

document.getElementById('next').onclick = () => {
    currentQuestionIndex++;
    if (currentQuestionIndex < questions.length) {
        displayQuestion();
    } else {
        document.getElementById('question').textContent = 'Quiz Completed!';
        document.getElementById('answers').innerHTML = '';
        document.getElementById('next').style.display = 'none';
    }
};

// Start the game
displayQuestion();
