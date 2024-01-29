package ui;

import mancala.Board;
import mancala.InvalidMoveException;
import mancala.Pit;
import mancala.Player;
import mancala.Store;
import mancala.MancalaGame;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private MancalaGame game;
    private Scanner scanner;

    public TextUI() {
        game = new MancalaGame();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Welcome to Mancala!");
        System.out.print("Player 1 name: ");
        String playerOneName = scanner.nextLine();
        Player playerOne = new Player(playerOneName);
        System.out.print("Player 2 name: ");
        String playerTwoName = scanner.nextLine();
        Player playerTwo = new Player(playerTwoName);
        game.setPlayers(playerOne, playerTwo);
        game.startNewGame();

        while (!game.isGameOver()) {
            System.out.println("\nCurrent board:");
            printBoard();

            Player currentPlayer = game.getCurrentPlayer();
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            System.out.print("Enter the pit number to move from (1-6 for " + currentPlayer.getName() + "): ");

            int startPit;
            try {
                startPit = Integer.parseInt(scanner.nextLine());
                int stonesMoved = game.move(startPit);
                System.out.println(currentPlayer.getName() + " moved " + stonesMoved + " stones.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException | InvalidMoveException e) {
                System.out.println("Invalid move. " + e.getMessage());
            }
        }

        System.out.println("\nGame Over!");
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

        System.out.println("\n[" + stores.get(1).getTotalStones() + "] --- --- --- --- --- --- [" + stores.get(0).getTotalStones() + "]");

        System.out.print("   ");
        for (int k = 1; k <= 6; k++) {
            System.out.print(pits.get(k - 1).getStoneCount() + " ");
        }

        System.out.println("\nPlayer One's Store");
    }

    public static void main(String[] args) {
        TextUI textUI = new TextUI();
        textUI.startGame();
    }
}
