import java.util.Arrays;
import java.util.Scanner;

public class OrdenaNum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] desorden = new int[5];
        for (int i = 0; i < desorden.length; i++){
            System.out.println("Número " + i + ": ");
            desorden[i] = sc.nextInt();
        }

        System.out.println("Tu array: " + Arrays.toString(desorden));
        System.out.println("Array ordenado: " + Arrays.toString(orden(desorden)));

    }
    public static int[] orden(int[] array) {
        // ordenar de mayor a menor
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }

        return array;
    }
}
