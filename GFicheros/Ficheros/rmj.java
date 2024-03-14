import java.io.File;

public class rmj {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java rmj <file>");
            System.exit(1);
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.err.println("Error: fichero no existe");
            System.exit(2);
        }

        if (file.isDirectory()) {
            System.err.println("Error: no se puede borrar el directorio");
            System.exit(3);
        }

        if (!file.delete()) {
            System.err.println("Error: no se puede borrar el fichero");
            System.exit(4);
        }

        System.out.println("Fichero borrado");
    }
}