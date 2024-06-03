import java.util.ArrayList;
import java.util.HashMap;

public class Calculos {
    
    public static ArrayList<String> calcular(String ref, int m3) throws Exception{

        double precioTotal = 0 ;
        double unidades = 0 ;
        double precioM3 = 0 ;
        HashMap<String,Tablon> lista = new HashMap<>();
        Tablon tablonRef = lista.get(ref);

        int largo = tablonRef.largo;
        int ancho = tablonRef.ancho;
        int alto = tablonRef.alto;
        double precio = tablonRef.precio;

        if(largo*ancho*alto == 0){
            throw new Exception("No se puede dividir por 0");
        }

        unidades = ((double) m3 * 1000000000) / ((largo*ancho*alto));
        precioTotal = unidades * precio;
        precioM3 = precioTotal / m3;

        if(m3 <= 0){
            throw new Exception("El valor de m3 debe ser mayor a 0");
        }

        ArrayList<String> salida = new ArrayList<String>();

        salida.add("Precio Total: " + precioTotal + "€");
        salida.add("Unidades necesarias: " + (int)unidades);
        salida.add("Precio por m3: " + precioM3 + "€");
        
        return salida;
    }

    public static boolean esta(String ref) throws Exception {

        HashMap<String,Tablon> lista = Catalogo.listado();
        Tablon tablonRef = lista.get(ref);

        if(tablonRef == null){
            throw new Exception("No existe el tablón con referencia " + ref);
        }

        return true;
    }
}
