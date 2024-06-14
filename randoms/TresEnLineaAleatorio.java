import java.util.Random;

public class TresEnLineaAleatorio {
    public static void main(String[] args) {
        char[][] tablero = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
        };

        Random rand = new Random();
        char jugadorActual = 'X';

        for (int jugadas = 0; jugadas < 9; jugadas++) {
            // Muestra el estado actual del tablero
            imprimirTablero(tablero);

            // Realiza el movimiento aleatorio del ordenador
            if (jugadorActual == 'O') {
                hacerMovimientoAleatorio(tablero, rand);
            }

            // Cambia el jugador actual
            jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
        }

        // Muestra el resultado final
        imprimirTablero(tablero);
    }

    public static void imprimirTablero(char[][] tablero) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public static void hacerMovimientoAleatorio(char[][] tablero, Random rand) {
        int fila, columna;
        do {
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
        } while (tablero[fila][columna] != ' ');

        tablero[fila][columna] = 'O';
    }
}
