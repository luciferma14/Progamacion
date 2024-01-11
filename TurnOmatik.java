package EstructuraDinamica;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Collections;

public class TurnOmatik {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        LinkedList<String> clientes = new LinkedList<String>();

        Integer opcion;
        String cliente;

        
            System.out.println("--------------Menú---------------");
            System.out.println("1. Nuevo cliente");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Mostrar cola actual");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println();

        while (opcion != null); {

            switch (opcion) {
                case 1: 
                        System.out.print("Nombre del nuevo cliente: ");
                        cliente = sc.nextLine();
                        clientes.add(cliente);
                        System.out.println(cliente);
                    break;
                case 2: 
                        System.out.print("Nombre del cliente: ");
                        cliente = sc.nextLine();
                        clientes.remove(cliente);
                        System.out.println(cliente);
                    break;
                case 3:
                default:
                    break;
            }
            

            if (opcion == 0) {
                System. exit(0); 
            }
        }
    }
}