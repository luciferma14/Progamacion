import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int moves = 0;

        while (true) {
            printBoard(board);
            playerMove(board);
            moves++;

            if (checkWin(board, 'X')) {
                printBoard(board);
                System.out.println("¡Has ganado! ¡Felicidades!");
                break;
            }

            if (moves == 9) {
                printBoard(board);
                System.out.println("¡Empate!");
                break;
            }

            printBoard(board);
            computerMove(board);
            moves++;

            if (checkWin(board, 'O')) {
                printBoard(board);
                System.out.println("La computadora ha ganado.");
                break;
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -+-+-");
            }
        }
        System.out.println();
    }

    public static void playerMove(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Ingresa la fila (1-3) y la columna (1-3) para tu movimiento: ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

        board[row][col] = 'X';
    }

    public static void computerMove(char[][] board) {
        int row, col;
        do {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
        } while (board[row][col] != ' ');

        board[row][col] = 'O';
    }

    public static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true; // Verificar filas
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true; // Verificar columnas
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true; // Verificar diagonal principal
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true; // Verificar diagonal secundaria
        }
        return false;
    }
}
