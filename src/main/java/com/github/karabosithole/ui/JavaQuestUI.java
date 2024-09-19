package com.github.karabosithole.ui;

// UI setup example
import com.github.karabosithole.model.AdventureMazeGame;
import com.github.karabosithole.model.Character;
import com.github.karabosithole.service.GameService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import static jdk.internal.org.jline.terminal.Terminal.MouseTracking.Button;

public class JavaQuestUI extends Application {
    private AdventureMazeGame game;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaQuest");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your character's name");

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> {
            String name = nameField.getText();
            Character player = new Character(name, "Warrior"); // Default character type
            game = new AdventureMazeGame(player, 10, 10);
            game.startGame();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameField, startButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}