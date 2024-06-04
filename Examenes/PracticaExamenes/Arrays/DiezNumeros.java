import java.util.Arrays;
import java.util.Scanner;

public class DiezNumeros{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] diez = new int[5];
        int numeros;

        System.out.println("Inserta 10 números: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros = sc.nextInt();
            diez[i] = numeros;
        }
        System.out.println("Números insertados: " + Arrays.toString(diez));
        System.out.println("Números invertidos: " + Arrays.toString(invertir(diez)));
    }

    public static int[] invertir(int[] array){
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - i - 1];
        }
        return invertido;
    }
}