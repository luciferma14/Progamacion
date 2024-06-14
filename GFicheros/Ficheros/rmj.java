import java.io.File;
import java.io.IOException;

public class Rmj {

    public static void main(String[] args) {

        File file = new File( args[0]);

        if (!file.exists()) {
            System.out.println("El fichero no existe.");
            System.exit(1);
        }

        if (file.isDirectory()) {
            System.out.println("El fichero es un directorio.");
            System.exit(1);
        }

        try {
            if (file.delete()) {
                System.out.println("El fichero ha sido borrado.");
            } else {
                System.out.println("No se pudo borrar el fichero.");
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}