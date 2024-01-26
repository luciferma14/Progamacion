package ProgOrienObj;

import java.util.Scanner;

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
   public int setCapacidadMaxima(){
    return this.capacidadMaxima;
   }
   public int setCantidadActual(){
    return this.cantidadActual;
   }

   public void llenarCafetera(int capacidad){
    this.cantidadActual = capacidad;
   }
   public void servirTaza(){
    
   }
   public void vaciarCafetera(int cantidadActual){
    this.cantidadActual = 0;
   }
   public void agregarCafe(int cantidad){
    this.cantidadActual += cantidad;
   }
}
