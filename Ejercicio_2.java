package EjerciciosAvanzados1;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Peso: "); // En kilogramos
            double numeroPeso = teclado.nextDouble();
            System.out.println("Altura: "); // En metros
            float numeroAltura = teclado.nextFloat();

             double imc = (numeroPeso/(numeroAltura*numeroAltura));
             System.out.println("Tu índice de masa corporal es: " + imc);

            if (imc < 18.5) {
                System.out.println("Bajo peso");
            } else if (imc >= 18.5 && imc <= 24.9) {
                System.out.println("Normal");
            } else if (imc >= 25 && imc <= 29.9) {
                System.out.println("Sobrepeso");
            } else if (imc >= 30 && imc <= 30.01) {
                System.out.println("Obesidad");
            }
        }
         
    }

}