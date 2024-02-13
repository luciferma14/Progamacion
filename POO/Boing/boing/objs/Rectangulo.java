package boing.objs;
import java.util.ArrayList;

public class Rectangulo extends Objeto {

    public Rectangulo(Posicion pos, int dirx, int diry) {

        super(pos, dirx, diry);

    }

    public ArrayList<Posicion> forma() {

        ArrayList<Posicion> forma = new ArrayList<Posicion>();

        forma.add(new Posicion(0, 0));
        forma.add(new Posicion(0, 1));
        forma.add(new Posicion(0, 2));
        forma.add(new Posicion(1, 0));
        forma.add(new Posicion(1, 1));
        forma.add(new Posicion(1, 2));
        return forma;

    }

}