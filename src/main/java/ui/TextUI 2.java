package ui;

import mancala.Board;
import mancala.InvalidMoveException;
import java.util.ArrayList;
import java.util.Scanner;
import mancala.Pit;
import mancala.Player;
import mancala.Store;
import mancala.MancalaGame;


public class TextUI {
    private MancalaGame game;
    private Scanner scanner;

    public TextUI() {
        game = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Mancala!");
        System.out.print("Player1 name:");
        String playerOneN = scanner.nextLine();
        Player playerOne = new Player(playerOneN);
        System.out.print("Player2 name:");
        String playerTwoN = scanner.nextLine();
        Player playerTwo = new Player(playerTwoN);
        game.setPlayers(playerOne, playerTwo);
        game.startNewGame();

        // Main game loop
        while (!game.isGameOver()) {
            System.out.println("Current board: ");
            printBoard();

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            System.out.print("Enter the pit number to move from (1-6): ");

            int startPit;
            try {
                startPit = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            try {
                // Check if the pit number is valid for the current player
                if ((currentPlayer == playerOne && (startPit < 1 || startPit > 6)) 
                || (currentPlayer == playerTwo && (startPit < 7 || startPit > 12))) {
                    throw new IllegalArgumentException("Invalid pit chosen for the current player.");
                }

            
            int stonesMoved = game.move(startPit);
            System.out.println(currentPlayer.getName() + " moved " + stonesMoved + " stones.");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }catch (InvalidMoveException e) {
                System.out.println("Invalid move. " + e.getMessage());
                continue;
            }

            System.out.println();
        }

        // Game over, print the final results
        System.out.println("Game Over!");
        printBoard();
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void printBoard() {
        Board board = game.getBoard();
        ArrayList<Pit> pits = board.getPits();
        ArrayList<Store> stores = board.getStores();

        System.out.println("Player Two's Store");
        System.out.print("   ");

        for (int j = 12; j > 6; j--) {
            System.out.print(pits.get(j - 1).getStoneCount() + " ");
        }

        System.out.println();
        System.out.print("[");

        System.out.println(stores.get(1).getTotalStones() + "] --- --- --- --- --- --- ["+stores.get(0).getTotalStones()+"]");

        System.out.print("   ");
        
        for (int k = 1; k <= 6; k++) {
            System.out.print(pits.get(k - 1).getStoneCount() + " ");
        }
        
        System.out.println();
        System.out.println("Player One's Store");
        System.out.println();
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}

