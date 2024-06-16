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

            int[] esquiadores = new int[casos];
            int[] esquis = new int[casos];

            for (int i = 0; i < casos; i++) {
                esquiadores[i] = sc.nextInt();
            }

            for (int i = 0; i < casos; i++) {
                esquis[i] = sc.nextInt();
            }

            int result = menor(esquiadores, esquis);
            System.out.println(result);
        }
    }

    private static int menor(int[] esquiadores, int[] esquis) {
        Arrays.sort(esquiadores);
        Arrays.sort(esquis);

        int menor = 0;
        for (int i = 0; i < esquiadores.length; i++) {
            menor += Math.abs(esquiadores[i] - esquis[i]);
        }

        return menor;
    }
}
