import java.util.Scanner;


public class EjArray2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String jugador = "X";
        String ordenador = "O";
        int fila;
        int columna;

        char[][]a = {{'X'},{'O'},{'X'}};;
                      

        for (int i = 1; i <=1; i++){
            for (int j = 2; j <=2; j++){
                for (int z = 3; z <= 3; z++){
                    
                    System.out.println("   " + i + "  " + j + "  " + z);
                                
                }
            }
        }
        
        System.out.println("1| " + " | " + " | " + " | ");
        System.out.println(" ----------");
        System.out.println("2| " + " | " + " | " + " | ");
        System.out.println(" ----------");
        System.out.println("3| " + " | " + " | " + " | ");


        System.out.println("Empieza el jugador, elige una posición (indicando columna/fila): ");
        columna = sc.nextInt();
        fila = sc.nextInt();

        //for (fila = 1; fila <= 1; fila++) {
        //    for (columna = 1; columna <= 1; columna++) {

        //        System.out.println(jugador);
        //    }
        //    }


        if (columna == 1) {
            if (fila == 1) {

                System.out.println("   1   2   3");
                System.out.println("1| " + "X"+ " | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " + "  | " + "  | " + "  | ");
            }

        }
            if (columna == 1) {
                if (fila == 2) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "X"+" | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " + "  | " + "  | " + "  | ");
            }

        }

                if (columna == 1) {
                    if (fila == 3) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "X"+ " | " + "  | " + "  | ");
        }


    }

                if (columna == 2) {
                    if (fila == 1) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " +  "X"+" | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " + "  | " + "  | ");

                }
            }

                if (columna == 2) {
                    if (fila == 2) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " +   "X"+" | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " + "  | " + "  | ");

                }
            }

                if (columna == 2) {
                    if (fila == 3) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " +   "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " + "X"+" | " + "  | ");

                }
            }

                if (columna == 3) {
                    if (fila == 1) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "X"+" | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " +   "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " +  "  | " + "  | ");

                }
            }

                if (columna == 3) {
                    if (fila == 2) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " +   "  | " + "X"+" | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " +  "  | " + "  | ");

                }
            }

                if (columna == 3) {
                    if (fila == 3) {

                System.out.println("   1   2   3");
                System.out.println("1| " +  "  | " + "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("2| " + "  | " +   "  | " + "  | ");
                System.out.println(" -------------");
                System.out.println("3| " +  "  | " +  "  | " + "X"+" | ");

                }
            }
            
    }
    }

    