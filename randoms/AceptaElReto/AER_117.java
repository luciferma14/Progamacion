import java.util.Scanner;
import java.util.ArrayList;

public class AER_117 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>(); 

        int personasDesconocidas;
        String nomPersonas;

        System.out.print("¿Cuántas personas no conoce Tinín?: ");
        personasDesconocidas = sc.nextInt();

        for (int i = 0; i < personasDesconocidas; i++) {
            System.out.print("Soy "); 
            nomPersonas = sc.next();
            nombres.add(nomPersonas);
        }

        for (String nombre : nombres) { 
            System.out.println("Hola, " + nombre + "."); 
        }
    }
}
