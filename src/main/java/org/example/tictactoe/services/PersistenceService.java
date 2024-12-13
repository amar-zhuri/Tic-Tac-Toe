package org.example.tictactoe.services;

import java.util.List;

/**
 * Defines the contract for data persistence operations in the Tic-Tac-Toe application.
 * <p>
 * The `PersistenceService` interface provides methods for saving and loading lists of strings
 * to and from a storage medium. Implementing classes can define specific persistence mechanisms,
 * such as file-based .
 * </p>
 */
public interface PersistenceService {

    /*void saveMap(String fileName, Map<String, Integer> data);

    Map<String, Integer> loadMap(String fileName);*/

    /**
     * Saves a list of strings to a specified storage medium.
     *
     * @param fileName The name of the storage destination (e.g., file or database identifier).
     * @param data     The list of strings to be saved.
     */
    void saveList(String fileName, List<String> data);

    /**
     * Loads a list of strings from a specified storage medium.
     * <p>
     * If the storage medium is unavailable or an error occurs, an empty list is returned.
     * </p>
     *
     * @param fileName The name of the storage source (e.g., file or database identifier).
     * @return The list of strings loaded from the storage medium, or an empty list if the source is unavailable or an error occurs.
     */
    List<String> loadList(String fileName);
}
