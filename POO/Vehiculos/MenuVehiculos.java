import java.util.Scanner;

public class MenuVehiculos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Bicicleta bici = new Bicicleta();
        Coche carro = new Coche();

        int opc;
        int biciKM;
        int cocheKM;
        
        do{
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
                    System.out.print("Km que quieres sumar: ");
                    biciKM = sc.nextInt();
                    bici.anda(biciKM);
                    System.out.println("Se han sumado " + biciKM + "km");
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Km que quieres sumar: ");
                    cocheKM = sc.nextInt();
                    carro.anda(cocheKM);
                    System.out.println("Se han sumado " + cocheKM + "km");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println("Km Bici: " + bici.getKilometrosRecorridos());
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Km Coche: " + carro.getKilometrosRecorridos());
                    System.out.println(" ");
                    break;
                case 5:
                    System.out.println("Km Totales: " + Vehiculo.getKilometrosTotales());
                    System.out.println(" ");
                    break;
                case 6:
                    System.out.println("Vehículos: " + Vehiculo.getVehiculosCreados());
                    System.out.println(" ");
                    break;
                case 7:
                    System. exit(0);
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(true);
    }
}
