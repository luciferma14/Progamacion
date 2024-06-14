import java.util.Scanner;

public class FactorialRecur {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int num = sc.nextInt();
        
        System.out.println("El factorial de " + num + " es: " + factorial(num));
    }
    
    public static int factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }
}