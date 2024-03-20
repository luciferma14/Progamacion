import java.io.File;

public class FileChecker {
    public static void main(String[] args) {

        File file = new File(args[0]);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Es un directorio");
                System.out.println("Path Absoluto: " + file.getAbsolutePath());
            } else if (file.isFile()) {
                System.out.println("Es un fichero");
                System.out.println("Path Absoluto: " + file.getAbsolutePath());
                System.out.println("Tamaño: " + file.length() + " bytes");
                System.out.println("Permisos: " + file.canRead() + " " + file.canWrite() + " " + file.canExecute());
            }
        } else {
            System.out.println("File or directory does not exist.");
        }
    }
}