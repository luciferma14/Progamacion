package EstructuraDinamica;

import java.util.Scanner;
import java.util.Stack;

public class Estadística {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Stack<Integer> numeros = new Stack<Integer>();

        String entrada;
        boolean salir = false;

        while (!salir) {

            System.out.println("Media:        Desviación típica: " );

            System.out.print("Numero: ");
            entrada = sc.next();

            

            if (entrada.equalsIgnoreCase("q")) {
            salir = true;
            }
        }
    }
}
