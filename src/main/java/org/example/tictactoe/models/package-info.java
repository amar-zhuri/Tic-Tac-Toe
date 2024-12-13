/**
 * Contains the core domain models for the Tic-Tac-Toe application.
 * <p>
 * The `models` package encapsulates the application's business logic, including representations
 * of the game state, players, AI strategies, and supporting data structures like the game board
 * and leaderboard. These classes are designed to be reusable, maintainable, and independent
 * of the user interface.
 * </p>
 *
 * <h2>Key Classes:</h2>
 * <ul>
 *     <li><strong>{@link org.example.tictactoe.models.Board}:</strong>
 *         Represents the game board and provides methods for validating moves, checking winners, and resetting the board.</li>
 *     <li><strong>{@link org.example.tictactoe.models.GameState}:</strong>
 *         Manages the state of the game, including the current player, board state, and game logic.</li>
 *     <li><strong>{@link org.example.tictactoe.models.Player}:</strong>
 *         Represents a player, including their name and assigned symbol (X or O).</li>
 *     <li><strong>{@link org.example.tictactoe.models.AIPlayer}:</strong>
 *         Represents the AI player and integrates with difficulty strategies to determine moves.</li>
 *     <li><strong>{@link org.example.tictactoe.models.Leaderboard}:</strong>
 *         Maintains and persists player win counts for the leaderboard.</li>
 *     <li><strong>{@link org.example.tictactoe.models.Stats}:</strong>
 *         Tracks game results and provides methods for persisting and retrieving them.</li>
 *     <li><strong>{@link org.example.tictactoe.models.AIDifficultyStrategy}:</strong>
 *         Interface defining the contract for AI move strategies.</li>
 *     <li><strong>{@link org.example.tictactoe.models.EasyStrategy}:</strong>
 *         Implements a basic AI strategy that selects random moves.</li>
 *     <li><strong>{@link org.example.tictactoe.models.HardStrategy}:</strong>
 *         Implements a more advanced AI strategy using minimax algorithm.</li>
 * </ul>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Encapsulate game logic and rules.</li>
 *     <li>Provide a clear separation between data and behavior through well-defined classes.</li>
 *     <li>Support the application's core functionality, such as player moves, AI decision-making, and game state transitions.</li>
 * </ul>
 *
 * <h2>Design Principles:</h2>
 * <p>
 * The models adhere to object-oriented principles:
 * </p>
 * <ul>
 *     <li><strong>Encapsulation:</strong> Game logic is encapsulated within classes, ensuring independence from the UI.</li>
 *     <li><strong>Single Responsibility Principle:</strong> Each class is responsible for a single aspect of the game's logic.</li>
 *     <li><strong>Strategy Pattern:</strong> AI difficulty levels are implemented as interchangeable strategies.</li>
 * </ul>
 *
 * <h2>Persistence:</h2>
 * <p>
 * Classes like {@link org.example.tictactoe.models.Leaderboard} and {@link org.example.tictactoe.models.Stats}
 * include mechanisms for persisting and retrieving data using services from the `services` package.
 * </p>
 *
 * <h2>Logging:</h2>
 * <p>
 * Logging is integrated into key operations, such as game state transitions, leaderboard updates, and AI decisions,
 * to facilitate debugging and provide transparency.
 * </p>
 */
package org.example.tictactoe.models;
