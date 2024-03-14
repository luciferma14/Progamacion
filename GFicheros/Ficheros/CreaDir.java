import java.io.File;
import java.io.IOException;

public class CreaDir{
    public static void main(String[] args) {
    
        try {
            File directorio = new File("dirPruebas");
            if (directorio.mkdir()){
                System.out.println("Directorio creado: " + directorio.getName());     
            }else {
                System.out.println("El Directorio ya existe");
            }
        }catch (Exception e){
            System.out.println("Error: no se pudo crear el Directorio");
        }
    }
}