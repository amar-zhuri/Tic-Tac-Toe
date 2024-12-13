package org.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.tinylog.Logger;

/**
 * The entry point for the Tic-Tac-Toe application.
 * <p>
 * This class initializes the JavaFX application, loads the main menu, and sets up the primary stage.
 * It also provides error handling and logging for application startup.
 * </p>
 */
public class Main extends Application {
    /**
     * Starts the JavaFX application.
     * <p>
     * This method sets up the main menu by loading the corresponding FXML file, applying styles,
     * and configuring the primary stage. It also handles errors that might occur during the initialization process.
     * </p>
     *
     * @param primaryStage The primary stage for the JavaFX application.
     * @throws Exception If there is an error during the initialization of the application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Logger.info("Starting Tic-Tac-Toe application.");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/views/MainMenu.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(getClass().getResource("/styles/style.css").toExternalForm());

            primaryStage.setWidth(390);
            primaryStage.setHeight(500);
            primaryStage.setTitle("Tic-Tac-Toe");
            primaryStage.setScene(scene);

            Logger.info("Main Menu loaded successfully.");
            primaryStage.show();
        } catch (Exception e) {
            Logger.error(e, "Error loading the main menu.");
        }
    }
}
