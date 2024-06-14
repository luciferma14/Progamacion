package boing.objs;
import java.util.ArrayList;

public class Triangulo extends Objeto {

    public Triangulo(Posicion pos, int dirx, int diry) {

        super(pos, dirx, diry);


    }
    public ArrayList<Posicion> forma() {

        ArrayList<Posicion> forma = new ArrayList<Posicion>();
        forma.add(new Posicion(2, 0));

        forma.add(new Posicion(1,1));
        forma.add(new Posicion(2,1));
        forma.add(new Posicion(3,1));

        forma.add(new Posicion(0,2));
        forma.add(new Posicion(1,2));
        forma.add(new Posicion(2,2));
        forma.add(new Posicion(3,2));
        forma.add(new Posicion(4,2));

        return forma;

    }


}