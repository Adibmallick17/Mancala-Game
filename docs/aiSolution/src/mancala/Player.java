package mancala;

public class Player {
    private String name;
    private Store store;

    public Player(String name) {
        this.name = name;
    }

    // Gets the name of the player.
    public String getName() {
        return name;
    }

    // Gets the player's store where they collect stones.
    public Store getStore() {
        return store;
    }

    // Gets the count of the number of stones in the player's store where they collect stones.
    public int getStoreCount() {
        if (store != null) {
            return store.getStones();
        } else {
            return 0;
        }
    }

    // Sets the player's name.
    public void setName(String name) {
        this.name = name;
    }

    // Sets the player's store.
    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }
}
