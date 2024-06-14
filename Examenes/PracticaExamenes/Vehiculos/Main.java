
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        Bicicleta bic = new Bicicleta();
        Coche co = new Coche();

        int opc;

        do {
            System.out.println("              VEHÍCULOS"); 
            System.out.println("====================================="); 
            System.out.println("1. Anda en bicicleta"); 
            System.out.println("2. Anda en coche"); 
            System.out.println("3. Ver kilometraje de la bicicleta"); 
            System.out.println("4. Ver kilometraje del coche"); 
            System.out.println("5. Ver kilometraje total"); 
            System.out.println("6. Ver vehículos totales");
            System.out.println("7. Salir");
            System.out.print("Elige una opción (1-7): ");
            opc = sc.nextInt();
            System.out.println(" ");

        
            switch (opc) {
                case 1:
                    System.out.println("Km que recorrer: ");
                    int bicikm = sc.nextInt();
                    bic.anda(bicikm);
                break;
                case 2:
                    System.out.println("Km que recorrer: ");
                    int cochekm = sc.nextInt();
                    co.anda(cochekm);
                break;
                case 3:
                    System.out.println("Kilometros de la bicicleta: " + bic.kilometrosRecorridos());
                break;
                case 4:
                    System.out.println("Kilometros del coche: " + co.kilometrosRecorridos());
                break;  
                case 5:
                    System.out.println("Kilometros totales: " + Vehiculos.kilometrosTotales());  
                break;
                case 6:
                    System.out.println("Vehículos totales: " + Vehiculos.vehiculosCreados());        
                break;
                case 7:
                    System.out.println("Adiós!");
                    System.exit(0);
                break;
            }
        }while (true);
    }
}
