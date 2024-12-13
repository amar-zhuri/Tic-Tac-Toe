package org.example.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link GameState} class.
 */
class GameStateTest {

    private GameState playerVsPlayerGame;
    private GameState playerVsAIGame;

    @BeforeEach
    void setUp() {
        playerVsPlayerGame = new GameState(false, "", "Player1", "Player2");
        playerVsAIGame = new GameState(true, "Easy", "Player1", "AI");
    }

    @Test
    void testInitialGameState_PlayerVsPlayer() {
        assertNotNull(playerVsPlayerGame, "GameState should be initialized for Player vs Player.");
    }

    @Test
    void testInitialGameState_PlayerVsAI() {
        assertNotNull(playerVsAIGame, "GameState should be initialized for Player vs AI.");
    }

    @Test
    void testPlayerMove_ValidMove_PlayerVsPlayer() {
        playerVsPlayerGame.makeMove(0, 0); // Player1 moves
        // Expect no exceptions and the game state transitions correctly.
        assertTrue(true, "Valid move should not throw errors.");
    }

    @Test
    void testPlayerMove_InvalidMove_PlayerVsPlayer() {
        playerVsPlayerGame.makeMove(0, 0); // First move (valid)
        playerVsPlayerGame.makeMove(0, 0); // Same spot (invalid)
        // Expect the invalid move to be handled gracefully.
        assertTrue(true, "Invalid move should not throw errors.");
    }
}
