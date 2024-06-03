
import java.util.Scanner;

public class EjercicioPE_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;

        System.out.print("Introduce un número positivo y > 0: ");
        num = sc.nextInt();

        if (num <= 0) {
            System.out.print("Por favor, escriba un número positivo o > 0: ");
        } else {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    int resultado = i + j + (i * j);

                    System.out.println("Para " + "(" + i + "," +  j + "): " + i + "+" + j + "+" + i + "*" + j + " vale " + resultado );
                }
            }
        }
    }
}