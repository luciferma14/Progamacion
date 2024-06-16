import java.util.Arrays;
import java.util.Scanner;

public class AER_254 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;
            }

            int[] esquiadores = new int[N];
            int[] esquis = new int[N];

            for (int i = 0; i < N; i++) {
                esquiadores[i] = scanner.nextInt();
            }

            for (int i = 0; i < N; i++) {
                esquis[i] = scanner.nextInt();
            }

            int resultado = minimizarDiferencias(esquiadores, esquis);
            System.out.println(resultado);
        }

        scanner.close();
    }

    private static int minimizarDiferencias(int[] esquiadores, int[] esquis) {
        Arrays.sort(esquiadores);
        Arrays.sort(esquis);

        int sumaDiferencias = 0;
        for (int i = 0; i < esquiadores.length; i++) {
            sumaDiferencias += Math.abs(esquiadores[i] - esquis[i]);
        }

        return sumaDiferencias;
    }
}
