package ExExtraOrdPractica.Ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestorBiblioteca {
    public static void main(String[] args) {

        RegistroBiblioteca validar = new RegistroBiblioteca();
        
        try {
            File fL = new File("libros_in.txt");
            FileReader frL = new FileReader(fL);
            BufferedReader brL = new BufferedReader(frL);
            String lineaL;

            while((lineaL = brL.readLine()) != null) {

                String [] partesL = lineaL.split(",");

                String tit = partesL[0];
                String aut = partesL[1];
                String isbn = partesL[2];
                int aPub = Integer.parseInt(partesL[3]);
                String gen = partesL[4];

                Libro lib = new Libro(tit, aut, isbn, aPub, gen);

                validar.agregarLibro(lib);;
            }
            brL.close();
            frL.close();

            File fU = new File("usuarios_in.txt");
            FileReader frU = new FileReader(fU);
            BufferedReader brU = new BufferedReader(frU);
            String lineaU;

            while ((lineaU = brU.readLine()) != null) {

                String [] partesU = lineaU.split(",");

                String nom = partesU[0];
                String id = partesU[1];
                String email = partesU[2];
                String tel = partesU[3];

                Usuario usu = new Usuario(nom, id, email, tel);

                validar.agregarUsuario(usu);
                
            }
            brU.close();
            frU.close();

            //validar.registrarPrestamo(tit, id, fPres, fLim);
           

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
