import java.util.Scanner;

public class EjercicioPE_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int base;
        int exponente;
        int resultado = 1;

        System.out.println("Escribe la base: ");
        base = sc.nextInt();

        System.out.println("Escribe un exponente: ");
        exponente = sc.nextInt();

        for (int i = 1; i <= exponente; i++) {
            resultado *= base;
        }

        System.out.println("La base " + base + " elvadada a " + exponente + " da como reslutado = " + resultado);

    }
}
