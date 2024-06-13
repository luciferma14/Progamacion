import java.util.Scanner;

public class AER_433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int uvas;
        
        while (true) {
            uvas = sc.nextInt();
            if (uvas == 0) {
                System.exit(0);
            }

            int nivel = 0;
            int totalUvas = 0;

            while (totalUvas < uvas) {
                nivel++;
                totalUvas += nivel;
            }

            System.out.println(nivel);
        }
    }
}
