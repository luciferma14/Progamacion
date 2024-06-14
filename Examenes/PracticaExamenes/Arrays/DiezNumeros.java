import java.util.Arrays;
import java.util.Scanner;

public class DiezNumeros{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] cinco = new int[5];
        int numeros;

        System.out.println("Inserta 5 números: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros = sc.nextInt();
            cinco[i] = numeros;
        }
        System.out.println("Números insertados: " + Arrays.toString(cinco));
        System.out.println("Números invertidos: " + Arrays.toString(invertir(cinco)));
    }

    public static int[] invertir(int[] array){
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - i - 1];
        }
        return invertido;
    }
}