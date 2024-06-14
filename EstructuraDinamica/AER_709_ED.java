package EstructuraDinamica;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AER_709_ED {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
 
        Map<String, Integer> VoTos = new HashMap<>();

        int votos;
        String propuesta;
        int maxVotos;
        String ganador;

        while (true) {

            System.out.print("Número de votos: ");
            votos = sc.nextInt();

            if (votos == 0) {
                System. exit(0);
            }

            System.out.println("Propuesta:");
            for (int i = 0; i < votos; i++) {
                propuesta = sc.next();
                VoTos.put(propuesta,VoTos.getOrDefault(propuesta, 0) + 1);
            }

            maxVotos = 0;
            ganador = "EMPATE";

            for (Map.Entry<String, Integer> elemento : VoTos.entrySet()) {
                if (elemento.getValue() > maxVotos) {
                    maxVotos = elemento.getValue();
                    ganador = elemento.getKey();
                } else if (elemento.getValue() == maxVotos) {
                    ganador = "EMPATE";
                }
            }

            System.out.println(ganador);
        }
    }
}
