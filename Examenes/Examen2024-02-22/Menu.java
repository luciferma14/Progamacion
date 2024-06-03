
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<Formulario> formularios = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int opc;

        do{
            System.out.println("--- Menú  ---");
            System.out.println("1. Crear pedido");
            System.out.println("2. Crear devolución");
            System.out.println("3. Crear reclamación");
            System.out.println("4. Cerrar reclamación");
            System.out.println("5. Imprimir formulario por ID");
            System.out.println("6. Imprimir todas las reclamaciones");
            System.out.println("7. Imprimir todos los formularios");
            System.out.println("0. Salir");

            System.out.print("Introduzca una opción: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    crearPedido(formularios);
                    break;
                case 2:
                    crearDevolucion(formularios);
                    break;
                case 3:
                    crearReclamacion(formularios);
                    break;
                case 4:
                    cerrarReclamacion(formularios);
                    break;
                case 5:
                    imprimirFormulario(formularios);
                    break;
                case 6:
                    imprimirTodasReclamaciones(formularios);
                    break;
                case 7:
                    imprimirTodos(formularios);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        
        }while(true);
    }
        private static <Formulario, Pedidos> void crearPedido(List<Formulario> formularios) {
            Scanner sc = new Scanner(System.in);

            System.out.println("--- Crear pedido ---");
    
            System.out.print("Nombre del cliente: ");
            String cliente = sc.nextLine();
    
            System.out.print("Poducto: ");
            String producto = sc.nextLine();
    
            System.out.print("Precio: ");
            double precio = sc.nextDouble();
    
            Pedidos pedido = new Pedidos(generarId("PE"), cliente, producto, precio);
            formularios.add(pedido);
    
            System.out.println("ID del pedido creado: " + pedido.getId());
        }

        private static void crearDevolucion(List<Formulario> formularios) {
            Scanner sc = new Scanner(System.in);

            System.out.println("--- Crear devolución ---");

            System.out.print("Nombre del cliente: ");
            String cliente = sc.nextLine();

            System.out.print("Poducto: ");
            String producto = sc.nextLine();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            
            Devoluciones devolucion = new Devoluciones(generarId("DE"), cliente, producto, precio);
            formularios.add(devolucion);

            System.out.println("ID de la devolución creada: " + devolucion.getId());
        }

        private static <Reclamaciones> void crearReclamacion(List<Formulario> formularios) {
            Scanner sc = new Scanner(System.in);

            System.out.println("--- Crear reclamación ---");

            System.out.print("Nombre del cliente: ");
            String cliente = sc.nextLine();

            System.out.print("Texto: ");
            String texto = sc.nextLine();

            
            Reclamaciones reclamacion = new Reclamaciones(generarId("RE"), cliente, texto, "Abierta");
            formularios.add(reclamacion);

            System.out.println("ID de la reclamación creada: " + reclamacion.getId());
        }

        private static <Reclamaciones, Formulario> void cerrarReclamacion(List<Formulario> formularios) {
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- Cerrar reclamación ---");

            System.out.print("Introduzca el ID de la reclamación: ");
            String id = scanner.nextLine();

            
            Reclamaciones reclamacion = buscarReclamacion(formularios);
        
        }

        private static <Formulario> void imprimirFormulario(List<Formulario> formularios) {
            
        }

        private static <Formulario> void imprimirTodasReclamaciones(List<Formulario> formularios) {
            
        }

        private static <Formulario> void imprimirTodos(List<Formulario> formularios) {
            
        }

        private static String generarId(String string) {
            throw new UnsupportedOperationException("Unimplemented method 'generarId'");
        }

        private static <Reclamaciones, Formulario> Reclamaciones buscarReclamacion(List<Formulario> formularios) {
            throw new UnsupportedOperationException("Unimplemented method 'buscarReclamacion'");
        }
    } 
  