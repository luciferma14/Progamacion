import java.util.Scanner;

public class AER_156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x < 0 || y < 0) {
                break;  // Si se proporciona un valor negativo, sal del bucle
            }

            // Calcula el perímetro del rectángulo
            int perimetro = 2 * (x + y);
            System.out.println(perimetro);
        }
    }
}
