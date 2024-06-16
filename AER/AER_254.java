import java.util.Arrays;
import java.util.Scanner;

public class AER_254 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int casos = sc.nextInt();
            if (casos == 0) {
                break;
            }
            
            int[] personas = new int[casos];
            for (int i = 0; i < casos; i++) {
                personas[i] = sc.nextInt();
            }

            int[] esquis = new int[casos];
            for (int i = 0; i < casos; i++) {
                esquis[i] = sc.nextInt();
            }

            int result = menor(personas, esquis);
            System.out.println(result);
        }
    }

    private static int menor(int[] personas, int[] esquis) {
        Arrays.sort(personas);
        Arrays.sort(esquis);

        int menor = 0;
        for (int i = 0; i < personas.length; i++) {
            menor += Math.abs(personas[i] - esquis[i]);
        }

        return menor;
    }
}
