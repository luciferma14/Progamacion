package com.proyecto;

import java.time.LocalDate;

/**
 * Clase para la creación de las reservas de la biblioteca.
 */
public class Reserva {
    
    private int idLibro;
    private int idUsuario;
    private LocalDate fechaReserva;

    /**
     * Constructor para crear un objeto Reservas.
     * 
     * @param idLibro
     * @param idUsuario
     * @param fechaReserva
     */
    public Reserva(int idLibro, int idUsuario, LocalDate fechaReserva) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
    }

    /**
     * Obtiene el id del libro resevado.
     * 
     * @return el id del libro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Obtiene el id del usuario.
     * 
     * @return el id del usuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el id del usuario.
     * 
     * @param idUsuario el id del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene la feche de la reserva.
     * 
     * @return la fecha de la reserva
     */
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Estblece la fecha de la reserva.
     * 
     * @param fechaReserva la fecha de la reserva
     */
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}