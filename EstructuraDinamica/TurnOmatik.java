package EstructuraDinamica;

import java.util.Scanner;
import java.util.LinkedList;

public class TurnOmatik {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList<String> clientes = new LinkedList<String>();

        Integer opcion;
        String cliente;

        do {
            System.out.println("--------------Menú---------------");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Mostrar cola actual");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");

            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del nuevo cliente: ");
                    cliente = sc.nextLine();
                    clientes.add(cliente);
                    break;

                case 2:
                    if (!clientes.isEmpty()) {
                        cliente = clientes.poll();
                        System.out.println("Atendiendo a: " + cliente);
                    } else {
                        System.out.println("No hay clientes en la cola.");
                    }
                    break;

                case 3:
                    System.out.println("Cola actual: " + clientes);
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 0);

            sc.close(); 
    }
}
