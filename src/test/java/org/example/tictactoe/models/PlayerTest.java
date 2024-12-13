package org.example.tictactoe.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void testPlayerInitialization() {
        // Create a new Player instance
        Player player = new Player('X', "Alice");

        // Verify the player's symbol and name
        assertEquals('X', player.getSymbol());
        assertEquals("Alice", player.getName());
    }

    @Test
    void testPlayerWithDifferentSymbolAndName() {
        // Create a new Player instance with different values
        Player player = new Player('O', "Bob");

        // Verify the player's symbol and name
        assertEquals('O', player.getSymbol());
        assertEquals("Bob", player.getName());
    }
}
