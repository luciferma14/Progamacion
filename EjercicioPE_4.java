package PGM.EjercicioPE;
import java.util.Scanner;

public class EjercicioPE_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;
        int i;


        do {
        System.out.print("Introduce un número: ");
        num = sc.nextInt();
        
        } while (num <= 0);
            if (num == 1) {// en 1 no es primo 
            System.out.println(num + " no es primo");

       }else {
            i = 2; // i es el divisor 
            while (num % i != 0) {
                i++;
            }
            if (i == num) {
                System.out.println(num + " es primo");
            } else {
                System.out.println(num + " no es primo");
            }
            }
        
     
    }
}
 
