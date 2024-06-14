import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ref = "";
        int m3 = 0;

        while(true){
            try {
                boolean recoge = false;
                while(!recoge){
                    System.out.print("Referencia: ");
                    ref = sc.nextLine();
                    recoge = Calculos.esta(ref);
                }

                System.out.print("m3: ");
                m3 = sc.nextInt();
                sc.nextLine();
                ArrayList<String> salida = Calculos.calcular(ref, m3);
                for(String s: salida){
                    System.out.println(s);
                }
                System.out.println("--------------");

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }   
        }
    }
}