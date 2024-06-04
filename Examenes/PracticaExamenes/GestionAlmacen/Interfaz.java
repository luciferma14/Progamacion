package PracticaExamenes.GestionAlmacen;

import java.util.ArrayList;
import java.util.Scanner;

public class Interfaz {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int opc;
        String nom;
        double prec;
        int cant;
        ArrayList<String> listarProd = new ArrayList<String>();

        while(true){
            System.out.println("--------Menú--------");
            System.out.println("1) Añadir producto");
            System.out.println("2) Eliminar producto");
            System.out.println("3) Modificar producto");
            System.out.println("4) Listar productos");
            System.out.println("5) Salir");

            System.out.print("Opción: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Nombre: ");
                    nom = sc.next();
                    System.out.print("Precio: ");
                    prec = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    cant = sc.nextInt();
                    //Añadir producto a la lista
                    listarProd.add("Nombre: " + nom + ", Precio: " + prec + ", Cantidad: " + cant + "\n");
                    
                break;
                case 2:
                    System.out.println(listarProd);
                    System.out.print("Nombre: ");
                    nom = sc.next();
                    //Eliminar producto de la lista
                    for (int i = 0; i < listarProd.size(); i++) {
                        if(listarProd.get(i).contains(nom)){
                            listarProd.remove(i);
                            System.out.println("Producto eliminado");
                        }
                    }
                break;
                case 3:
                    System.out.println(listarProd);
                    System.out.print("Nombre: ");
                    nom = sc.next();
                    //Modificar producto de la lista
                    listarProd.get(0);
                    System.out.print("Nuevo nombre: ");
                    String nuevoNom = sc.next();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrec = sc.nextDouble();
                    System.out.print("Nueva cantidad: ");
                    int nuevaCant = sc.nextInt();
                    //Modificar producto en la lista
                    for (int i = 0; i < listarProd.size(); i++) {
                        if(listarProd.get(i).contains(nom)){
                            listarProd.set(i, "Nombre: " + nuevoNom + ", Precio: " + nuevoPrec + ", Cantidad: " + nuevaCant + "\n");
                        }
                    }
                break;
                case 4:
                    System.out.println(listarProd);
                break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                break;
                default:
                    System.out.println("Opción no válida");
                break;
            }


        }
    }
}