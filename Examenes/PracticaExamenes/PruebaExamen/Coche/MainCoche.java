import java.util.Scanner;

public class MainCoche {
    
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        String marca;
        String modelo;
        int año;

        System.out.print("Dime una marca coche: ");
        marca = sc.nextLine();

        System.out.print("Dime el modelo: ");
        modelo = sc.nextLine();

        System.out.print("Ahora dime el año del coche: ");
        año = sc.nextInt();

        Coche coche = new Coche(marca, modelo, año);

        System.out.println(coche.mostrarInformacion());
    }
}
