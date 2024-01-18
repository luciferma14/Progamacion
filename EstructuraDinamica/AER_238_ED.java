package EstructuraDinamica;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class AER_238_ED{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Queue<Integer> billetes = new LinkedList<Integer>();
        Queue<Integer> guarda = new LinkedList<Integer>();
      
        int botines;
        int personas;
        int billete = 0;

        System.out.print("Botines: ");
        botines = sc.nextInt();

        System.out.print("Personas: ");
        personas = sc.nextInt();

        for (int i = 0; i < botines; i++){
            System.out.print("Billetes: ");
            billete = sc.nextInt();
            billetes.add(billete);
            
        }
        for (int i = 0; i < personas; i++){
            billetes.poll();
            guarda.add(billetes.poll());
        }
        for (int i = 0; i < personas; i++){
            System.out.println(guarda);    
        }    


    }
}