package org.example.tictactoe.utils;

import javafx.scene.control.Alert;
import org.tinylog.Logger;
/**
 * A utility class for handling logging and displaying errors and warnings in the Tic-Tac-Toe application.
 * <p>
 * The `ErrorHandler` class provides methods for logging informational messages, warnings, and errors,
 * while optionally displaying warnings and errors as user-friendly pop-up alerts.
 * </p>
 */
public class ErrorHandler {


    /**
     * Logs an informational message using the logger.
     *
     * @param message The informational message to log.
     */
    // Log an informational message
    public static void logInfo(String message) {
        Logger.info(message);
    }
    /**
     * Logs a warning message and displays a pop-up alert to the user.
     *
     * @param message   The warning message to log and display.
     * @param throwable An optional exception associated with the warning. Can be null.
     */
    // Log a warning and show a popup
    public static void logAndShowWarning(String message, Throwable throwable) {
        Logger.warn(throwable, message);
        showPopup("Warning", message, Alert.AlertType.WARNING);
    }
    /**
     * Logs an error message and displays a pop-up alert to the user.
     *
     * @param message   The error message to log and display.
     * @param throwable An optional exception associated with the error. Can be null.
     */
    // Log an error and show a popup
    public static void logAndShowError(String message, Throwable throwable) {
        Logger.error(throwable, message);
        showPopup("Error", message, Alert.AlertType.ERROR);
    }
    /**
     * Displays a pop-up alert with the specified title, message, and alert type.
     * <p>
     * This method is used internally to create and show alert dialogs for warnings and errors.
     * </p>
     *
     * @param title     The title of the alert dialog (e.g., "Warning" or "Error").
     * @param message   The message content of the alert dialog.
     * @param alertType The type of the alert dialog (e.g., {@link Alert.AlertType#WARNING} or {@link Alert.AlertType#ERROR}).
     */
    // Display popup alerts for warnings and errors
    private static void showPopup(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
