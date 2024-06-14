public class Pasajero {

    int id_pasajero;
    String numero_pasaporte;
    String nombre_pasajero;

    public Pasajero (int id_pasajero, String numero_pasaporte, String nombre_pasajero){
        this.id_pasajero = id_pasajero;
        this.numero_pasaporte = numero_pasaporte;
        this.nombre_pasajero = nombre_pasajero;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }
}