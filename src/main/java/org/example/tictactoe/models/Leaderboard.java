package org.example.tictactoe.models;

import org.example.tictactoe.services.StatsPersistenceService;
import org.tinylog.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages the leaderboard for tracking player wins in the Tic-Tac-Toe game.
 * <p>
 * The `Leaderboard` class is implemented as a singleton to ensure a single instance
 * is shared across the application. It handles the storage and retrieval of player
 * win counts and persists data using a file-based system.
 * </p>
 */
public class Leaderboard {

    private static final String LEADERBOARD_FILE = "leaderboard.txt";

    private final Map<String, Integer> wins = new HashMap<>();
    private final StatsPersistenceService persistenceService;
    private static Leaderboard instance;

    /**
     * Private constructor for initializing the leaderboard and loading existing stats.
     */
    private Leaderboard() {
        Logger.info("Initializing Leaderboard.");
        this.persistenceService = new StatsPersistenceService(LEADERBOARD_FILE);
        this.wins.putAll(persistenceService.loadStats());
        Logger.info("Loaded leaderboard data: {}", wins);
    }


    /**
     * Provides the singleton instance of the `Leaderboard` class.
     *
     * @return The single instance of the `Leaderboard`.
     */
    public static synchronized Leaderboard getInstance() {
        if (instance == null) {
            instance = new Leaderboard();
        }
        return instance;
    }

    /**
     * Records a win for a specific player.
     * <p>
     * If the player does not already exist in the leaderboard, they are added with a win count of 1.
     * If the player exists, their win count is incremented.
     * </p>
     *
     * @param playerName The name of the player who won.
     */
    public void recordWin(String playerName) {
        Logger.info("Recording win for player: {}", playerName);
        wins.put(playerName, wins.getOrDefault(playerName, 0) + 1);
        Logger.info("Updated leaderboard: {}", wins);
        persistenceService.saveStats(wins);
    }

    /**
     * Retrieves the win counts for all players, sorted in descending order of wins.
     *
     * @return A map containing player names as keys and their respective win counts as values.
     */
    public Map<String, Integer> getWinCounts() {
        Logger.debug("Fetching sorted win counts from leaderboard.");
        return wins.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue()) // Sort descending by wins
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        HashMap::new
                ));
    }
}
