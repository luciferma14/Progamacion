package EstructuraDinamica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class AER_238_ED{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        List<List<Integer>> distribucion = new ArrayList<>();
        List<Integer> numerosPersona = new ArrayList<>();
        HashMap<Integer, List<Integer>> asignacion = new HashMap<>();

        int botines;
        int personas;
        int billete;
        int cantNum = 0;
        int cantPers = 0;
        int cantNumPers;
        
        int[] numeros = new int[cantNum];

        System.out.print("Botines: ");
        botines = sc.nextInt();

        System.out.print("Personas: ");
        personas = sc.nextInt();

        for (int i = 0; i < botines; i++){
            System.out.print("Billetes: ");
            billete = sc.nextInt();     
        }
        
        for (int i = 0; i < cantNum; i++) {
            numeros[i] = sc.nextInt();
        }

        for (int i = 0; i < cantPers; i++) {
            cantNumPers = sc.nextInt();
            List<Integer> numers = new ArrayList<>();
            for (int j = 0; j < cantNumPers; j++) {
                numerosPersona.add(sc.nextInt());
            }
            distribucion.add(numerosPersona);
        }

        for (int i = 0; i < cantPers; i++) {
            for (Integer numero : distribucion.get(i)) {
                if (!asignacion.containsKey(numero)) {
                    asignacion.put(numero, new ArrayList<>());
                }
                asignacion.get(numero).add(i + 1);
            }
        }

        for (Map.Entry<Integer, List<Integer>> elemento : asignacion.entrySet()) {
            System.out.print(elemento.getKey() + ":");
            for (Integer persona : elemento.getValue()) {
                System.out.print(" " + persona);
            }
            System.out.println();
        }

        System.out.println("---");
    }
}