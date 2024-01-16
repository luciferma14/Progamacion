import java.util.Scanner;
import java.util.ArrayList;


public class AER_149 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> toros = new ArrayList<>();

        int numToros;
        String velocidad;


        System.out.print("¿Cuántos toros corren?: ");
        numToros = sc.nextInt();

        for (int i = 0; i < numToros; i++) {
            System.out.print("¿A qué velocidad van?: "); 
            velocidad = sc.next();
            toros.add(velocidad);
        }

        for (String velocCorredores : toros) {
                System.out.println("Los corredores deberán correr a " + velocCorredores);
        }
        
    }
}