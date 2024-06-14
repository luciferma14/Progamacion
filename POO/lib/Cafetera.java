package lib;

public class Cafetera {
     
    private int capacidadMaxima;
    private int cantidadActual;


   public Cafetera(){
    this.capacidadMaxima = 1000;
    this.cantidadActual = 0;
   }
   public Cafetera(int a_capacidadMaxima){
    this.capacidadMaxima = a_capacidadMaxima;
    this.cantidadActual = a_capacidadMaxima;
   }
   public Cafetera(int a_capacidadMaxima, int a_cantidadActual){
    if (cantidadActual > capacidadMaxima){
        this.cantidadActual = a_capacidadMaxima;
        this.capacidadMaxima = a_capacidadMaxima;
    }else {
        this.cantidadActual = a_cantidadActual;
        this.capacidadMaxima = a_capacidadMaxima;
    }
   }


   public int getCapacidadMaxima(){
        return this.capacidadMaxima;
   }
   public int getCantidadActual(){
        return this.cantidadActual;
   }
   public void setCapacidadMaxima(int a_capacidadMaxima){
        this.capacidadMaxima = a_capacidadMaxima;
   }
   public void setCantidadActual(int a_cantidadActual){
        this.cantidadActual = a_cantidadActual;
   }


   public void llenarCafetera(){
        this.cantidadActual = this.capacidadMaxima;
   }
   public int servirTaza(int capacidad){
     if (capacidad > cantidadActual){
          int cantActual = cantidadActual;
          this.cantidadActual = 0;
          return cantActual;
     }else {
          this.cantidadActual -= capacidad;
          return capacidad;
     }
   } 
   public void vaciarCafetera(){
        this.cantidadActual = 0;
   }
   public void agregarCafe(int cantidad){
        this.cantidadActual += cantidad;
   }
}
