import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeeFich{
    public static void main(String[] args) {
        try {
                File f = new File("fichero.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine(); //fr.read(), para un caracter
                System.out.println();
                while(linea != null) {
                    System.out.println(linea);
                    linea = br.readLine();
                }
                br.close();
                fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    }
}