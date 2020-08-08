package com.pairing;

import com.paring.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game = new Game();

    @Test
    public void validateWhenCodeMatchesWithGuessedCode() {
        game.masterMind(new String[]{"Red", "Green", "Yellow", "Blue"});
        assertEquals(4, game.getRightPositions());
        assertEquals(0, game.getWrongPositions());
    }

    @Test
    public void validateWhenCodeDoesntMatchesWithGuessedCode() {
        game.masterMind(new String[]{"Blue", "Yellow", "Green", "Red"});
        assertEquals(0, game.getRightPositions());
        assertEquals(4, game.getWrongPositions());
    }

    @Test
    public void validateWhenCodePartiallyMatchesWithGuessedCode() {
        game.masterMind(new String[]{"Red", "Green", "Blue", "Yellow"});
        assertEquals(2, game.getRightPositions());
        assertEquals(2, game.getWrongPositions());
    }

    @Test
    public void validateWhenOneoftheCodeMatchesWithGuessedCode() {
        game.masterMind(new String[]{"Red", "Orange", "White", "Pink"});
        assertEquals(1, game.getRightPositions());
        assertEquals(0, game.getWrongPositions());
    }
}
