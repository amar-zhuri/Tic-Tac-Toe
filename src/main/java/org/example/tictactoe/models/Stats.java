package org.example.tictactoe.models;

import org.example.tictactoe.services.FilePersistenceService;
import org.example.tictactoe.services.PersistenceService;
import org.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages the storage and retrieval of game statistics for the Tic-Tac-Toe application.
 * <p>
 * The `Stats` class tracks game results and provides methods to persist and retrieve them.
 * It is implemented as a singleton to ensure consistent access across the application.
 * </p>
 */
public class Stats {

    private static Stats instance;

    private final List<String> gameResults = new ArrayList<>(); // List to store all results
    private final PersistenceService persistenceService;


    /**
     * Private constructor to initialize the `Stats` instance and load saved game results.
     */
    private Stats() {
        Logger.info("Initializing Stats.");
        this.persistenceService = new FilePersistenceService();
        loadResults(); // Load previous results on initialization
    }


    /**
     * Provides the singleton instance of the `Stats` class.
     *
     * @return The single instance of `Stats`.
     */
    public static Stats getInstance() {
        if (instance == null) {
            instance = new Stats();
        }
        return instance;
    }

    /**
     * Adds a new game result to the statistics and persists it to storage.
     *
     * @param result A string representing the game result (e.g., "Player1 wins!" or "It's a draw!").
     */
    public void addGameResult(String result) {
        Logger.info("Adding game result: {}", result);
        gameResults.add(result); // Append the new result to the list
        saveResults(); // Save the updated list to file
    }


    /**
     * Retrieves the list of all recorded game results.
     *
     * @return A list of strings representing game results.
     */
    public List<String> getGameResults() {
        Logger.debug("Fetching game results.");
        return new ArrayList<>(gameResults); // Return a copy of the list
    }

    /**
     * Saves the current list of game results to a persistent storage file.
     */
    private void saveResults() {
        Logger.info("Saving game results to file.");
        persistenceService.saveList("game_results.txt", gameResults);
        Logger.info("Game results saved successfully.");
    }

    /**
     * Loads previously recorded game results from the persistent storage file.
     */
    private void loadResults() {
        Logger.info("Loading game results from file.");
        gameResults.clear();
        gameResults.addAll(persistenceService.loadList("game_results.txt"));
        Logger.info("Loaded game results: {}", gameResults);
    }
}
