package boing.objs;
import java.util.ArrayList;
public abstract class Objeto extends Object{

    private static int n_objetos;
    private int id; //Identificador único del objeto
    private Posicion pos; //Posición de su esquina superior izquierda según la pantalla (0,0 sería la esquina superior izquierda de la pantalla)
    private int dirx; //Dirección en X (1 se desplaza a derecha, -1 se desplaza a izquierda, 0 no se mueve en horizontal)
    private int diry; //Dirección en Y (1 se desplaza hacia abajo, -1 se desplaza hacia arriba, 0 no se desplaza en vertical)
    private static int colisiones;

    //Cada Objeto que herede este clase abstracta tiene que definir su forma
    public abstract ArrayList<Posicion> forma();

    public Objeto() {

    }

    //Método básico de creación del Objeto (Poosición y dirección inicial)
    public Objeto(Posicion pos, int dirx, int diry) {
        this.pos = new Posicion(pos);
        this.dirx = dirx;
        this.diry = diry;
        n_objetos++;
        this.id = n_objetos;
    }

    //Devuelve un ArrayList con las Posiciones actuales del Objeto
    public ArrayList<Posicion> ocupa() {
        ArrayList<Posicion> ocupa = new ArrayList<Posicion>();

        for (Posicion pos : forma()) {
            ocupa.add(new Posicion(pos.getX() + this.pos.getX(), pos.getY() + this.pos.getY()));
        }
        return ocupa;
    }


    
    //Controla la colision entre el Objeto y otro Objeto.
    public boolean colision(Objeto obj) {
        boolean colision = false;

        for (Posicion yo : ocupa()) {
            for (Posicion otro : obj.ocupa()) {
                if (yo.equals(otro) && !colision) {

                    //En caso de colisión, se hace retroceder al objeto y se recalcula trayectoria
                    retrocede();
                    obj.retrocede();

                    if (dirx * obj.dirx <= 0) {
                        dirx *= -1;
                        obj.dirx *= -1;
                    }
                    if (diry * obj.diry <= 0) {
                        diry *= -1;
                        obj.diry *= -1;
                    }

                    //Se havce avanzar los dos objetos tras la colisión con la nueva trayectoria
                    avanza();
                    obj.avanza();

                    colision = true;
                    colisiones++;
                    obj.colisiones++;

                }
            }
        }
        return colision;
    }
    

    //Método para hacer avanzar al objeto
    public void avanza() {
        this.pos.setX(this.pos.getX() + dirx);
        this.pos.setY(this.pos.getY() + diry);
    }

    //Método para hacer retroceder al objeto
    public void retrocede() {
        this.pos.setX(this.pos.getX() - dirx);
        this.pos.setY(this.pos.getY() - diry);
    }

    public int getColisiones() {
        return colisiones;
    }

    public void setColisiones(int colisiones) {
        this.colisiones = colisiones;
    }

    public int getDirx() {
        return dirx;
    }

    public void setDirx(int dirx) {
        this.dirx = dirx;
    }

    public int getDiry() {
        return diry;
    }

    public void setDiry(int diry) {
        this.diry = diry;
    }

    public int getId() {
        return this.id;
    }
    

}