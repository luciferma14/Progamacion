package POO;

public class Cafetera {
    
    private int capacidadMaxima;
    private int cantidadActual;


   public Cafetera(){
    this.capacidadMaxima = 1000;
    this.cantidadActual = 0;
   }
   public Cafetera(int capacidadMaxima){
    this.capacidadMaxima = capacidadMaxima;
    this.cantidadActual = capacidadMaxima;
   }
   public Cafetera(int capacidadMaxima, int cantidadActual){
    if (cantidadActual > capacidadMaxima){
        this.cantidadActual = capacidadMaxima;
    }else {
        this.cantidadActual = cantidadActual;
    }
   }


   public int getCapacidadMaxima(){
        return this.capacidadMaxima;
   }
   public int getCantidadActual(){
        return this.cantidadActual;
   }
   public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
   }
   public void setCantidadActual(int cantidadActual){
        this.cantidadActual = cantidadActual;
   }


   public void llenarCafetera(){
        this.cantidadActual = this.capacidadMaxima;
   }
   public void servirTaza(int capacidad){
        this.cantidadActual = capacidad;
        if (this.cantidadActual != this.capacidadMaxima){
            this.capacidadMaxima -= this.cantidadActual;
        }
   }
   public void vaciarCafetera(){
        this.cantidadActual = 0;
   }
   public void agregarCafe(int cantidad){
        this.cantidadActual += cantidad;
   }
}
