package mancala;

import java.util.ArrayList;

public class MancalaGame {
    private Board board;
    private Player currentPlayer;
    private Player playerOne;
    private Player playerTwo;

    public MancalaGame() {
        board = new Board();
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
        board.registerPlayers(playerOne, playerTwo);
        currentPlayer = playerOne;
        startNewGame();
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getNumStones(int pitNum) {
        return board.getNumStones(pitNum);
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        return players;
    }

    public int getStoreCount(Player player) {
        return player.getStore().getTotalStones();
    }

    public Player getWinner() throws GameNotOverException {
        if (!isGameOver()) {
            throw new GameNotOverException();
        }
    
        if (playerOne.getStore().getTotalStones() > playerTwo.getStore().getTotalStones()) {
            return playerOne;
        } else if (playerOne.getStore().getTotalStones() < playerTwo.getStore().getTotalStones()) {
            return playerTwo;
        }
    
        return null;
    }
    

    public boolean isGameOver() {
        for (int k = 1; k <= 6; k++) {
            if (board.getNumStones(k) > 0) {
                return false;
            }
        }
        return true;
    }

    public int move(int startPit) {
        int stones = board.moveStones(startPit, currentPlayer);
        if (stones > 0) {
            if (!board.isSideEmpty(startPit)) {
                currentPlayer.getStore().addStones(stones);
            }
            switchPlayer();
        }
        return stones;
    }

    public void setBoard(Board theBoard) {
        board = theBoard;
    }

    public void setCurrentPlayer(Player player) {
        currentPlayer = player;
    }

    public void setPlayers(Player onePlayer, Player twoPlayer) {
        playerOne = onePlayer;
        playerTwo = twoPlayer;
        board.registerPlayers(playerOne, playerTwo);
        currentPlayer = playerOne;
    }
    

    public void startNewGame() {
        board.resetBoard();
        currentPlayer = playerOne;
    }

    public String toString() {
        return "MancalaGame: " + playerOne.getName() + " vs. " + playerTwo.getName();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == playerOne) ? playerTwo : playerOne;
        
        
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

}
