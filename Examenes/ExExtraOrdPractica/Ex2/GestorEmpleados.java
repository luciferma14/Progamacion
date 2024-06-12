package ExExtraOrdPractica.Ex2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestorEmpleados {

    public static void main(String[] args) {

        RegistroEmpleados regEmpl = new RegistroEmpleados();
        
        try {
            File f = new File("empleados_in.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;  //fr.read(), para un caracter
            
            while((linea = br.readLine()) != null) {

                String [] partes = linea.split(",");

                String nom = partes[0];
                int edad = Integer.parseInt(partes[1]);
                int sal = Integer.parseInt(partes[2]);
                String dep = partes[3];

                Empleado emp = new Empleado(nom, edad, sal, dep);

                regEmpl.agregarEmpleado(emp);



            }
            br.close();
            fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
    }
    
}
