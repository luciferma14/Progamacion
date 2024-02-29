import java.util.InputMismatchException;
import java.util.Scanner;

public class Throws {

    private static Scanner sc = new Scanner(System.in);

    private static int dividir(int num, int den) throws ArithmeticException, InputMismatchException {
        try {
            return num / den;
        } catch (ArithmeticException e) {
            System.out.println("Error: No se puede dividir por 0");
            return 0; 
        }catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar números válidos");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.print("Numerador: ");
        int num = sc.nextInt();
        System.out.print("Denominador: ");
        int den = sc.nextInt();

        try {
            int resul = dividir(num, den); 
            System.out.println("Resultado: " + num + " / " + den + " = " + resul);
        } catch (Exception e) {
            System.out.println("Problemas con la división");
        }
    }
}
