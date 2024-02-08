import java.util.Scanner;

public class MenuVehiculos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opc;
        
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

        switch (opc) {
            case 1:
                
                break;
            case 2:

            default:
                break;
        }

        
    }
}
