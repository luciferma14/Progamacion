import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialAmi {
    public static void main(String[] args) {
        File f = new File("amigos.txt");
        // SERIALIZAMOS OBJETOS
        try {
            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            Amigo a = new Amigo("Pedro Perez", "612345678");
            oos.writeObject(a);
            Amigo a1 = new Amigo("Ana Arnau", "698765432");
            oos.writeObject(a1);
            oos.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}