package boing;
import boing.objs.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class Boing {

    private static ArrayList<Objeto> objs = new ArrayList<Objeto>();
    private static TreeSet<Posicion> campo = new TreeSet<Posicion>();

    public int colisionTriang(Object Triangulo) {
        int colisiones = 0;
        boolean colision = false;
        if (colision = true){
        }
        return colisiones;
    }

    

    private static void pintaCampo() {

        int x = 0; //Coordenada X que se está tratando
        int y = 0; //Coordenada Y 
        int lf = 0; //Retornos de carro necesarios
        int sp = 0; //Espacions en blanco necesarios

        System.out.print("\033[H\033[2J");
        campo.clear();

        //Recopilar todas las posiciones ocupadas en el instante actual
        for (Objeto obj : objs) {
            for (Posicion pos : obj.ocupa()) {
                campo.add(pos);
            }
        }
        

        //Pintar las posiciones en pantalla
        for (Posicion pos : campo) {
            lf = pos.getY() - y; //Control de saltos de linea
            if (lf > 0) {
                for (int i = 0; i < lf; i++) {
                    System.out.println();
                }
                x = 0;
            }
            y = pos.getY();
            sp = pos.getX() - x; //Control de espacios en blanco
            for (int i = 0; i < sp - 1; i++) {
                System.out.print(" ");
            }
            x = pos.getX();
            System.out.print("*");

        }
        System.out.println();
    }
    ////////////////////////////////////
    //Método principal (Hay que pasarle un Objeto Campo y un ArrayList de Objetos que se muevan)
    ///////////////////////////////////
    public static void boing(Campo camp, ArrayList<Objeto> objetos) {

        objs.add(camp);

        for (Objeto obj : objetos) objs.add(obj);

        while (true) {

            pintaCampo();

            // Pausa
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }

            // Avanza Objetos
            for (Objeto obj : objs)
                obj.avanza();

            // Control colisiones
            for (int i = 1; i < objs.size(); i++) {
                //Colisión con el campo
                camp.colision(objs.get(i));
                //Colisión con los objetos
                for (int j = 1 + i; j < objs.size(); j++) {
                    objs.get(i).colision(objs.get(j));
                }
            }

        }

    }

}
