package boing.objs;
import java.util.ArrayList;

public class Campo extends Objeto {

    private int dimx;
    private int dimy;

    public Campo(int dimx, int dimy) {

        super(new Posicion(1, 1), 0, 0); //Por definición un campo no tiene desplazamiento

        this.dimx = dimx;
        this.dimy = dimy;
    }

    public ArrayList<Posicion> forma() {

        ArrayList<Posicion> forma = new ArrayList<Posicion>();

        for (int x = 0; x < dimx; x++) {
            forma.add(new Posicion(x, 0));
            forma.add(new Posicion(x, dimy - 1));
        }

        for (int y = 1; y < dimy - 1; y++) {
            forma.add(new Posicion(0, y));
            forma.add(new Posicion(dimx - 1, y));
        }
        return forma;
    }

    //La colisión con un campo inmóvil tiene efectos diferentes que con uno móvil por eso se sobreescribe el método
    @Override
    public boolean colision(Objeto obj) {

        boolean colision = false;

        int dirx = obj.getDirx();
        int diry = obj.getDiry();

        for (Posicion otro : obj.ocupa()) {
            if (!colision) {
                if (otro.getX() == 1 || otro.getX() == dimx - 1) {
                    dirx = -dirx;
                    colision = true;
                }
                if (otro.getY() == 1 || otro.getY() == dimy) {
                    diry = -diry;
                    colision = true;
                }
                if (colision) {
                    obj.retrocede();
                    obj.setDirx(dirx);
                    obj.setDiry(diry);
                    obj.setColisiones(obj.getColisiones() + 1);
                    obj.avanza();
                }
            }
        }

        return colision;
    }

}