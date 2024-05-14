import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();

        while (true) {
            System.out.print("Referencia del tablón: ");
            String referencia = scanner.nextLine();

            System.out.print("Volumen en m3: ");
            int volumen = scanner.nextInt();
            scanner.nextLine();

            try {
                double precioTotal = 0, unidades = 0, precioPorM3 = 0;
                Calculo calculo = new Calculo(catalogo);
                calculo.calcular(referencia, volumen);
                precioTotal = calculo.getPrecioTotal();
                unidades = calculo.getUnidades();
                precioPorM3 = calculo.getPrecioPorM3();

                System.out.println("Precio total: " + precioTotal + " euros");
                System.out.println("Unidades necesarias: " + unidades);
                System.out.println("Precio por m3: " + precioPorM3 + " euros");

            }catch (InputMismatchException e){
                System.out.println("No es un número");
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}