package EstructuraDinamica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AER_238_ED {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> billetes = new ArrayList<>();
        List<List<Integer>> personas = new ArrayList<>();
        List<Integer> numPersona = new ArrayList<>();

        int numBilletes;
        int numPers;
        int cantNumPers;
        int totalDinero;
        int dineroAsignado;
         

        while (true) {

            System.out.println("Número de billetes y número de personas (0 0 para salir):");
            numBilletes = sc.nextInt();
            numPers = sc.nextInt();

            if (numBilletes == 0 && numPers == 0) {
                System. exit(0);
            }

            System.out.println("Valor billetes:");
            
            for (int i = 0; i < numBilletes; i++) {
                billetes.add(sc.nextInt());
            }

            System.out.println("Información personas:");
            
            for (int i = 0; i < numPers; i++) {
                System.out.print("Cantidad de billetes para la persona " + (i + 1) + ": ");
                cantNumPers = sc.nextInt();
                
                System.out.println("Valor billetes para la persona  " + (i + 1) + ":");
                for (int j = 0; j < cantNumPers; j++) {
                    numPersona.add(sc.nextInt());
                }
                personas.add(numPersona);
            }

            totalDinero = 0;
            for (int i : billetes) {
                totalDinero = totalDinero + i;
            }

            for (int i = 0; i < numPers; i++) {
                dineroAsignado = totalDinero / numPers;
                System.out.print(dineroAsignado + ": ");

                for (int billete : personas.get(i)) {
                    System.out.print(billete + " ");
                }
                System.out.println();
            }

            System.out.println("---");
        }
    }
}
