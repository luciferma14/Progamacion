import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream ;

public class Saguaro {
    public static void main(String[] args) {

        try{
            File file = new File("saguaroGalaxies.TXT");

            String[] lista = file.list();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {

                String[] coma = linea.split(",");

                linea = linea.replaceAll(" ", "").replaceAll(";", ",").replaceAll("\"", " ");

                coma[2].equals("GALXY");

                System.out.println(coma[0] + " ; " + coma[3] + " ; " +  coma[4] + " ; " +  coma[5] + " ; " +  coma[6]);
               

                linea = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }




    }
}