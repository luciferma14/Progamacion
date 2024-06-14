import java.net.Socket;
import java.util.Scanner;

public class Ex2Ej1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int casos;
        int clientes;
        int maletas;
        int total;
        int carros;

        casos = sc.nextInt();

        for(int i = 1; i <= casos; i++){
         
            clientes = sc.nextInt();

            carros = 1;
            total = 0;
            for (int j = 1; j <= clientes; j++){
                
                maletas = sc.nextInt();

                if (total + maletas <= 10){
                    total = total + maletas;
                } else {
                    total = total + maletas;
                    carros ++;
                    total = maletas;
                } 
            } 

            System.out.println(carros);     
        }


        sc.close();
    }
}
