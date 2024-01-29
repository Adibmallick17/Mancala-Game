/**
 * These test cases are intended to ensure that the correct API has been implemented for the classes under test.
 * They do not provide exhaustive coverage and thorough testing of all possible scenarios.
 * Additional test cases should be added to cover  edge cases and behaviors.
 */
import mancala.Pit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PitTest {

    @Test
    public void testGetStoneCount() {
        Pit pit = new Pit();
        assertEquals(0, pit.getStoneCount());
    }

    @Test
    public void testAddStones() {
        Pit pit = new Pit();
        pit.addStones(3);
        assertEquals(3, pit.getStoneCount());
    }

    @Test
    public void testAddStone() {
        Pit pit = new Pit();
        pit.addStone();
        assertEquals(1, pit.getStoneCount());
    }

    @Test
    public void testRemoveStones() {
        Pit pit = new Pit();
        pit.addStones(5);
        int removed = pit.removeStones();
        assertEquals(5, removed);
        assertEquals(0, pit.getStoneCount());
    }

    @Test
    public void testToString() {
        Pit pit = new Pit();
        assertEquals("Pit with 0 stone(s)", pit.toString());
    }
}


