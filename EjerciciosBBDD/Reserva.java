public class Reserva {

    private int idReserva;
    private Pasajero pasajero;
    private Vuelo vuelo;
    private String asiento;

    public Reserva(int idReserva, Pasajero pasajero, Vuelo vuelo, String asiento) {
        this.idReserva = idReserva;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.asiento = asiento;
    }
}
