package EjerciciosAvanzados1;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println(scanner);

        System.out.println("Peso: "); // En kilogramos
        System.out.println("Altura: "); // En metros

        double numeroPeso = scanner.nextDouble();
        double numeroAltura = scanner.nextDouble();
        double imc = (numeroPeso/numeroAltura*numeroAltura);

         
         System.out.println("\nTu índice de masa corporal es: " + imc);
         

        
    }

}