
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class AER_313 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int casos;
        int dato1;
        int dato2;

        System.out.print("Casos: ");
        casos = sc.nextInt();

        for (int i = 0; i < casos; i++) {

            System.out.print("Dato 1: ");
            dato1 = sc.nextInt();

            System.out.print("Dato 2: ");
            dato2 = sc.nextInt();

            if (dato1 + dato2 < 0) {
                System.out.println("NO");
            } else {
                System.out.println("SI");
            }
        }


    }

}
