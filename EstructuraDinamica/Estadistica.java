
        
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estadistica {
    public static void main(String[] args) {
        
        List<Double> numeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String entrada;
        double suma = 0;
        double sumaCuadrados = 0;
        double numero;
        int num;
        double media;
        double desviacion;

        while (true) {
            
            System.out.print("Número: ");
            entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("q")) {
                System. exit(0);
            }

            numero = Double.parseDouble(entrada);
            numeros.add(numero);

            num = numeros.size();
            suma += numero;
            sumaCuadrados += Math.pow(numero, 2);

            media = suma / num;
            desviacion = Math.sqrt((sumaCuadrados - num * Math.pow(media, 2)) / num);

            System.out.println("-Media: " + media + "  -Desviaci�n t�pica: " + desviacion);
        }
    }
}