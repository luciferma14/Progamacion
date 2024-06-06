import java.util.Arrays;
import java.util.Scanner;

public class OrdenArray {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] array = new int[5];
        int numeros;

        System.out.println("Inserta 5 números: ");
        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros = sc.nextInt();
            array[i] = numeros;
        }
        System.out.println("Números insertados: " + Arrays.toString(array));
        System.out.println("Números invertidos: " + Arrays.toString(invertir(array)));


        // Otra forma

        System.out.println("Introduce 5 números enteros:");
        for (int i = 0; i < 5; i++) {
            array[i] = sc.nextInt();
        }
        
        System.out.println("Números en orden inverso:");
        for (int i = 4; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    public static int[] invertir(int[] array){
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - i - 1];
        }
        return invertido;
    }

    

}
