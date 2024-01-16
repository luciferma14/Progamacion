import java.util.Scanner;

public class EjArray1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[15];

        System.out.println("Escribe 15 números: ");

        for (int i = 0; i < 15; i++) {
            System.out.println("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        int ultimoNumero = numeros[14];
        for (int i = 14; i > 0; i--) {
            numeros[i] = numeros[i - 1];
        }
        numeros[0] = ultimoNumero;

        System.out.println("Rotación:");

        for (int i = 0; i < 15; i++) {
            System.out.println("Número " + (i + 1) + ": " + numeros[i]);
        }

    }
}
