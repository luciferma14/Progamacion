package boing.objs;
import java.util.ArrayList;

public class Cuadrado extends Objeto {

    public Cuadrado(Posicion pos, int dirx, int diry) {

        super(pos, dirx, diry);

    }

    public ArrayList<Posicion> forma() {

        ArrayList<Posicion> forma = new ArrayList<Posicion>();

        forma.add(new Posicion(0, 0));
        forma.add(new Posicion(0, 1));
        forma.add(new Posicion(1, 0));
        forma.add(new Posicion(1, 1));

        return forma;

    }

}