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

public class PlayerTest {

    @Test
    public void testGetName() {
        Player player = new Player("John");
        assertEquals("John", player.getName());
    }

    @Test
    public void testGetStore() {
        Player player = new Player();
        Store store = player.getStore();
        assertNotNull(store);
    }

    @Test
    public void testGetStoreCount() {
        Player player = new Player();
        int storeCount = player.getStoreCount();
        assertEquals(0, storeCount);
    }

    @Test
    public void testSetName() {
        Player player = new Player();
        player.setName("Alice");
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testSetStore() {
        Player player = new Player();
        Store store = new Store();
        player.setStore(store);
        assertEquals(store, player.getStore());
    }

    @Test
    public void testToString() {
        Player player = new Player("Bob");
        assertEquals("Bob", player.toString());
    }
}

