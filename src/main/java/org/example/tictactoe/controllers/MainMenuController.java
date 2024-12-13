package org.example.tictactoe.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import org.example.tictactoe.factories.ControllerFactory;
import org.example.tictactoe.utils.ErrorHandler;
import java.io.IOException;

/**
 * Controller class for the Main Menu screen of the Tic-Tac-Toe application.
 * <p>
 * This class provides options to select the game mode (Player vs AI or Player vs Player)
 * and navigates to the respective screens based on the user's choice.
 * </p>
 */
public class MainMenuController {

    /**
     * Button to start the game after selecting a game mode.
     */
    public Button startButton;
    /**
     * Radio button for selecting the "Player vs AI" and "Player vs Player"mode.
     */
    @FXML
    private RadioButton aiOption, pvpOption;

    /**
     * Toggle group for managing game mode selection.
     */
    private ToggleGroup gameModeGroup;

    /**
     * Initializes the Main Menu controller.
     * <p>
     * Sets up the toggle group for the radio buttons and binds the Start button's action
     * to handle user input.
     * </p>
     */
    @FXML
    private void initialize() {
        try {
            gameModeGroup = new ToggleGroup();
            aiOption.setToggleGroup(gameModeGroup);
            pvpOption.setToggleGroup(gameModeGroup);
            startButton.setOnAction(actionEvent -> handleStartButton());
        }catch (Exception e){
            ErrorHandler.logAndShowError("Could't initialize Main Menu",e);
        }

    }
    /**
     * Handles the action when the Start button is clicked.
     * <p>
     * Depending on the selected game mode, it opens the respective screen for AI difficulty
     * selection or player name input. If no game mode is selected, a warning is shown.
     * </p>
     */
    @FXML
    private void handleStartButton() {
        try {
            if (aiOption.isSelected()) {
                openAIDifficultySelection();
            } else if (pvpOption.isSelected()) {
                openPlayerNameInput();
            } else {
                ErrorHandler.logAndShowWarning("No game mode selected!", null);
            }
        } catch (Exception e) {
            ErrorHandler.logAndShowError("Failed to start the game mode selection.", e);
        }
    }

    /**
     * Opens the AI Difficulty Selection screen.
     * <p>
     * This method creates a new stage for selecting the AI difficulty and handles the
     * user's input to start the game.
     * </p>
     */
    private void openAIDifficultySelection() {
        final Stage[] stage = {null};
        try {
            stage[0] = ControllerFactory.createAIDifficultyStage((difficultyLevel, playerName) -> {
                startGame(true, playerName, "AI", difficultyLevel);
                if (stage[0] != null) {
                    stage[0].close();
                }
            });
            stage[0].show();
        } catch (IOException e) {
            if (stage[0] != null) {
                stage[0].close();
            }
            ErrorHandler.logAndShowError("Failed to open AI Difficulty selection screen.", e);

        }
    }
    /**
     * Opens the Player Name Input screen.
     * <p>
     * This method creates a new stage for entering player names and handles the
     * user's input to start the game in Player vs Player mode.
     * </p>
     */
    private void openPlayerNameInput() {
        final Stage[] stage = {null}; // Use a single-element array to hold the stage
        try {
            stage[0] = ControllerFactory.createPlayerNamesStage((player1Name, player2Name) -> {
                startGame(false, player1Name, player2Name, null);
                if (stage[0] != null) {
                    stage[0].close();
                }
            });
            stage[0].show();
        } catch (IOException e) {
            if (stage[0] != null) {
                stage[0].close();
            }
            ErrorHandler.logAndShowError("Failed to open Player Name input screen.", e);
        }
    }

    /**
     * Starts the game with the specified settings.
     * <p>
     * This method loads the game board screen and initializes the game controller with the
     * provided parameters.
     * </p>
     *
     * @param isAI          Whether the game is Player vs AI or Player vs Player.
     * @param player1Name   The name of Player 1.
     * @param player2Name   The name of Player 2 (or "AI" for AI games).
     * @param aiDifficulty  The AI difficulty level (if playing against AI).
     */
    private void startGame(boolean isAI, String player1Name, String player2Name, String aiDifficulty) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/views/GameBoard.fxml"));
            Stage stage = (Stage) aiOption.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));

            GameController controller = loader.getController();
            controller.initializeGame(isAI, aiDifficulty, player1Name, player2Name);

        } catch (IOException e) {
            ErrorHandler.logAndShowError("Failed to start the game.", e);
        }
    }
}
