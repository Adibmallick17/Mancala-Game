package mancala;

public class Store {
    private Player owner;
    private int totalStones;

    public Store(Player owner) {
        this.owner = owner;
        this.totalStones = 0;
    }

    // Adds stones to the store.
    public void addStones(int amount) {
        totalStones += amount;
    }

    // Empties the store and returns the number of stones that were in it.
    public int emptyStore() {
        int stonesInStore = totalStones;
        totalStones = 0;
        return stonesInStore;
    }

    // Gets the owner of the store.
    public Player getOwner() {
        return owner;
    }

    // Gets the total number of stones in the store.
    public int getTotalStones() {
        return totalStones;
    }

    // Sets the owner of the store.
    public void setOwner(Player player) {
        this.owner = player;
    }

    @Override
    public String toString() {
        return "Store of Player: " + owner.getName() + " - Total Stones: " + totalStones;
    }
}
