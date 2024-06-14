import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Amigos {
    public static void main(String[] args) {
        File f = new File("amigos.bin");

        try {
            FileOutputStream fs = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fs);

            Amigo a = new Amigo ("Lucía", "601949124");
            Amigo b = new Amigo ("Álvaro", "689416326");

            oos.writeObject(a);
            oos.writeObject(b);

            oos.close();
            fs.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
