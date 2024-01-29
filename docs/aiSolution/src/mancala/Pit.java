package mancala;

public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 0;
    }

    // Adds a stone to the pit.
    public void addStone() {
        stoneCount++;
    }

    // Gets the number of stones in the pit.
    public int getStoneCount() {
        return stoneCount;
    }

    // Removes and returns the stones from the pit.
    public int removeStones() {
        int stonesToRemove = stoneCount;
        stoneCount = 0;
        return stonesToRemove;
    }

    @Override
    public String toString() {
        return "Pit with " + stoneCount + " stones.";
    }
}
