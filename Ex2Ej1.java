import java.net.Socket;
import java.util.Scanner;

public class Ex2Ej1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int casos;
        int clientes;
        int maletas;
        int viaje;


        System.out.print("Casos: ");
        casos = sc.nextInt();

        for(int i = 1; i <= casos; i++){
            System.out.print("Clientes: ");
            clientes = sc.nextInt();

            for (int j = 1; j <= clientes; j++){
                System.out.print("Maletas: ");
                maletas = sc.nextInt();
            
            } 

        if (maletas <= 10){
            System.out.println("Viajes: " + (viaje = 1));
        }else if (maletas <= 20){
            System.out.println("Viajes: " + (viaje = 2));
        }else if (maletas <= 30){
            System.out.println("Viajes: " + (viaje = 3));
        }else if (maletas <= 40){
            System.out.println("Viajes: " + (viaje = 4));
        }else if (maletas <= 50){
            System.out.println("Viajes: " + (viaje = 5));
        }else if (maletas <= 60){
            System.out.println("Viajes: " + (viaje = 6));
        }
        }




    }
}
