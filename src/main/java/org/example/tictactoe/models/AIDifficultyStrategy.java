package org.example.tictactoe.models;

/**
 * Represents a strategy for determining AI moves in a Tic-Tac-Toe game.
 * <p>
 * Implementations of this interface define how the AI selects its moves based
 * on the difficulty level or specific strategy.
 * </p>
 */
public interface AIDifficultyStrategy {
    /**
     * Determines the next move for the AI player based on the current state of the game board.
     * <p>
     * The implementation defines the logic for selecting the move, which can vary
     * depending on the difficulty level or other factors.
     * </p>
     *
     * @param board       The current state of the game board.
     * @param aiSymbol    The symbol representing the AI player (e.g., 'X' or 'O').
     * @param humanSymbol The symbol representing the human player (e.g., 'X' or 'O').
     * @return An array containing the row and column indices of the selected move, e.g., {@code [row, col]}.
     */
    int[] getMove(Board board, char aiSymbol, char humanSymbol);
}
