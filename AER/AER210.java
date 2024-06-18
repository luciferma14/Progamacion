import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AER210 {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int casos;
        String valores = "";
        int suma;

        System.out.print("Casos: ");
        casos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < casos; i++){
            suma = 0;
            valores = sc.nextLine();
            List<Integer> listaIntegers = valores.chars().boxed().collect(Collectors.toList());       
            for (int j : listaIntegers) {
                suma = suma + j;

            }

        }
    }
}
    


        

    
