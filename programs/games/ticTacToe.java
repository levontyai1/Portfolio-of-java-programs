package programs.games;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        drawBoard(board);

        boolean isPlayer1 = true;
        char symbol;
        int row, col;

        Res:while (true) {

            if (isPlayer1) {
                System.out.println("Player 1's turn");
                symbol = 'X';
            } else {
                System.out.println("Player 2's turn");
                symbol = 'O';
            }

            try {
                System.out.print("Enter a row (0,1 or 2): ");
                row = in.nextInt();
                System.out.print("Enter a col (0,1 or 2): ");
                col = in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You did not enter a number");
                continue;
            }

            if (row < 0 || row > 3 || col < 0 || col > 3) {
                System.out.println("Invalid row or col");
                continue;
            } else if (board[row][col] != '-') {
                System.out.println("Cell is tightened");
                continue;
            } else {
                board[row][col] = symbol;
                drawBoard(board);
                isPlayer1 = !isPlayer1;
            }

            if (hasWin(board)) {
                if (!isPlayer1) {
                    System.out.println("Player 1's win!");
                } else {
                    System.out.println("Player 2's win!");
                }
            } else if (ifFullBoard(board)) {
                System.out.println("It's a tie!");
            } else continue;

            while (true) {
                System.out.print("Repeat it?(Yes or No): ");
                String result = in.next();
                if (result.equalsIgnoreCase("Yes")) {
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            board[i][j] = '-';
                        }
                    }
                    continue Res;
                } else if (result.equalsIgnoreCase("No")) {
                    return;
                } else System.out.println("Error");
            }
        }
    }

    private static boolean ifFullBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                return true;
            }
        }
        return board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-'
                || board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-';
    }

    private static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
