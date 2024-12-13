package org.example.tictactoe.models;


/**
 * Represents the game board for Tic-Tac-Toe.
 * <p>
 * This class manages the state of the board, validates moves, checks for winners,
 * and determines if the board is full. It is used as the primary data structure
 * for game state management.
 * </p>
 */
public class Board {

    private static final int SIZE = 3;// The size of the Tic-Tac-Toe board (3x3)
    private final char[][] board;

    /**
     * Constructs a new, empty Tic-Tac-Toe board.
     * <p>
     * All cells are initialized to a space character (' '), representing an empty cell.
     * </p>
     */
    public Board() {
        board = new char[SIZE][SIZE];
        resetBoard();
    }

    /**
     * Attempts to make a move on the board.
     * <p>
     * The move is placed at the specified row and column with the player's symbol,
     * provided the cell is within bounds and currently empty.
     * </p>
     *
     * @param row         The row index (0-based) of the cell.
     * @param col         The column index (0-based) of the cell.
     * @param playerSymbol The symbol of the player making the move (e.g., 'X' or 'O').
     * @return {@code true} if the move was successfully made; {@code false} otherwise.
     */
    public boolean makeMove(int row, int col, char playerSymbol) {
        if (isWithinBounds(row, col) && board[row][col] == ' ') {
            board[row][col] = playerSymbol;
            return true;
        }
        return false;
    }

    /**
     * Checks if the board is full.
     * <p>
     * A full board means that no empty cells (' ') remain, indicating that no further moves
     * can be made.
     * </p>
     *
     * @return {@code true} if the board is full; {@code false} otherwise.
     */
    public boolean isFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') return false;
            }
        }
        return true;
    }

    /**
     * Checks for a winner on the board.
     * <p>
     * A winner is determined if any row, column, or diagonal contains the same non-empty symbol.
     * </p>
     *
     * @return The winning player's symbol ('X' or 'O') if there is a winner; otherwise, a space character (' ').
     */
    public char checkWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (checkRow(i) || checkColumn(i)) return board[i][i];
        }
        return checkDiagonals();
    }

    /**
     * Returns the current state of the board.
     * <p>
     * The board is represented as a 2D character array where each cell contains
     * either 'X', 'O', or a space character (' ').
     * </p>
     *
     * @return A 2D character array representing the board state.
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Resets the board to its initial state.
     * <p>
     * All cells are set to a space character (' ').
     * </p>
     */
    private void resetBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }
    /**
     * Checks if the specified cell coordinates are within the bounds of the board.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     * @return {@code true} if the coordinates are valid; {@code false} otherwise.
     */
    private boolean isWithinBounds(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    /**
     * Checks if all cells in the specified row contain the same non-empty symbol.
     *
     * @param row The row index (0-based) to check.
     * @return {@code true} if the row contains a winning combination; {@code false} otherwise.
     */
    private boolean checkRow(int row) {
        return board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2];
    }

    /**
     * Checks if all cells in the specified column contain the same non-empty symbol.
     *
     * @param col The column index (0-based) to check.
     * @return {@code true} if the column contains a winning combination; {@code false} otherwise.
     */
    private boolean checkColumn(int col) {
        return board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col];
    }

    /**
     * Checks if any diagonal contains the same non-empty symbol.
     *
     * @return The winning player's symbol ('X' or 'O') if a diagonal contains a winning combination; otherwise, a space character (' ').
     */
    private char checkDiagonals() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[0][0];
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[0][2];
        return ' ';
    }
}
