package org.example.tictactoe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.tictactoe.utils.ErrorHandler;
import org.tinylog.Logger;

/**
 * Controller class for the Player Name Input screen in the Tic-Tac-Toe game.
 * <p>
 * This class manages the user interface where players can:
 * <ul>
 *   <li>Enter names for Player 1 and Player 2.</li>
 *   <li>Start the game with the entered names.</li>
 * </ul>
 * The entered names are passed to a listener for further game initialization.
 * </p>
 */
public class EnterNamesController {
    /**
     * Button to confirm the entered player names and start the game.
     */
    public Button startButton;
    /**
     * Text field for entering the name of Player 1 and Player 2.
     */
    @FXML
    private TextField player1NameField, player2NameField;

    /**
     * Listener to handle the entered player names.
     */
    private NameInputListener nameInputListener;

    /**
     * Initializes the Player Name Input screen.
     * <p>
     * This method is automatically called after the FXML file is loaded.
     * It assigns an action handler to the "Start" button.
     * </p>
     */
    @FXML
    private void initialize() {

        Logger.info("Initializing EnterNamesController.");
        startButton.setOnAction(event -> handleStartButton());
    }
    /**
     * Handles the action of the "Start" button.
     * <p>
     * This method performs the following:
     * <ul>
     *   <li>Validates that names for both players are entered.</li>
     *   <li>Passes the entered names to the listener if valid.</li>
     *   <li>Closes the name input stage after successful validation.</li>
     * </ul>
     * If validation fails, a warning message is logged and shown to the user.
     * </p>
     */
    @FXML
    private void handleStartButton() {
        String player1Name = player1NameField.getText().trim();
        String player2Name = player2NameField.getText().trim();

        if (!player1Name.isEmpty() && !player2Name.isEmpty()) {
            Logger.info("Player names entered: Player1 = {}, Player2 = {}", player1Name, player2Name);
            if (nameInputListener != null) {
                nameInputListener.onNamesEntered(player1Name, player2Name);
            }
            closeStage();
        } else {
            ErrorHandler.logAndShowWarning("Both player names must be entered.",null);
            Logger.warn("Both player names must be entered. Player1 = '{}', Player2 = '{}'", player1Name, player2Name);
        }
    }

    /**
     * Sets the listener for handling entered player names.
     *
     * @param listener The {@link NameInputListener} implementation to handle the events.
     */
    public void setNameInputListener(NameInputListener listener) {
        this.nameInputListener = listener;
    }
    /**
     * Closes the current Player Name Input window.
     */
    private void closeStage() {
        Logger.info("Closing Enter Names window.");
        Stage stage = (Stage) player1NameField.getScene().getWindow();

        stage.close();
    }
    /**
     * Interface for handling events when player names are entered.
     */
    public interface NameInputListener {
        /**
         * Called when the player confirms both names.
         *
         * @param player1Name The name of Player 1.
         * @param player2Name The name of Player 2.
         */
        void onNamesEntered(String player1Name, String player2Name);
    }
}
