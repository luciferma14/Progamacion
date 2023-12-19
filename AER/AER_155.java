import java.util.Scanner;

public class AER_155 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ancho;
        int largo;
        int resultado;

        System.out.print("¿Cuánto mide de ancho?: ");
        ancho = sc.nextInt();

        System.out.print("¿Cuánto mide de largo?: ");
        largo = sc.nextInt();

        resultado = (ancho + ancho + largo + largo);

        System.out.println("El perímetro del rectángulo es: " + resultado);
    }
}