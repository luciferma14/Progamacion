package com.proyecto;

/**
 * Clase para la creación de las reservas de la biblioteca.
 */
public class Reserva {
    
    private int idLibro;
    private int idUsuario;
    private String titulo;
    private String usuario;
    private String fechaReserva;
    

    /**
     * Constructor para crear un objeto Reservas.
     * 
     * @param idLibro
     * @param idUsuario
     * @param fechaReserva
     */
    public Reserva(String titulo, String usuario, String fechaReserva) {
        this.titulo = titulo;
        this.usuario = usuario;
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
     * Obtiene el título del libro prestado.
     * 
     * @return el título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro prestado.
     * 
     * @param titulo el nuevo título del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el usuario que ha reservado el libro.
     * 
     * @return el usuario que reservó el libro
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que ha reservado el libro.
     * 
     * @param usuario el nuevo usuario que reservó el libro
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la fecha en que se ha reservado el libro.
     * 
     * @return la fecha de la reserva
     */
    public String getFechaReseva() {
        return fechaReserva;
    }

    /**
     * Establece la fecha en que se ha prestado el libro.
     * 
     * @param fechaReserva la nueva fecha del préstamo
     */
    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    
}