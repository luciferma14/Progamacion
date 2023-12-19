import java.util.Scanner;
import java.util.Random;

public class EjPE_Extra3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numSecreto;
        int respUsuario = 0;
        boolean continua;
        int i = 1;
        
        numSecreto = rand.nextInt(100)+1;
        
        while (i <= 5) {
            i = i + 1;
            continua = true;

            System.out.print("El PC ya ha pensado su numero, adivinelo: ");
            respUsuario = sc.nextInt();
       
            if (numSecreto != respUsuario);{
                continua = true;
            }if(numSecreto == respUsuario){
                continua = false;
            }

            if (respUsuario > numSecreto) {
                System.out.println("Es menor");
            }else {
                System.out.println("Es mayor");
            }
        }
        if (respUsuario == numSecreto) {
                System.out.println("Has acertado");
            }else {
                System.out.println("El numero era " + numSecreto);
            }
        

    }
}