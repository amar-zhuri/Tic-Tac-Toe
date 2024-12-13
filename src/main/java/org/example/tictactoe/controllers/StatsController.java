package org.example.tictactoe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.example.tictactoe.models.Stats;
import org.example.tictactoe.models.Leaderboard;
import org.example.tictactoe.utils.ErrorHandler;
import org.tinylog.Logger;



/**
 * Controller class for the Stats screen in the Tic-Tac-Toe application.
 * <p>
 * This class is responsible for displaying the game results and leaderboard data
 * to the user. It also provides a close button to exit the stats screen.
 * </p>
 */
public class StatsController {

    /**
     * Singleton instance of the leaderboard, which holds win counts for players.
     */
    Leaderboard leaderboard = Leaderboard.getInstance();

    /**
     * ListView for displaying the game results.
     */
    @FXML
    private ListView<String> resultsListView;

    /**
     * ListView for displaying the leaderboard (player names and win counts).
     */
    @FXML
    private ListView<String> leaderboardListView;

    /**
     * Button to close the stats screen.
     */
    @FXML
    private Button closeButton;
    /**
     * Singleton instance of the stats model, which holds the list of game results.
     */
    private final Stats stats = Stats.getInstance();

    /**
     * Initializes the StatsController.
     * <p>
     * Populates the game results and leaderboard, and sets up the close button action.
     * Logs and handles any exceptions during initialization.
     * </p>
     */
    @FXML
    public void initialize() {
        try {
            updateResults();
            updateLeaderboard();
            closeButton.setOnAction(actionEvent -> handleCloseButton());
        }catch (Exception e) {
            ErrorHandler.logAndShowError("Error initializing StatsController", e);
        }

    }

    /**
     * Handles the action for closing the stats screen.
     * <p>
     * Closes the current stage when the Close button is clicked.
     * </p>
     */
    @FXML
    private void handleCloseButton() {
        // Close the stats window
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Updates the game results ListView.
     * <p>
     * Fetches the list of game results from the Stats model and displays them
     * in the `resultsListView`. Logs any exceptions that occur during the update.
     * </p>
     */
    private void updateResults() {
        try {
            resultsListView.getItems().clear();
            resultsListView.getItems().addAll(stats.getGameResults());
        }catch (Exception e) {
            Logger.debug("Error updating results", e);
        }

    }


    /**
     * Updates the leaderboard ListView.
     * <p>
     * Fetches the leaderboard data (player names and win counts) from the Leaderboard model
     * and displays them in the `leaderboardListView`. Logs any exceptions that occur during the update.
     * </p>
     */
    private void updateLeaderboard() {
        try {
            leaderboardListView.getItems().clear();
            leaderboard.getWinCounts().forEach((player, wins) ->
                    leaderboardListView.getItems().add(player + ": " + wins + " wins"));
        }catch (Exception e) {
            Logger.debug("Error updating leaderboard", e);
        }
        }


}
