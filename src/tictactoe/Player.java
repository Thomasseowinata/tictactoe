package tictactoe;

class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(Board board, int row, int col) {
        if (board.isValidMove(row, col)) {
            board.makeMove(row, col, symbol);
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }
}