package EjerExamenes;
import java.util.Scanner;

public class lib {
    public static void cortesia() {

        Scanner sc = new Scanner(System.in);

        String idioma;
        String nombre;

        System.out.print("Idiomas disponibles: ");
        idioma = sc.nextLine();

        if (idioma.equalsIgnoreCase("ES")){
            System.out.println("Suludo incial");
            System.out.println("Estimado");
        }  
    }
}