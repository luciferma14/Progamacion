import java.util.Scanner;

public class AER_163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String hexNumber;
        try {
            
            do {

                hexNumber = sc.nextLine();
                
                // Convertir el número hexadecimal a decimal
                long decimalNumber = Long.parseLong(hexNumber, 16);
                
                // Incrementar el número decimal en 1
                decimalNumber++;
                
                // Convertir el número decimal incrementado de vuelta a hexadecimal y a mayúsculas
                String nextHexNumber = Long.toHexString(decimalNumber).toUpperCase();
                
                // Imprimir el resultado
                System.out.println(nextHexNumber);
                
            }while (!hexNumber.equals("FIN"));

        } catch (NumberFormatException e) {}
    }
}