package lib;
import java.util.Scanner;

public class Cortesia {
    public static String saludo () {

        Scanner sc = new Scanner(System.in);

        String idioma;
        String nombre;

        System.out.print("Idiomas disponibles: ");
        idioma = sc.nextLine();

        if (idioma.equalsIgnoreCase("ES")){
            System.out.println("Suludo incial");
            System.out.println("Estimado");
        }
        return nombre;  
    }
}