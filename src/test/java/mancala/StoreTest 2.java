/**
 * These test cases are intended to ensure that the correct API has been implemented for the classes under test.
 * They do not provide exhaustive coverage and thorough testing of all possible scenarios.
 * Additional test cases should be added to cover  edge cases and behaviors.
 */
import mancala.Player;
import mancala.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StoreTest {

    @Test
    public void testAddStones() {
        Store store = new Store();
        store.addStones(5);
        assertEquals(5, store.getTotalStones());
    }

    @Test
    public void testEmptyStore() {
        Store store = new Store();
        store.addStones(10);
        int stonesRemoved = store.emptyStore();
        assertEquals(10, stonesRemoved);
        assertEquals(0, store.getTotalStones());
    }

    @Test
    public void testGetOwner() {
        Store store = new Store();
        Player player = new Player();
        store.setOwner(player);
        assertEquals(player, store.getOwner());
    }

    @Test
    public void testGetTotalStones() {
        Store store = new Store();
        assertEquals(0, store.getTotalStones());
    }

    @Test
    public void testSetOwner() {
        Store store = new Store();
        Player player = new Player();
        store.setOwner(player);
        assertEquals(player, store.getOwner());
    }

    @Test
    public void testToString() {
        Store store = new Store();
        store.addStones(8);
        assertEquals("Store with 8 stone(s)", store.toString());
    }
}

