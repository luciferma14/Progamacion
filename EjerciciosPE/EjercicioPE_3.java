
import java.util.Scanner;

public class EjercicioPE_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;
        int digitos;

        System.out.print("Intruduce un número + o - máx de 6 dígitos: ");
        num = sc.nextInt();

        num = Math.abs(num);

        String numStr = Integer.toString(num);
        digitos = numStr.length();
        
        System.out.println("El número tiene " + digitos + " digitos");
    }
}