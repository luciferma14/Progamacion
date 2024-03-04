import java.util.Scanner;

public class Vector {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] vector = {0,1,2,3,4};

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i;
        }
        
        try {
            System.out.print("Posición: ");
            int pos = sc.nextInt();
            System.out.print("Número que añades: ");
            int num = sc.nextInt();
            vector[pos] = num;

            System.out.println("Valor añadido");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: La posición está fuera del rango");
        }
    }
}