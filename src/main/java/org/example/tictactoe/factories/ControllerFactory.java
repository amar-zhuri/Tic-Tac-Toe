package org.example.tictactoe.factories;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.tictactoe.controllers.AIDifficultyController;
import org.example.tictactoe.controllers.EnterNamesController;

import java.io.IOException;
import org.tinylog.Logger;

/**
 * Factory class for creating and configuring JavaFX controllers and stages.
 * <p>
 * This class provides methods to load and return pre-configured stages for
 * various screens in the Tic-Tac-Toe application.
 * </p>
 */
public class ControllerFactory {

    /**
     * Creates a stage for the AI Difficulty Selection screen.
     * <p>
     * Loads the `AIDifficulty.fxml` file, sets up the controller, and binds
     * the provided listener to handle difficulty selection events.
     * </p>
     *
     * @param listener The listener to handle difficulty selection and player name input.
     * @return A configured Stage for the AI Difficulty Selection screen.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public static Stage createAIDifficultyStage(AIDifficultyController.DifficultySelectionListener listener) throws IOException {
        Stage stage = null;
        try {
            FXMLLoader loader = new FXMLLoader(ControllerFactory.class.getResource("/org/example/views/AIDifficulty.fxml"));
            stage = new Stage();
            stage.setTitle("AI Difficulty");
            stage.setScene(new Scene(loader.load()));

            AIDifficultyController controller = loader.getController();
            controller.setDifficultySelectionListener(listener);
        } catch (IOException e) {
            Logger.error("Failed to load FXML (AIDifficulty.fxml) file", e);
        }


        return stage;
    }

    /**
     * Creates a stage for the Player Name Input screen.
     * <p>
     * Loads the `EnterNames.fxml` file, sets up the controller, and binds
     * the provided listener to handle name input events.
     * </p>
     *
     * @param listener The listener to handle player name input events.
     * @return A configured Stage for the Player Name Input screen.
     * @throws IOException If the FXML file cannot be loaded.
     */
    public static Stage createPlayerNamesStage(EnterNamesController.NameInputListener listener) throws IOException {
        Stage stage = null;
        try {
            FXMLLoader loader = new FXMLLoader(ControllerFactory.class.getResource("/org/example/views/EnterNames.fxml"));
            stage = new Stage();
            stage.setTitle("Enter Player Names");
            stage.setScene(new Scene(loader.load()));

            EnterNamesController controller = loader.getController();
            controller.setNameInputListener(listener);
        } catch (IOException e) {
            Logger.error("Failed to load FXML (EnterNames.fxml) file", e);
        }


        return stage;
    }
}
