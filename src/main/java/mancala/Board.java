package mancala;

import java.util.ArrayList;

public class Board {
    private ArrayList<Pit> pits;
    private ArrayList<Store> stores;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer; 

    public Board() {
        // Initialize a new Mancala board with pits and stores
        pits = new ArrayList<>();
        stores = new ArrayList<>();
        setUpPits();
        setUpStores();
        registerPlayers(null, null);
        initializeBoard();
    
    
    }

    public int captureStones(int stoppingPoint) {
        int stonesCaptured = 0;
        //It checks if the stoppingPoint is a valid index within the pits.
        int startIndex = stoppingPoint - 1;

        //If the stoppingPoint is valid and the pit at that index contains only one stone, it proceeds to capture stones from the opposite pit.
        if (startIndex >= 0 && startIndex < 6 && pits.get(startIndex).getStoneCount() == 1) {
            //The method calculates the index of the opposite pit (using the formula 11 - startIndex) and checks if it's valid.
            int oppositePitIndex = 11 - startIndex;
            stonesCaptured = pits.get(oppositePitIndex).removeStones();
            stonesCaptured = stonesCaptured + pits.get(startIndex).removeStones();
            return stonesCaptured;
        }
        //If conditions are met, it captures stones from both the current pit (startIndex) and the opposite pit and returns the total number of stones captured.

        return stonesCaptured;
    }
    
    //Helper method that distributes stones into pits and stores, skipping the opponent's store
    public int distributeStones(int startingPoint){
        //It retrieves the number of stones from the startingPoint pit.
        int stones = pits.get(startingPoint).removeStones();
        int currentPit = startingPoint-1;

        while (stones > 0) {
            // Move to the next pit in a counterclockwise direction            
            currentPit = (currentPit + 1) % 12;

            //Checks if the current pit is a store corresponding to the opponent. If so, it adds a stone to the opponent's store and decrements stones.
            if (currentPit == 5 && startingPoint < 6) {
                stores.get(0).addStones(1);
                stones--;
            } else if (currentPit == 11 && startingPoint > 6) {
                stores.get(1).addStones(1);
                stones--;
            }

            // Distribute a stone to the current pit
            pits.get(currentPit).addStone();
            stones--;

        }
        
        //If the loop ends with the last stone placed in either player's store, it returns 1.
        if ((currentPit == 5  && startingPoint < 6) || (currentPit == 11 && startingPoint > 6)){
            return 1;
        }


        //It checks if the last stone is placed in an empty pit of the current player. If so, it initiates stone capture by calling the captureStones() method.
        if (pits.get(currentPit).getStoneCount() == 1){
            if (startingPoint < 6 && currentPit < 6) {
                stores.get(0).addStones(captureStones(currentPit));            
            }else if (startingPoint > 6 && currentPit > 6) {
                stores.get(1).addStones(captureStones(currentPit));
            }
        }

        // Return the final pit where the last stone was placed
        return currentPit;

    }

    public int getNumStones(int pitNum) {
        if (pitNum >= 0 && pitNum < 12) {
            return pits.get(pitNum - 1).getStoneCount();
        } else {
            throw new PitNotFoundException();
        }
    }
    
   
    public ArrayList<Pit> getPits() {
        ArrayList<Pit> boardPits = new ArrayList<>(pits.subList(0, 12));
        return boardPits;
    }


    public ArrayList<Store> getStores() {
        ArrayList<Store> boardStores = new ArrayList<>(stores);
        return boardStores;
    }

    public void initializeBoard(){
        for(Pit pit: pits){
            pit.removeStones();
            pit.addStones(4);
        }
         for (Store store : stores) {
            store.emptyStore();
        }
    }

    public boolean isSideEmpty(int pitNum) {
        int startIndex = pitNum - 1;
        int endIndex = (startIndex <= 5) ? 0 : 7;

        for (int j = startIndex; j >= endIndex; j--) {
            if (pits.get(j).getStoneCount() > 0) {
                return false;
            }
        }
        return true;
    }

    //moves stones for the player starting from a specific pit
    int moveStones(int startPit,Player player){
        //startPit--;
        //It checks if the selected pit is within the correct range for the current player. If not, it returns -1.
        if(
            ((player==stores.get(0).getOwner())&&(startPit<0|| startPit >= 6))||((player==stores.get(1).getOwner())
            &&
            (startPit < 6 || startPit >= 12))) {
            return -1;
        }

        // Check if the selected pit is not empty
        if (getNumStones(startPit) == 0) {
            System.out.println("Selected pit is empty. Please choose a pit with stones.");
            return -1;
        }
        //If the pit is valid and has stones, it calls the distributeStones.
        return distributeStones(startPit);

    }
    

    public void registerPlayers(Player one, Player two) {
        if (one != null && two != null) {
            stores.get(0).setOwner(one);
            stores.get(1).setOwner(two);
            playerOne = one; 
            playerTwo = two;
        }
    }


    public void resetBoard() {
        initializeBoard();
    }


    public void setUpPits() {
        for (int k = 0; k < 12; k++) {
            Pit pit = new Pit();
            pits.add(pit);
        }
    }
     

    public void setUpStores() {
        stores.add(new Store());
        stores.add(new Store());
    }


    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Mancala Board\n");

        //The loop iterates through all the pits (index 0 to 11).
        for (int k = 0; k < 12; k++) {
            boardString.append("Pit");
            boardString.append(k + 1).append(":").append(pits.get(k).getStoneCount()).append(" stones\n");
        }
        //adds the total number of stones in the first store.
        boardString.append("Store 1: ").append(stores.get(0).getTotalStones()).append(" stones\n");
        //adds the total number of stones in the second store.
        boardString.append("Store 2: ").append(stores.get(1).getTotalStones()).append(" stones\n");

        return boardString.toString();
    }
}