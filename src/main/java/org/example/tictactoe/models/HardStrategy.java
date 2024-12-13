package org.example.tictactoe.models;

/**
 * An advanced AI strategy for Tic-Tac-Toe.
 * <p>
 * The `HardStrategy` uses the Minimax algorithm to calculate the best possible move
 * for the AI player. It evaluates all potential moves and predicts the outcomes to
 * maximize its chances of winning or forcing a draw.
 * </p>
 */
public class HardStrategy implements AIDifficultyStrategy {

    /**
     * Calculates the best move for the AI player using the Minimax algorithm.
     * <p>
     * The method evaluates all valid moves on the board and chooses the one with the
     * highest score based on the Minimax evaluation.
     * </p>
     *
     * @param board       The current state of the game board.
     * @param aiSymbol    The symbol used by the AI player (e.g., 'X' or 'O').
     * @param humanSymbol The symbol used by the human player (e.g., 'X' or 'O').
     * @return An array containing the row and column indices of the best move, e.g., {@code [row, col]}.
     */
    @Override
    public int[] getMove(Board board, char aiSymbol, char humanSymbol) {
        //Logger.info("AI (Hard) is calculating the best move.");
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];
        char[][] gameState = board.getBoard();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameState[row][col] == ' ') {
                    gameState[row][col] = aiSymbol;
                    int score = minimax(board, false, aiSymbol, humanSymbol);
                    gameState[row][col] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{row, col};
                    }
                }
            }
        }
       // Logger.info("AI (Hard) selected move: Row {}, Column {}", bestMove[0], bestMove[1]);
        return bestMove;
    }
    /**
     * Minimax algorithm for evaluating the optimal move.
     * <p>
     * This recursive method simulates all possible moves for both the AI and the human player.
     * It assigns scores to terminal states (win, lose, draw) and propagates those scores back
     * to make an optimal decision.
     * </p>
     *
     * @param board        The current state of the game board.
     * @param isMaximizing Indicates whether the current turn is maximizing (AI) or minimizing (human).
     * @param aiSymbol     The symbol used by the AI player.
     * @param humanSymbol  The symbol used by the human player.
     * @return An integer score representing the outcome of the game state:
     *         <ul>
     *         <li>10 for an AI win</li>
     *         <li>-10 for a human win</li>
     *         <li>0 for a draw</li>
     *         </ul>
     */
    private int minimax(Board board, boolean isMaximizing, char aiSymbol, char humanSymbol) {
        //Logger.debug("Evaluating board state. Maximizing: {}", isMaximizing);
        char winner = board.checkWinner();
        if (winner == aiSymbol) return 10;
        if (winner == humanSymbol) return -10;
        if (board.isFull()) return 0;

        char[][] gameState = board.getBoard();
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameState[row][col] == ' ') {
                    gameState[row][col] = isMaximizing ? aiSymbol : humanSymbol;
                    int score = minimax(board, !isMaximizing, aiSymbol, humanSymbol);
                    gameState[row][col] = ' ';
                    bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
                }
            }
        }
        //Logger.debug("Minimax evaluation completed. Best score: {}", bestScore);
        return bestScore;
    }
}
