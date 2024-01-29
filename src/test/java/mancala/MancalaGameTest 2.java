/**
 * These test cases are intended to ensure that the correct API has been implemented for the classes under test.
 * They do not provide exhaustive coverage and thorough testing of all possible scenarios.
 * Additional test cases should be added to cover  edge cases and behaviors.
 */

import mancala.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MancalaGameTest {

    private MancalaGame game;

    @BeforeEach
    public void setUp() {
        game = new MancalaGame();
    }

    @Test
    public void testGetBoard() {
        assertNotNull(game.getBoard());
    }

    @Test
    public void testGetCurrentPlayer() {
        assertNotNull(game.getCurrentPlayer());
    }

    @Test
    public void testGetNumStones() {
        int stoneCount = game.getNumStones(3); // Assuming pit 3 has stones
        assertEquals(4, stoneCount); // Assuming each pit starts with 4 stones
    }

    @Test
    public void testGetPlayers() {
        assertEquals(2, game.getPlayers().size());
    }

    @Test
    public void testGetStoreCount() {
        int storeCount = game.getStoreCount(game.getPlayerOne());
        assertEquals(0, storeCount); // Assuming the store starts empty
    }

    @Test
    public void testGetWinner() {
        // Implement test cases to check winning scenarios
        assertThrows(GameNotOverException.class, () -> game.getWinner());
    }

    @Test
    public void testIsGameOver() {
        // Assuming initial state of the game is not over
        assertFalse(game.isGameOver());
    }

    @Test
    public void testMove() {
        // Implement test cases to validate moves and their outcomes
        int stonesMoved = game.move(3); // Assuming moving stones from pit 3
        assertTrue(stonesMoved >= 0);
    }

    @Test
    public void testSetBoard() {
        Board newBoard = new Board();
        game.setBoard(newBoard);
        assertEquals(newBoard, game.getBoard());
    }

    @Test
    public void testSetCurrentPlayer() {
        Player newPlayer = new Player("New Player");
        game.setCurrentPlayer(newPlayer);
        assertEquals(newPlayer, game.getCurrentPlayer());
    }

    @Test
    public void testSetPlayers() {
        Player newPlayerOne = new Player("Alice");
        Player newPlayerTwo = new Player("Bob");
        game.setPlayers(newPlayerOne, newPlayerTwo);
        assertEquals(newPlayerOne, game.getPlayerOne());
        assertEquals(newPlayerTwo, game.getPlayerTwo());
    }

    @Test
    public void testStartNewGame() {
        // Assuming after starting a new game, it's not over
        game.startNewGame();
        assertFalse(game.isGameOver());
    }

    @Test
    public void testToString() {
        assertNotNull(game.toString());
    }
}


