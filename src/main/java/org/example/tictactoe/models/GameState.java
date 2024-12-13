package org.example.tictactoe.models;

import org.tinylog.Logger;

import java.util.function.Consumer;

/**
 * Represents the state and logic of a Tic-Tac-Toe game.
 * <p>
 * The `GameState` class manages the game board, players, turn switching,
 * and determining the game's outcome. It supports both Player vs Player
 * and Player vs AI modes.
 * </p>
 */
public class GameState {

    private final Board board;
    private final Player player1;
    private final Player player2;
    private final AIPlayer aiPlayer;
    private Player currentPlayer;
    private final boolean isAgainstAI;

   /* private final Stats stats = Stats.getInstance(); // For recording game results
    private final Leaderboard leaderboard = Leaderboard.getInstance(); // For recording wins
*/
    private Consumer<char[][]> onBoardUpdate;
    private Consumer<String> onStatusUpdate;
    private Consumer<String> onGameOver;


    /**
     * Constructs a new `GameState` instance.
     *
     * @param isAI        Whether the game is against an AI player.
     * @param aiDifficulty The difficulty level of the AI player ("Easy" or "Hard").
     * @param player1Name The name of Player 1.
     * @param player2Name The name of Player 2 (or "AI" if playing against AI).
     */
    public GameState(boolean isAI, String aiDifficulty, String player1Name, String player2Name) {
        Logger.info("Creating new game state: isAI={}, aiDifficulty={}, player1={}, player2={}",
                isAI, aiDifficulty, player1Name, player2Name);
        board = new Board();
        this.isAgainstAI = isAI;

        player1 = new Player('X', player1Name);
        if (isAI) {
            aiPlayer = new AIPlayer('O', 'X', aiDifficulty);
            player2 = null;
        } else {
            player2 = new Player('O', player2Name);
            aiPlayer = null;
        }
        currentPlayer = player1;
        notifyStatusUpdate();
    }

    /**
     * Handles a player's move at the specified position on the board.
     *
     * @param row The row index of the move (0-based).
     * @param col The column index of the move (0-based).
     */
    public void makeMove(int row, int col) {
        Logger.info("Player {} attempting move at Row {}, Column {}.", currentPlayer.getName(), row, col);
        if (board.makeMove(row, col, currentPlayer.getSymbol())) {
            Logger.info("Move successful.");
            notifyBoardUpdate();
            if (checkGameOver()) {
                Logger.info("Game over detected.");
                return;
            }
                switchTurn();
        } else {
            Logger.warn("Invalid move attempt at Row {}, Column {}.", row, col);
        }
    }

    private boolean gameOverTriggered = false; // Flag to prevent multiple triggers


    /**
     * Checks if the game is over and determines the outcome (win or draw).
     *
     * @return `true` if the game is over, `false` otherwise.
     */
    private boolean checkGameOver() {
        if (gameOverTriggered) return true; // If already triggered, return immediately

        char winner = board.checkWinner();
        if (winner != ' ') {
            Logger.info("Winner determined: {}", (winner == player1.getSymbol()) ? player1.getName() : (isAgainstAI ? "AI" : player2.getName()));
            gameOverTriggered = true;

            String winnerName;
            if (winner == player1.getSymbol()) {
                winnerName = player1.getName();
            } else if (isAgainstAI) {
                winnerName = "AI";
            } else {
                winnerName = player2.getName();
            }

            if (onGameOver != null) {
                onGameOver.accept(winnerName + " wins!");
            }
            return true;
        }

        if (board.isFull()) {
            Logger.info("Board is full. Game ended in a draw.");
            gameOverTriggered = true;
            if (onGameOver != null) {
                onGameOver.accept("It's a draw!");
            }
            return true;
        }

        return false;
    }


    /**
     * Switches turns between the players.
     * <p>
     * If playing against AI, the AI makes its move automatically.
     * </p>
     */
    private void switchTurn() {
        if (isAgainstAI && currentPlayer == player1) {
            int[] aiMove = aiPlayer.getBestMove(board);
            board.makeMove(aiMove[0], aiMove[1], aiPlayer.getSymbol());
            notifyBoardUpdate();
            if (checkGameOver()) return;
        }
        currentPlayer = (currentPlayer == player1) ? (isAgainstAI ? player1 : player2) : player1;
        notifyStatusUpdate();
    }

    /**
     * Sets the callback for board updates.
     *
     * @param onBoardUpdate A consumer that accepts the updated board state.
     */
    public void setOnBoardUpdate(Consumer<char[][]> onBoardUpdate) {
        this.onBoardUpdate = onBoardUpdate;
    }

    /**
     * Sets the callback for status updates.
     *
     * @param onStatusUpdate A consumer that accepts the updated status string.
     */
    public void setOnStatusUpdate(Consumer<String> onStatusUpdate) {
        this.onStatusUpdate = onStatusUpdate;
    }
    /**
     * Sets the callback for when the game is over.
     *
     * @param onGameOver A consumer that accepts the game-over message.
     */
    public void setOnGameOver(Consumer<String> onGameOver) {
        this.onGameOver = onGameOver;
    }

    /**
     * Notifies listeners about the updated board state.
     */
    private void notifyBoardUpdate() {
        if (onBoardUpdate != null) {
            onBoardUpdate.accept(board.getBoard());
        }
    }
    /**
     * Notifies listeners about the updated game status.
     */
    private void notifyStatusUpdate() {
        if (onStatusUpdate != null) {
            onStatusUpdate.accept(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");
        }

    }}