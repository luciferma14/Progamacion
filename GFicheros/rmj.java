import java.io.File;

public class Rmj {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java rmj <file>");
            System.exit(1);
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.err.println("Error: File does not exist.");
            System.exit(2);
        }

        if (file.isDirectory()) {
            System.err.println("Error: Cannot delete a directory.");
            System.exit(3);
        }

        if (!file.delete()) {
            System.err.println("Error: Unable to delete file.");
            System.exit(4);
        }

        System.out.println("File deleted successfully.");
    }
}