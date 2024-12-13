package org.example.tictactoe.models;

/**
 * Represents a player in the Tic-Tac-Toe game.
 * <p>
 * The `Player` class stores information about a player's symbol (X or O) and their name.
 * This class is used to identify players during the game.
 * </p>
 */
public class Player {

    private final char symbol;
    private final String name;

    /**
     * Constructs a new `Player` instance.
     *
     * @param symbol The symbol representing the player ('X' or 'O').
     * @param name   The name of the player.
     */
    public Player(char symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    /**
     * Gets the player's symbol.
     *
     * @return The player's symbol ('X' or 'O').
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Gets the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
}
