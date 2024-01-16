import libreria.Vector;
import java.util.Arrays;

public class PruebaLibreriaV {
    public static void main(String[] args) {
        String[] vectorS;
        //Llamamos a la función para rellenar el vector
        vectorS=Vector.rellenaVectorStr(5);
        System.out.println(Arrays.toString(vectorS));
    }
}