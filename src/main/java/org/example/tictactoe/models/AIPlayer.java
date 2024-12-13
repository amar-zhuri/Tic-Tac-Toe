package org.example.tictactoe.models;

import org.example.tictactoe.factories.StrategyFactory;

public class AIPlayer {

    /**
     * Represents an AI player in the Tic-Tac-Toe game.
     * <p>
     * The `AIPlayer` determines its moves based on a chosen difficulty level and the associated
     * strategy. It interacts with the game board and uses a specific implementation
     * of the {@link AIDifficultyStrategy} to select its next move.
     * </p>
     */
    private final char aiSymbol;
    private final char humanSymbol;
    private final AIDifficultyStrategy strategy;


    /**
     * Creates a new AIPlayer with the specified symbols and difficulty level.
     * <p>
     * The difficulty level determines the strategy used by the AI to calculate its moves.
     * </p>
     *
     * @param aiSymbol    The symbol used by the AI player (e.g., 'X' or 'O').
     * @param humanSymbol The symbol used by the human player (e.g., 'X' or 'O').
     * @param difficulty  The difficulty level of the AI (e.g., "Easy", "Hard").
     */
    public AIPlayer(char aiSymbol, char humanSymbol, String difficulty) {
        this.aiSymbol = aiSymbol;
        this.humanSymbol = humanSymbol;
        this.strategy = StrategyFactory.getStrategy(difficulty);
    }

    /**
     * Gets the symbol used by the AI player.
     *
     * @return The AI player's symbol (e.g., 'X' or 'O').
     */
    public char getSymbol() {
        return aiSymbol;
    }
    /**
     * Determines the best move for the AI player based on the current state of the game board.
     * <p>
     * This method delegates the move selection logic to the associated {@link AIDifficultyStrategy}.
     * </p>
     *
     * @param board The current state of the game board.
     * @return An array containing the row and column indices of the selected move, e.g., {@code [row, col]}.
     */
    public int[] getBestMove(Board board) {
        return strategy.getMove(board, aiSymbol, humanSymbol);
    }
}
