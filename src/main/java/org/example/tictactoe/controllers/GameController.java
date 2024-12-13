package org.example.tictactoe.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.tictactoe.models.GameState;
import org.example.tictactoe.models.Leaderboard;
import org.example.tictactoe.models.Stats;
import org.example.tictactoe.utils.ErrorHandler;
import org.tinylog.Logger;

import java.io.IOException;

/**
 * Controller class for the Tic-Tac-Toe game board screen.
 * <p>
 * This class manages the game board where players interact by making moves.
 * It handles updates to the board display, game status, and the end of the game.
 * </p>
 */
public class GameController {

    /**
     * The grid pane representing the game board.
     * Cells in the grid are dynamically created during initialization.
     */
    @FXML
    private GridPane gameGrid;

    /**
     * Label to display the current game status (e.g., whose turn it is or game results).
     */
    @FXML
    private Label statusLabel;

    /**
     * The current game state, managing the game's logic.
     */
    private GameState gameState;
    /**
     * The leaderboard for recording player wins.
     */
    private final Leaderboard leaderboard = Leaderboard.getInstance();

    /**
     * The statistics manager for recording game results.
     */
    private final Stats stats = Stats.getInstance();

    /**
     * Initializes the game with the specified settings.
     * <p>
     * This method sets up the game state, initializes the game grid, and binds
     * listeners to update the UI in response to changes in the game state.
     * </p>
     *
     * @param isAI          Whether the game is Player vs AI or Player vs Player.
     * @param aiDifficulty  The AI difficulty level (if playing against AI).
     * @param player1Name   The name of Player 1.
     * @param player2Name   The name of Player 2 (or "AI" for AI games).
     */
    @FXML
    public void initializeGame(boolean isAI, String aiDifficulty, String player1Name, String player2Name) {
        Logger.info("Initializing game. Mode: {}, Player1: {}, Player2: {}, Difficulty: {}",
                isAI ? "Player vs AI" : "Player vs Player", player1Name, player2Name, aiDifficulty);
        try{
        gameState = new GameState(isAI, aiDifficulty, player1Name, player2Name);
        setupGameGrid();
        bindGameStateListeners();
            Logger.info("Game successfully initialized.");
        }catch (Exception e){
            ErrorHandler.logAndShowError("Error initializing game.",e);
            Logger.error(e, "Error initializing game.");
        }
        }

    /**
     * Sets up the game board grid by dynamically creating buttons for each cell.
     */
    private void setupGameGrid() {
        Logger.info("Setting up game grid.");
        try {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    Button cell = createGridCell(row, col);
                    gameGrid.add(cell, col, row);
                }
            }
            Logger.info("Game grid setup completed.");
        } catch (Exception e) {
            ErrorHandler.logAndShowError("Error setting up game grid.",e);
            Logger.error(e, "Error while setting up game grid.");
        }
    }
    /**
     * Creates a button for a single grid cell and attaches a click handler for making moves.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return A configured {@link Button} representing the grid cell.
     */
    private Button createGridCell(int row, int col) {
        Button cell = new Button();
        cell.setPrefSize(100, 100);
        cell.setStyle("-fx-font-size: 24px;");
        cell.setOnAction(event -> gameState.makeMove(row, col));
        return cell;
    }
    /**
     * Binds listeners to the game state to handle board updates, status changes, and game over events.
     */
    private void bindGameStateListeners() {
        gameState.setOnBoardUpdate(this::updateBoardDisplay);
        gameState.setOnStatusUpdate(this::updateStatusLabel);
        gameState.setOnGameOver(this::handleGameOver);
    }
    /**
     * Updates the board display to reflect the current game state.
     *
     * @param board The 2D character array representing the current game board.
     */
    private void updateBoardDisplay(char[][] board) {
        Logger.debug("Updating game board display.");
        try {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    Button cell = (Button) getNodeFromGridPane(gameGrid, row, col);
                    if (cell != null) {
                        cell.setText(String.valueOf(board[row][col]));
                    }
                }
            }
        } catch (Exception e) {
            ErrorHandler.logAndShowError("Error updating game board display.",e);
            Logger.error(e, "Error updating board display.");
        }
    }
    /**
     * Updates the status label to show the current game's status.
     *
     * @param status The status message to display (e.g., "Player 1's turn").
     */
    private void updateStatusLabel(String status) {
        Logger.debug("Updating status label: {}", status);
        statusLabel.setText(status);
    }

    private boolean gameOverHandled = false; // New flag to prevent duplicate handling

    /**
     * Handles the end of the game by displaying the result and updating stats.
     * <p>
     * This method also disables all buttons on the grid and shows the stats screen.
     * </p>
     *
     * @param message The game over message (e.g., "Player 1 wins!" or "It's a draw!").
     */
    private void handleGameOver(String message) {
        Logger.info("Game over with message: {}", message);
        if (gameOverHandled) return; // Prevent duplicate execution
        gameOverHandled = true;

        if (message.contains("wins!")) {
            String winnerName = message.split(" ")[0]; // Extract winner's name
            stats.addGameResult(winnerName + " wins!"); // Add result to Stats
            leaderboard.recordWin(winnerName); // Record the win in the leaderboard
            Logger.info("Winner detected: {}", message.split(" ")[0]);
        } else if (message.contains("draw")) {
            stats.addGameResult("It's a draw!"); // Add draw result to Stats
            Logger.info("Game ended in a draw.");

        }

        disableAllButtons();
        statusLabel.setText(message);
        showStatsScreen();
    }

    /**
     * Opens the stats screen to display game results and leaderboard data.
     */
    private void showStatsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/views/Stats.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Game Stats");
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException e) {
            ErrorHandler.logAndShowError("Error showing stats screen.",e);
            Logger.error("Error showing stats screen.", e);
        }
    }
    /**
     * Disables all buttons on the grid to prevent further interaction after the game ends.
     */
    private void disableAllButtons() {
        Logger.debug("Disabling all buttons on the grid.");
        for (Node node : gameGrid.getChildren()) {
            if (node instanceof Button) {
                node.setDisable(true);
            }
        }
    }
    /**
     * Retrieves a node (button) from the grid pane at a specific row and column.
     *
     * @param gridPane The {@link GridPane} containing the nodes.
     * @param row      The row index of the node.
     * @param col      The column index of the node.
     * @return The {@link Node} at the specified position, or {@code null} if not found.
     */
    private Node getNodeFromGridPane(GridPane gridPane, int row, int col) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getRowIndex(node) != null && GridPane.getColumnIndex(node) != null) {
                if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == col) {
                    return node;
                }
            }
        }
        return null;
    }
}
