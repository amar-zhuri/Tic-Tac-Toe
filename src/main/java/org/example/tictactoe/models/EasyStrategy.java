package org.example.tictactoe.models;

import org.tinylog.Logger;

import java.util.Random;

/**
 * A simple AI strategy for Tic-Tac-Toe.
 * <p>
 * The `EasyStrategy` selects random valid moves on the board, without considering
 * the state of the game or potential winning/losing positions. It is designed to
 * provide an easy difficulty level for the AI.
 * </p>
 */
public class EasyStrategy implements AIDifficultyStrategy {

    private final Random random = new Random();

    /**
     * Selects a random valid move for the AI player.
     * <p>
     * This method iterates until it finds an empty cell on the board. It does not
     * consider game state or strategy, making it suitable for a beginner-level AI.
     * </p>
     *
     * @param board      The current state of the game board.
     * @param aiSymbol   The symbol used by the AI player (e.g., 'X' or 'O').
     * @param humanSymbol The symbol used by the human player (e.g., 'X' or 'O').
     * @return An array containing the row and column indices of the selected move, e.g., {@code [row, col]}.
     */
    @Override
    public int[] getMove(Board board, char aiSymbol, char humanSymbol) {
        Logger.info("AI (Easy) is selecting a random move.");
        char[][] gameState = board.getBoard();
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (gameState[row][col] != ' ');
        Logger.info("AI (Easy) selected move: Row {}, Column {}", row, col);
        return new int[]{row, col};
    }
}
