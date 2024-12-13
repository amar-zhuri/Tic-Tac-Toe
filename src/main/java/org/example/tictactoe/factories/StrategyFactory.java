package org.example.tictactoe.factories;

import org.example.tictactoe.models.AIDifficultyStrategy;
import org.example.tictactoe.models.EasyStrategy;
import org.example.tictactoe.models.HardStrategy;

import java.util.HashMap;
import java.util.Map;
import org.tinylog.Logger;

/**
 * Factory class for managing and providing AI difficulty strategies.
 * <p>
 * This class allows the registration and retrieval of AI strategies based
 * on difficulty levels. Default strategies for "Easy" and "Hard" are pre-registered.
 * </p>
 */
public class StrategyFactory {

    /**
     * A map to hold registered strategies with their corresponding difficulty names.
     */
    private static final Map<String, AIDifficultyStrategy> strategies = new HashMap<>();

    // Static block to initialize default strategies
    static {
        Logger.debug("Registering default AI strategies.");
        strategies.put("Easy", new EasyStrategy());
        strategies.put("Hard", new HardStrategy());
        Logger.debug("Default AI strategies registered: {}", strategies.keySet());
    }

    /**
     * Retrieves the AI strategy for the specified difficulty level.
     * <p>
     * If no strategy is registered for the given difficulty, the "Easy" strategy
     * is returned as the default.
     * </p>
     *
     * @param difficulty The difficulty level (e.g., "Easy", "Hard").
     * @return The {@link AIDifficultyStrategy} corresponding to the specified difficulty.
     */
    public static AIDifficultyStrategy getStrategy(String difficulty) {
        return strategies.getOrDefault(difficulty, new EasyStrategy()); // Default to Easy
    }

    /**
     * Registers a new AI strategy for a specific difficulty level.
     * <p>
     * Allows dynamically adding new strategies at runtime, enabling flexibility
     * for future extensions.
     * </p>
     *
     * @param name     The name of the difficulty level (e.g., "Custom").
     * @param strategy The {@link AIDifficultyStrategy} implementation to associate with the difficulty.
     */
    public static void registerStrategy(String name, AIDifficultyStrategy strategy) {
        strategies.put(name, strategy);
    }
}
