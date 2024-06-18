package ExamenExtraOrd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import javax.naming.ldap.HasControls;

public class Informe_rutas{


    static class Avion{
        private String codAvion;
        private String nombre;
        private int alcance;


        private void Avion(String codAvion, String nombre, int alcance){
            this.codAvion = codAvion;
            this.nombre = nombre;
            this.alcance = alcance;
        }
    }

    static class Aeropuerto{
        private String codAeropuerto;
        private String nombre;
        private String codCiudad;
        private String ciudad;
        private long lon;
        private long lat;

        private void Aeropuerto(String codAeropuerto, String nombre, String codCiudad, String ciudad,long lon, lon lat){
            this.codAeropuerto = codAeropuerto;
            this.nombre = nombre;
            this.codCiudad = codCiudad;
            this.ciudad = ciudad;
            this.lon = lon;
            this.lat = lat;
        }
    }

    static class Aviones_Aeropuerto{
        private String codAeropuerto;
        private String codAvion;

        private void Aviones_Aeropuerto(String codAeropuerto, String codAvion){
            this.codAeropuerto = codAeropuerto;
            this.codAvion = codAvion;
        }
    }

    static void leerAviones(){
        HashMap<String, Avion> listaAviones = new HashMap<String, Avion>();
        try {
            File f = new File("aviones.cvs");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine(); 
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

    public static void main(String[] args) {
        
        HashMap<String, Avion> aviones = leerAviones();




    }
}