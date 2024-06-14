import java.util.Scanner;
import java.util.Random;

public class TresEnRaya {
    public static void main(String[] args) {
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        int movimientos = 0;
        boolean jugadorGano = false;
        boolean ordenadorGano = false;
        
        while (movimientos < 9 && !jugadorGano && !ordenadorGano) {
            dibujarTablero(tablero);
            
            if (movimientos % 2 == 0) {
                // Turno del jugador
                jugarTurnoJugador(tablero);
                jugadorGano = verificarGanador(tablero, 'X');
            } else {
                // Turno del ordenador
                jugarTurnoOrdenador(tablero);
                ordenadorGano = verificarGanador(tablero, 'O');
            }
            
            movimientos++;
        }
        
        dibujarTablero(tablero);
        
        if (jugadorGano) {
            System.out.println("¡El jugador gana!");
        } else if (ordenadorGano) {
            System.out.println("¡El ordenador gana!");
        } else {
            System.out.println("¡Es un empate!");
        }
    }
    
    public static void dibujarTablero(char[][] tablero) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    public static void jugarTurnoJugador(char[][] tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;
        
        do {
            System.out.print("Ingresa la fila (0, 1, 2) y la columna (0, 1, 2) separadas por espacio: ");
            fila = scanner.nextInt();
            columna = scanner.nextInt();
        } while (fila < 0 || fila > 2 || columna < 0 || columna > 2 || tablero[fila][columna] != ' ');
        
        tablero[fila][columna] = 'X';
    }
    
    public static void jugarTurnoOrdenador(char[][] tablero) {
        Random random = new Random();
        int fila, columna;
        
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (tablero[fila][columna] != ' ');
        
        tablero[fila][columna] = 'O';
        System.out.println("El ordenador jugó en la fila " + fila + " y la columna " + columna);
    }
    
    public static boolean verificarGanador(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; // Fila completa
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true; // Columna completa
            }
        }
        
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true; // Diagonal principal
        }
        
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true; // Diagonal secundaria
        }
        
        return false;
    }
}
