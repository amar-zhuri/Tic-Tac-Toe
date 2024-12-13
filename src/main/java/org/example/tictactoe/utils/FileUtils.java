    package org.example.tictactoe.utils;

    import org.tinylog.Logger;

    import java.io.*;
    import java.util.*;
    /**
     * A utility class for performing file operations such as reading and writing data to files.
     * <p>
     * The `FileUtils` class provides static methods for managing file-based persistence
     * of lists of strings. It includes functionality for writing data to a file and reading data from a file.
     * </p>
     */
    public class FileUtils {

        /*public static void writeToFile(String fileName, Map<String, Integer> data) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Map.Entry<String, Integer> entry : data.entrySet()) {
                    writer.write(entry.getKey() + ":" + entry.getValue());
                    writer.newLine();
                }
                Logger.info("File write successful: {}", fileName);
            } catch (IOException e) {
                Logger.error(e, "Failed to write to file: {}", fileName);
            }
        }

        public static Map<String, Integer> readFromFile(String fileName) {
            Map<String, Integer> data = new HashMap<>();
            File file = new File(fileName);
            if (!file.exists()) return data;

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        data.put(parts[0], Integer.parseInt(parts[1]));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
            return data;
        }
*/
        /**
         * Writes a list of strings to a specified file.
         * <p>
         * Each string in the list is written as a separate line in the file. If the file already exists,
         * its content will be overwritten.
         * </p>
         *
         * @param fileName The name of the file where the data will be written.
         * @param data     The list of strings to write to the file.
         */
        public static void writeListToFile(String fileName, List<String> data) {
            Logger.info("Writing list to file: {}", fileName);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (String line : data) {
                    writer.write(line);
                    writer.newLine();
                }
                Logger.info("List write successful: {}", fileName);
            } catch (IOException e) {
                Logger.error(e, "Failed to write list to file: {}", fileName);
            }
        }

        /**
         * Reads a list of strings from a specified file.
         * <p>
         * Each line in the file is read as a separate string and added to the returned list. If the file does not exist,
         * or if an error occurs during reading, an empty list is returned.
         * </p>
         *
         * @param fileName The name of the file to read the data from.
         * @return A list of strings read from the file, or an empty list if the file does not exist or an error occurs.
         */
        public static List<String> readListFromFile(String fileName) {
            Logger.info("Reading list from file: {}", fileName);
            List<String> data = new ArrayList<>();
            File file = new File(fileName);
            if (!file.exists()) {
                Logger.warn("File not found: {}", fileName);
                return data;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    data.add(line);
                }
                Logger.info("List read successful: {}", fileName);
            } catch (IOException e) {
                Logger.error(e, "Error reading list from file: {}", fileName);
            }
            return data;
        }
    }
