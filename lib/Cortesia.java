package lib;
import java.util.Scanner;

public class Cortesia {
    public static String saludo () {

        Scanner sc = new Scanner(System.in);

        String idioma;
        String nombre = " ";

        System.out.print("Idiomas disponibles: ");
        idioma = sc.nextLine();

        if (idioma.equalsIgnoreCase("ES")){
            System.out.println("Estimado " + nombre);
        }

        if (idioma.equalsIgnoreCase("EN")){
            System.out.println("Dear " + nombre);
        }

        if (idioma.equalsIgnoreCase("FR")){
            System.out.println("Cher " + nombre);
        }
        return idioma;  
    }

    public static String despedida () {

        Scanner sc = new Scanner(System.in);

        String idioma;

        System.out.print("Idiomas disponibles: ");
        idioma = sc.nextLine();

        if (idioma.equalsIgnoreCase("ES")){
            System.out.println("Saludos cordiales");
        }

        if (idioma.equalsIgnoreCase("EN")){
            System.out.println("Best regards");
        }

        if (idioma.equalsIgnoreCase("FR")){
            System.out.println("Bien cordialement");
        }



        return idioma;
    }

}