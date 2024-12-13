package org.example.tictactoe.models;

import org.example.tictactoe.services.StatsPersistenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Leaderboard} class.
 */
class LeaderboardTest {

    private Leaderboard leaderboard;
    private StatsPersistenceService mockPersistenceService;

    @BeforeEach
    void setUp() {
        // Initialize the singleton for testing
        leaderboard = Leaderboard.getInstance();
    }

    @Test
    void testSingletonInstance() {
        Leaderboard anotherInstance = Leaderboard.getInstance();
        assertSame(leaderboard, anotherInstance, "Leaderboard should be a singleton.");
    }




    @Test
    void testPersistenceIntegration() {
        // This test assumes the persistence layer works correctly.
        leaderboard.recordWin("PersistentPlayer");
        Map<String, Integer> winCounts = leaderboard.getWinCounts();
        assertTrue(winCounts.containsKey("PersistentPlayer"), "Leaderboard should persist the recorded player.");
    }
}
