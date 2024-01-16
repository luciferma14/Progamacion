import java.util.Scanner;
import java.util.Random;

public class EjArray2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int fila1;
        int columna1;
        int i = 0;

        char[][] a ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        while (i < 9) {
            boolean haspasado = true;
            //Mostrar matriz
            System.out.println("   0   1   2");
            for (int ia = 0; ia < 3; ia++) {
                for (int j = 0; j < 3; j++) {
                    if (j <= 0) {
                        System.out.print(ia + "| ");
                    }
                    System.out.print(a[ia][j]);
                    if (j < 2) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (ia < 2) {
                    System.out.println("--------------");
                }
            }
            System.out.println("Jugador, elige una posición (indicando columna/fila): ");
            System.out.print("Columna: ");
            columna1 = sc.nextInt();
            System.out.print("Fila: ");
            fila1 = sc.nextInt();
            if (a[fila1][columna1] == ' ') {
                a[fila1][columna1] = 'X';
            }
            i++;
            // Esta es la maquina
            while (haspasado) {
                columna1 = (int) (Math.random() * 3);
                fila1 = (int) (Math.random() * 3);
                if (a[fila1][columna1] == ' ') {
                    a[fila1][columna1] = 'O';
                    haspasado = false;
                }
                i++;
            }       
               
            


            
        }

    }
}
