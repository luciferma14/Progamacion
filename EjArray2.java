import java.util.Scanner;
import java.util.Random;

public class EjArray2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int fila1;
        int columna1;
        int i = 0;
      
        boolean hayGanador = true;

        char[][] a ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        while (i <= 9) {
            boolean haspasado = true;
            //Mostrar matriz
            System.out.println("   0   1   2");
            for (int ia = 0; ia < 3; ia++) {
                for (int j = 0; j < 3; j++) {
                    if (j <= 0) {
                        System.out.print(ia + "| ");
                    }
                    System.out.print(a[ia][j]);
                    if (j < 3) {
                        System.out.print(" | ");
                    }
                }
                System.out.println();
                if (ia < 2) {
                    System.out.println("--------------");
                }
            }
            while (haspasado) {
                System.out.println("Jugador, elige una posición (indicando columna/fila): ");
                System.out.print("Columna: ");
                columna1 = sc.nextInt();
                System.out.print("Fila: ");
                fila1 = sc.nextInt();
                if (a[fila1][columna1] == ' ') {
                    a[fila1][columna1] = 'X';
                    haspasado = false;
                }
                }
            i++;
            haspasado= true;
            // Esta es la maquina
            if ( i <= 8) {
                while (haspasado) {
                    columna1 = (int) (Math.random() * 3);
                    fila1 = (int) (Math.random() * 3);
                    if (a[fila1][columna1] == ' ') {
                        a[fila1][columna1] = 'O';
                        haspasado = false;
                    }               
                }
            }
            i++;
            if (hayGanador) {
                if (a[0][0] == 'X'){
                    if (a[0][1] == 'X') {
                        if (a[0][2] == 'X') {
                            System.out.println("Has ganado!");
                        }
                    }   
                }
            } 
            if (hayGanador) {
                if (a[1][0] == 'X'){
                    if (a[1][1] == 'X') {
                        if (a[1][2] == 'X') {
                            System.out.println("Has ganado!");
                        }   
                    }
                }
            }
            if (hayGanador) {
                if (a[2][0] == 'X'){
                    if (a[2][1] == 'X') {
                        if (a[2][2] == 'X') {
                            System.out.println("Has ganado!");
                        }   
                    }
                }
            }
            if (hayGanador) {
                if (a[0][0] == 'X') {
                    if (a[1][1] == 'X') {
                        if (a[2][2] == 'X') {
                            System.out.println("Has ganado!");
                        }
                    }
                }
            }  
            if (hayGanador) {
                if (a[2][0] == 'X') {
                    if (a[1][1] == 'X') {
                        if (a[0][2] == 'X') {
                            System.out.println("Has ganado!");
                        }
                    }
                }
            }
            if (hayGanador) {
                if (a[0][0] == 'X'){
                    if (a[1][0] == 'X') {
                        if (a[2][0] == 'X') {
                            System.out.println("Has ganado!");
                        }
                    }
                }
            }
            if (hayGanador) {
                if (a[0][1] == 'X') {
                    if (a[1][1] == 'X') {
                        if (a[2][1] == 'X') {
                            System.out.println("Has ganado!");

                        
                        }
                    }
                }
            }
            if (hayGanador) {
                if (a[2][2] == 'X'){
                    if (a[1][2] == 'X') {
                        if (a[0][2] == 'X') {
                            System.out.println("Has ganado!");
                        }
                    }
                }
            }else  
                System.out.println("PC gana!");



            
        }
    }
}
