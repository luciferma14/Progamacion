import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class ManejoExcep {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num1;
        int num2;
        double resul;

        try {
            System.out.print("Dime un número: ");
            num1 = sc.nextInt();

            System.out.print("Dime otro número: ");
            num2 = sc.nextInt();

            resul = num1 / num2;

            System.out.println("La división entre el " + num1 + " y el " + num2 + " es " + resul);
            
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero");
        }
    }
}
