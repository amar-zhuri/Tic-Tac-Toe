package org.example.tictactoe.services;

import org.example.tictactoe.utils.FileUtils;
import org.tinylog.Logger;

import java.util.List;

/**
 * Implements file-based persistence for storing and retrieving data.
 * <p>
 * The `FilePersistenceService` class provides methods to save and load lists of strings
 * to and from text files. This implementation uses the `FileUtils` utility class
 * for file operations.
 * </p>
 */
public class FilePersistenceService implements PersistenceService {

    /*@Override
    public void saveMap(String fileName, Map<String, Integer> data) {
        FileUtils.writeToFile(fileName, data);
    }

    @Override
    public Map<String, Integer> loadMap(String fileName) {
        return FileUtils.readFromFile(fileName);
    }*/


    /**
     * Saves a list of strings to a specified file.
     *
     * @param fileName The name of the file where the list will be saved.
     * @param data     The list of strings to be saved.
     */
    @Override
    public void saveList(String fileName, List<String> data) {
        Logger.info("Saving list to file: {}", fileName);
        try {
            FileUtils.writeListToFile(fileName, data);
            Logger.info("List saved successfully to file: {}", fileName);
        } catch (Exception e) {
            Logger.error(e, "Error saving list to file: {}", fileName);
        }
    }

    /**
     * Loads a list of strings from a specified file.
     * <p>
     * If the file does not exist or an error occurs during reading, an empty list is returned.
     * </p>
     *
     * @param fileName The name of the file to load the list from.
     * @return The list of strings loaded from the file, or an empty list if the file does not exist or an error occurs.
     */
    @Override
    public List<String> loadList(String fileName) {
        Logger.info("Loading list from file: {}", fileName);
        try {
            List<String> data = FileUtils.readListFromFile(fileName);
            Logger.info("List loaded successfully from file: {}", fileName);
            return data;
        } catch (Exception e) {
            Logger.error(e, "Error loading list from file: {}", fileName);
            return List.of(); // Return an empty list if an error occurs
        }
    }
}
