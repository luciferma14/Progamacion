//import libreria.FNumDAW;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AER210 {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        int casos;
        String valores = "";

        System.out.print("Casos: ");
        casos = sc.nextInt();

        for (int i = 0; i < casos; i++){
            List<Integer> listaIntegers = valores.chars().boxed().collect(Collectors.toList());       
            valores = sc.next();
            for (int b = 0; b < valores.length(); b++){
                for (int j : listaIntegers) {
                    System.out.println(j);
                }
            }           
        }
    


        

    }
}