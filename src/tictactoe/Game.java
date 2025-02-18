package tictactoe;

import java.util.Scanner;

class Game {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;

        while (!gameOver) {
//            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row [1-3] and column [1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (board.isValidMove(row, col)) {
                currentPlayer.makeMove(board, row, col);
                board.printBoard();

                if (board.checkWin()) {
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    gameOver = true;
                } else if (board.isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    private void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }
}