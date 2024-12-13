package org.example.tictactoe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.tictactoe.utils.ErrorHandler;
import org.tinylog.Logger;
/**
 * Controller class for the AI Difficulty Selection screen in the Tic-Tac-Toe game.
 * <p>
 * This class manages the user interface where players can:
 * <ul>
 *   <li>Select the AI difficulty level (Easy or Hard).</li>
 *   <li>Enter their player name.</li>
 * </ul>
 * The selected difficulty and player name are passed to a listener for further game initialization.
 * </p>
 */
public class AIDifficultyController {
    /**
     * Button to confirm the selected AI difficulty and start the game.
     */
    public Button startButton;
    /**
     * Radio button for selecting the "Easy" and "Hard" difficulty level.
     */
    @FXML
    private RadioButton easyButton, hardButton;
    /**
     * Text field for entering the player's name.
     */
    @FXML
    private TextField playerNameField;

    /**
     * Listener to handle the selected AI difficulty and player name.
     */
    private DifficultySelectionListener listener;

   /* @FXML
    private ToggleGroup difficultyGroup;*/

    /**
     * Initializes the AI Difficulty Selection screen.
     * <p>
     * This method is automatically called after the FXML file is loaded.
     * It sets up a toggle group for difficulty level buttons and assigns
     * an action handler to the "Start Game" button.
     * </p>
     */
    @FXML
    private void initialize() {
        Logger.info("Initializing AI Difficulty Controller.");
        ToggleGroup difficultyGroup = new ToggleGroup();
        easyButton.setToggleGroup(difficultyGroup);
        hardButton.setToggleGroup(difficultyGroup);
        startButton.setOnAction(event->handleStartButton());
    }

    /**
     * Handles the action of the "Start Game" button.
     * <p>
     * This method performs the following:
     * <ul>
     *   <li>Validates that a player name is entered.</li>
     *   <li>Determines the selected AI difficulty level.</li>
     *   <li>Passes the difficulty and player name to the listener if valid.</li>
     * </ul>
     * If validation fails, a warning message is logged and shown to the user.
     * </p>
     */
    @FXML
    private void handleStartButton() {
        try {
            String difficulty = easyButton.isSelected() ? "Easy" : "Hard";
            String playerName = playerNameField.getText().trim();

            if (playerName.isEmpty()) {
                ErrorHandler.logAndShowWarning("Player name is empty. Cannot proceed.",null);
                Logger.warn("Player name is empty. Cannot proceed.");
                return;
            }

            Logger.info("Difficulty selected: {}, Player Name: {}", difficulty, playerName);

            if (listener != null) {
                listener.onDifficultySelected(difficulty, playerName);
            }
        } catch (Exception e) {
            ErrorHandler.logAndShowError("Error handling start button action in AI Difficulty Controller.",e);
            Logger.error(e, "Error handling start button action in AI Difficulty Controller.");
        }
    }
    /**
     * Sets the listener for handling difficulty and player name selection events.
     *
     * @param listener The {@link DifficultySelectionListener} implementation to handle the events.
     */
    public void setDifficultySelectionListener(DifficultySelectionListener listener) {
        this.listener = listener;
    }
    /**
     * Interface for handling events when the player selects a difficulty level and enters their name.
     */
    public interface DifficultySelectionListener {
        /**
         * Called when the player confirms the difficulty level and their name.
         *
         * @param difficultyLevel The selected AI difficulty level ("Easy" or "Hard").
         * @param playerName      The player's name.
         */
        void onDifficultySelected(String difficultyLevel, String playerName);
    }
}
