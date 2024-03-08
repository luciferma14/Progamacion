import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroChar{
    public static void main(String[] args) {
        try {
                File f = new File(args[0]);
                FileReader fr = new FileReader(f);
                int letra = fr.read(); 
                System.out.println();
                while(letra != -1) {
                    System.out.print((char)letra);
                    letra = fr.read();
                }
                System.out.println();
                fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    }
}