import java.sql.Date;

public class Vuelo {

    private int idVuelo;
    private String numeroVuelo;
    private String origen;
    private String destino;
    private Date fecha;
    private int capacidad;

    public Vuelo(int idVuelo, String numeroVuelo, String origen, String destino, Date fecha, int capacidad) {
        
        this.idVuelo = idVuelo;
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.capacidad = capacidad;

    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    
}
