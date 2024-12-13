package org.example.tictactoe.models;/*package org.example.testtictactoe.models;*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Board} class.
 */
public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testMakeMove_Successful() {
        assertTrue(board.makeMove(0, 0, 'X'));
        assertEquals('X', board.getBoard()[0][0]);
    }

    @Test
    void testMakeMove_OutOfBounds() {
        assertFalse(board.makeMove(-1, 0, 'X'));
        assertFalse(board.makeMove(3, 3, 'O'));
    }

    @Test
    void testMakeMove_CellAlreadyOccupied() {
        board.makeMove(1, 1, 'X');
        assertFalse(board.makeMove(1, 1, 'O'));
        assertEquals('X', board.getBoard()[1][1]);
    }

    @Test
    void testIsFull_EmptyBoard() {
        assertFalse(board.isFull());
    }

    @Test
    void testIsFull_PartiallyFilledBoard() {
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'O');
        assertFalse(board.isFull());
    }

    @Test
    void testIsFull_CompletelyFilledBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.makeMove(i, j, (i + j) % 2 == 0 ? 'X' : 'O');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testCheckWinner_RowWin() {
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void testCheckWinner_ColumnWin() {
        board.makeMove(0, 0, 'O');
        board.makeMove(1, 0, 'O');
        board.makeMove(2, 0, 'O');
        assertEquals('O', board.checkWinner());
    }

    @Test
    void testCheckWinner_DiagonalWin_LeftToRight() {
        board.makeMove(0, 0, 'X');
        board.makeMove(1, 1, 'X');
        board.makeMove(2, 2, 'X');
        assertEquals('X', board.checkWinner());
    }

    @Test
    void testCheckWinner_DiagonalWin_RightToLeft() {
        board.makeMove(0, 2, 'O');
        board.makeMove(1, 1, 'O');
        board.makeMove(2, 0, 'O');
        assertEquals('O', board.checkWinner());
    }

    @Test
    void testCheckWinner_NoWinner() {
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'O');
        board.makeMove(1, 1, 'X');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'O');
        assertEquals(' ', board.checkWinner());
    }

    @Test
    void testInitialState() {
        for (char[] row : board.getBoard()) {
            for (char cell : row) {
                assertEquals(' ', cell);
            }
        }
    }
    @Test
    void testResetBoardViaConstructor() {
        board.makeMove(0, 0, 'X'); // Make some changes
        board = new Board(); // Recreate the board, which triggers resetBoard()
        for (char[] row : board.getBoard()) {
            for (char cell : row) {
                assertEquals(' ', cell);
            }
        }
    }


    @Test
    void testGetBoard_NotNull() {
        assertNotNull(board.getBoard());
    }
}
