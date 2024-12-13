package org.example.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AIPlayerTest {

    private AIPlayer aiPlayer;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(); // Initialize a new board for testing
    }

    @Test
    void testAIPlayerInitialization() {
        aiPlayer = new AIPlayer('X', 'O', "Easy");
        assertEquals('X', aiPlayer.getSymbol());
    }

    @Test
    void testGetBestMove_EasyStrategy() {
        aiPlayer = new AIPlayer('X', 'O', "Easy");

        // Fill the board partially to simulate a real game state
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'X');

        // Get the AI's best move and assert that it provides a valid move
        int[] move = aiPlayer.getBestMove(board);
        char[][] boardState = board.getBoard();

        // Check that the selected move is valid (empty cell)
        assertEquals(' ', boardState[move[0]][move[1]]);
    }

    @Test
    void testGetBestMove_HardStrategy() {
        aiPlayer = new AIPlayer('O', 'X', "Hard");

        // Fill the board partially to simulate a real game state
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 2, 'X');

        // Get the AI's best move and assert that it provides a valid move
        int[] move = aiPlayer.getBestMove(board);
        char[][] boardState = board.getBoard();

        // Check that the selected move is valid (empty cell)
        assertEquals(' ', boardState[move[0]][move[1]]);
    }

    @Test
    void testGetBestMove_OnEmptyBoard() {
        aiPlayer = new AIPlayer('X', 'O', "Easy");

        // Get the AI's best move on an empty board
        int[] move = aiPlayer.getBestMove(board);
        char[][] boardState = board.getBoard();

        // Check that the selected move is valid (empty cell)
        assertEquals(' ', boardState[move[0]][move[1]]);
    }
}