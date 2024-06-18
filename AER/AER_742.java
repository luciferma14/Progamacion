import java.util.Scanner;

public class AER_742 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consumir la línea restante
        
        for (int t = 0; t < testCases; t++) {
            String drum = scanner.nextLine();
            int length = drum.length();
            
            // Calcular probabilidad de No girar
            double noGirarProbabilidad = 0;
            for (int i = 1; i < length; i++) {
                if (drum.charAt(i) == '0') {
                    noGirarProbabilidad++;
                }
            }
            noGirarProbabilidad /= (length - 1);
            
            // Calcular probabilidad de Girar
            double contarCeros = 0;
            for (int i = 0; i < length; i++) {
                if (drum.charAt(i) == '0') {
                    contarCeros++;
                }
            }
            double girarProbabilidad = contarCeros / length;
            
            // Determinar la mejor acción
            if (noGirarProbabilidad > girarProbabilidad) {
                System.out.println("No girar");
            } else if (noGirarProbabilidad < girarProbabilidad) {
                System.out.println("Girar");
            } else {
                System.out.println("Da igual");
            }
        }
        
        scanner.close();
    }
}
