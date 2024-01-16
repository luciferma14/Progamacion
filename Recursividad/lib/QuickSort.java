package Recursividad.lib;

import java.util.Arrays;

public class QuickSort {

    public static int quickSort(int[] arr, int i, int j) {

        int izquierda = ' ';
        int derecha = ' ';
        int indiceParticion = ' ';

        if (izquierda < derecha) {
            indiceParticion = particion(arr, izquierda, derecha);

            quickSort(arr, izquierda, indiceParticion - 1);
            quickSort(arr, indiceParticion + 1, derecha);
        }
        return indiceParticion;
    }

    public static int particion(int[] arr, int izquierda, int derecha) {
        int pivote;
        int i;

        pivote = arr[derecha];
        i = izquierda - 1;

        for (int j = izquierda; j < derecha; j++) {
            if (arr[j] <= pivote) {
                i++;
                intercambiar(arr, i, j);
            }
        }

        intercambiar(arr, i + 1, derecha);

        return i + 1;
    }

    public static void intercambiar(int[] arr, int i, int j) {
        int temp;

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
