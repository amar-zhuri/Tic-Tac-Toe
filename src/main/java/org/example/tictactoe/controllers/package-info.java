/**
 * Provides the controllers for the Tic-Tac-Toe application.
 * <p>
 * The `controllers` package contains classes that handle user interactions,
 * manage UI components, and facilitate communication between the view and model layers.
 * These controllers are responsible for the behavior of individual screens,
 * such as the main menu, game board, AI difficulty selection, and statistics view.
 * </p>
 *
 * <h2>Key Classes:</h2>
 * <ul>
 *     <li><strong>{@link org.example.tictactoe.controllers.MainMenuController}:</strong>
 *         Handles interactions in the main menu, including game mode selection and navigation to other screens.</li>
 *     <li><strong>{@link org.example.tictactoe.controllers.GameController}:</strong>
 *         Manages the game board, processes moves, and updates the game state.</li>
 *     <li><strong>{@link org.example.tictactoe.controllers.AIDifficultyController}:</strong>
 *         Handles AI difficulty selection and player name input for AI games.</li>
 *     <li><strong>{@link org.example.tictactoe.controllers.EnterNamesController}:</strong>
 *         Manages player name input for Player vs Player games.</li>
 *     <li><strong>{@link org.example.tictactoe.controllers.StatsController}:</strong>
 *         Displays game results and leaderboard information.</li>
 * </ul>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Coordinate user interactions with the model layer and update the view layer accordingly.</li>
 *     <li>Handle navigation between different screens within the application.</li>
 *     <li>Provide feedback to users via alerts and status messages.</li>
 *     <li>Implement event-driven behavior for UI components.</li>
 * </ul>
 *
 * <h2>Logging and Error Handling:</h2>
 * <p>
 * Each controller includes logging to track user actions and debug issues. Errors are logged
 * and displayed to the user through appropriate pop-ups to ensure a smooth experience.
 * </p>
 */
package org.example.tictactoe.controllers;
