import java.util.Scanner;


public class EjArray2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String jugador = "X";
        String ordenador = "O";

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
        
        System.out.println("Empieza el jugador, elige una posición (indicando fila/columna): ");

    }
}    