import java.util.Scanner;

public class AER_438 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String frase = "";

        do {
            frase = sc.nextLine();
            
            if (frase.contains("!")){
                System.out.println("ESGRITO");
            }else{
                System.out.println("escrito");
            }
        }while(!frase.equals("Salir"));
    }
}
