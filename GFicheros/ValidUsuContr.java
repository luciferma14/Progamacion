import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ValidUsuContr {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String usu;
        String contr;
        Boolean salir = true;

        while (salir) {

            try {

                System.out.print("Usuario: ");
                usu = sc.nextLine();

                if (usu.equals("Salir")) {
                    salir = false;
                    System.exit(0);
                }
                System.out.print("Contraseña: ");
                contr = sc.nextLine();

                FileReader lector = new FileReader("fichero3.txt");
                BufferedReader lectorLinea = new BufferedReader(lector);
                String linea = lectorLinea.readLine();

                while (linea != null) {

                    String[] dosPuntos = linea.split(":");

                    if (dosPuntos[0].equals(usu)) {

                        if (dosPuntos[1].equals(contr)) {
                            System.out.println("Usuarios contraseña coincide");

                        } else {
                            System.out.println("NO existe contraseña");
                        }

                    } else {
                        System.out.println("NO existe usuario");
                    }

                    linea = lectorLinea.readLine();
                }

            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }
}