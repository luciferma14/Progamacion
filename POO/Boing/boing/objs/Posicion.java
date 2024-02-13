//Clase de defición de lo que es una posición
//Implemenenta la compración y la igualdad
package boing.objs;
public class Posicion implements Comparable<Posicion> {
    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion(Posicion pos) {
        this.x = pos.getX();
        this.y = pos.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Posicion pos) {

        return this.x == pos.getX() && this.y == pos.getY();

    }

    public int compareTo(Posicion otro) {

        int salida = 0;

        if (this.y < otro.y)
            salida = -1;
        else if (this.y > otro.y)
            salida = 1;
        else if (this.x < otro.x)
            salida = -1;
        else if (this.x > otro.x)
            salida = 1;
        else
            salida = 0;

        return salida;

    }

    public String toString() {
        return x + " " + y;
    }

}