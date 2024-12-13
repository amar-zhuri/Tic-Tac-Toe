package org.example.tictactoe.services;

import org.tinylog.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides file-based persistence for storing and retrieving game statistics.
 * <p>
 * The `StatsPersistenceService` class manages reading and writing player statistics to
 * a text file. It supports storing player names and their associated win counts.
 * </p>
 */
public class StatsPersistenceService {

    private final String fileName;
    /**
     * Constructs a new `StatsPersistenceService` instance with the specified file name.
     *
     * @param fileName The name of the file used for storing player statistics.
     */
    public StatsPersistenceService(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Loads player statistics from the specified file.
     * <p>
     * If the file does not exist or an error occurs during reading, an empty map is returned.
     * </p>
     *
     * @return A map containing player names as keys and their win counts as values.
     */
    public Map<String, Integer> loadStats() {
        Logger.info("Attempting to load stats from file: {}", fileName);
        Map<String, Integer> data = new HashMap<>();
        File file = new File(fileName);
        if (!file.exists()) {
            Logger.warn("Stats file does not exist: {}", fileName);
            return data;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    data.put(parts[0], Integer.parseInt(parts[1]));
                }
            }
            Logger.info("Successfully loaded stats from file: {}", fileName);
        } catch (IOException e) {
            Logger.error(e, "Error reading from stats file: {}", fileName);
        }
        return data;
    }

    /**
     * Saves player statistics to the specified file.
     *
     * @param data A map containing player names as keys and their win counts as values.
     */
    public void saveStats(Map<String, Integer> data) {
        Logger.info("Saving stats to file: {}", fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
            Logger.info("Stats successfully saved to file: {}", fileName);
        } catch (IOException e) {
            Logger.error(e, "Error writing stats to file: {}", fileName);
        }
    }
}
