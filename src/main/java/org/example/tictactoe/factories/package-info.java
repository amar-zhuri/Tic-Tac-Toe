/**
 * Provides factory classes for creating and managing reusable components in the Tic-Tac-Toe application.
 * <p>
 * The `factories` package contains classes that simplify the creation of complex objects,
 * such as controllers and strategies, used throughout the application. These factories
 * centralize object creation logic to improve maintainability, reusability, and consistency.
 * </p>
 *
 * <h2>Key Classes:</h2>
 * <ul>
 *     <li><strong>{@link org.example.tictactoe.factories.ControllerFactory}:</strong>
 *         Creates and initializes controllers for different UI components, including
 *         screens for AI difficulty selection and player name input.</li>
 *     <li><strong>{@link org.example.tictactoe.factories.StrategyFactory}:</strong>
 *         Manages the creation and registration of AI difficulty strategies, such as Easy and Hard.</li>
 * </ul>
 *
 * <h2>Responsibilities:</h2>
 * <ul>
 *     <li>Encapsulate the instantiation of complex or frequently used objects.</li>
 *     <li>Ensure consistency in the initialization of UI controllers and strategies.</li>
 *     <li>Enable dynamic registration and retrieval of strategies for AI behavior.</li>
 * </ul>
 *
 * <h2>Design Principles:</h2>
 * <p>
 * The factories adhere to key software design principles:
 * </p>
 * <ul>
 *     <li><strong>Factory Method:</strong> Provides methods to create objects without exposing the instantiation logic.</li>
 *     <li><strong>Open/Closed Principle:</strong> Allows for the extension of strategies without modifying existing code.</li>
 *     <li><strong>Encapsulation:</strong> Centralizes object creation logic for better code organization.</li>
 * </ul>
 *
 * <h2>Logging and Error Handling:</h2>
 * <p>
 * The factories use logging to record object creation events and handle potential errors,
 * such as missing FXML files or unregistered strategies, ensuring a robust and debuggable implementation.
 * </p>
 */
package org.example.tictactoe.factories;
