import java.util.ArrayList;
import java.util.Scanner;

public class AER_188 {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> palabras = new ArrayList<String>();

        String palabra1;
        String palabra2;
        String ultSilaba;
        String priSilaba;

        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            if (!linea.isEmpty()) {
                palabras.add(linea);
            }
        }

        for (String caso : palabras) {
            String[] palabra = caso.split(" ");

            boolean bien = true;

            for (int i = 0; i < palabra.length - 1; i++) {
                palabra1 = palabra[i];
                palabra2 = palabra[i + 1];

                ultSilaba = palabra1.substring(palabra1.length() - 2);
                priSilaba = palabra2.substring(0, 2);

                if (!ultSilaba.equals(priSilaba)) {
                    bien = false;
                    break;
                }
            }

            if (bien) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}
