package mancala;

public class Pit {
    private int stoneCount;

    public Pit() {
        stoneCount = 0;
    }

    public int getStoneCount() {
        return stoneCount;
    }


    public void addStones(int count) {
        stoneCount = stoneCount + count;
    }

    
    public void addStone() {
        addStones(1);
    }

    
    public int removeStones() {
        int removedStones = stoneCount;
        stoneCount = 0;
        return removedStones;
    }



    public String toString() {
        return "Pit with " + stoneCount + " stone(s)";
    }
}
