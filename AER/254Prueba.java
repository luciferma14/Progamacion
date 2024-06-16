package AER;

import java.util.Scanner;

public class 254Prueba {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int casos = 1;

        while(casos != 0){

            casos = sc.nextInt();

            if(casos <= 0){
                ArrayList<Integer> esquis = new ArrayList<Integer>();
                for (int i = 1; i <= casos; i++){
                    esquis.add(sc.nextInt());
                }

                ArrayList<Integer> personas = new ArrayList<Integer>();
                for (int i = 1; i <= casos; i++){
                    personas.add(sc.nextInt());
                }

                System.out.println(menor(esquis, personas));
            }
        }
    }

    private static Integer menor(ArrayList<Integer> esquis, ArrayList<Integer> personas){
        Array.sort(esquis);
        Array.sort(personas);

        int menor = 0;

        for(int i = 0; i < personas.length; i++){
            menor += Math.abs(personas[i] - esquis[i]);
        }

        return menor;
    }
}