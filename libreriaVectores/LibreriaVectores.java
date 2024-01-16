package LibVectores;
import java.util.Random;

import javax.sound.sampled.SourceDataLine;

public class LibreriaVectores{

    //Genera un array de tamaño n con números aleatorios cuyo intervalo (mínimo y máximo) se indica como parámetro.
    public static int[] generaArrayInt(int num, int minimo, int maximo) {

        Random rand = new Random();

        int[] array = new int[num];

        for (int i = 0; i < num; i++){
            array[i] = rand.nextInt(maximo - minimo + 1) + minimo;
        }
        return array;
    }   

    //Devuelve el mínimo del array que se pasa como parámetro.
    public static int minimoArrayInt(int[] array) {
        
        int minimo = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] < minimo) {
                minimo = array[i];
            }
        }
        return minimo;
    }

    //Devuelve el máximo del array que se pasa como parámetro.
    public static int maximoArrayInt(int[] array) {
        
        int maximo = array[0];

        for (int i = 0; i < array.length; i++){
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }

    //Devuelve la media del array que se pasa como parámetro.
    public static double mediaArrayInt(int[] array) {

        int suma = 0;
        double media;

        for (int i = 0; i < array.length; i++) {
            suma = suma + array[i];
        }
        media = suma / array.length;

        return media;
    }

    //Dice si un número está o no dentro de un array.
    public static boolean estaEnArrayInt(int num, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == num){
                return true;
            }
        }
        return false;
    }

    //Busca un número en un array y devuelve la posición (el índice) en la que se encuentra.
    public static int posicionEnArray(int num, int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    //Le da la vuelta a un array.
    public static int[] volteaArrayInt(int[] array){

        int [] arrayVoltea = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            arrayVoltea[i] = array[array.length - 1 - i];
        }
        return arrayVoltea;
    }

}