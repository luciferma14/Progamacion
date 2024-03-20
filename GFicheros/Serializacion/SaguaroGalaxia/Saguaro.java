import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Saguaro {
    public static void main(String[] args) {

        try{
            File file = new File("saguaroGalaxies.TXT");

            String[] lista = file.list();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            String[] coma;

            String object;
            String type;
            String con;
            String ra;
            String dec;
            String mag;

            File nuevo = new File("sag.bin");
            FileOutputStream fos = new FileOutputStream(nuevo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            while (linea != null) {

                coma = linea.split(",");

                type = coma[2].replace("\"","");

                linea = linea.replace(" ", "").replace(";", ",").replace("\"", " ");

                if (type.equals("GALXY")){

                    object = coma[0];
                    con = coma[3];
                    ra = coma[4];
                    dec = coma[5];
                    mag = coma[6];
                    Galaxia galaxy = new Galaxia(object, con, ra, dec, mag);
                    oos.writeObject(galaxy);
                }
                linea = br.readLine();
            }
            oos.close();
            fos.close();
            br.close();
            fr.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}