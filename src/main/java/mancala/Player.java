package mancala;

public class Player {
    private String name;
    private Store store;

    public Player() {
        name = "Player";
        store = new Store();
    }

    public Player(String pName) {
        this.name = pName;
        store = new Store();
    }

    public String getName() {
        return name;
    }

    public Store getStore() {
        return store;
    }

    public int getStoreCount() {
        return store.getTotalStones();
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public void setStore(Store pStore) {
        this.store = pStore;
    }

    public String toString() {
        return name;
    }
}
