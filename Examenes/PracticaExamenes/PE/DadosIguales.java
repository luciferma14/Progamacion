import java.util.Random;

public class DadosIguales{

    public static void main(String[] args) {
        
        Random random = new Random();

        int dado1 = 0;
        int dado2 = 0;

        do {
            dado1 = random.nextInt(6)+1;
            System.out.println("Primer dado: " + dado1);

            dado2 = random.nextInt(6)+1;
            System.out.println("Segundo dado: " + dado2);
            System.out.println("================");

        }while(dado1 != dado2);

        if(dado1 == dado2){
            System.out.println("Ha salido el mismo número en los dos dados");
        }
    }
}