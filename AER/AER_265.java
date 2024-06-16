import java.util.ArrayList;
import java.util.Scanner;

public class AER_265 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        int num;
        String numero;
        int numDigitos;
        int div = 0;
        int result = 0;

        do{
            num = sc.nextInt();

            if (num == 0){
                break;
            }else{
                numeros.add(num);   
            }

            numero = Integer.toString(num);
            
            for(int i = 0; i < numero.length(); i++){

                numDigitos = (int) Math.log10(num) + 1;
                div = (int) Math.pow(10, numDigitos - 1);
                result = num % div;
    
            }
            
            
            System.out.println(result);

        }while(num != 0);
    }
}
