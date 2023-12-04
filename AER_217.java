package AER;
import java.util.Scanner;

public class AER_217 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int numeroVivienda;

        System.out.print("Número vivienda: ");

        while (true){
            numeroVivienda = sc.nextInt();

            if (numeroVivienda == 0){
                System.exit(0);
            }

            if(numeroVivienda % 2 == 0){
                System.out.println("DERECHA");
            }else {
                System.out.println("IZQUIERDA");
            }
        }
    }
}