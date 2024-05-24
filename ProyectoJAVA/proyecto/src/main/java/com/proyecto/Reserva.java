package com.proyecto;

public class Reserva {
    private int idLibro;
    private String titulo;
    private String usuario;
    private String fechaReserva;

    public Reserva(int idLibro, String titulo, String usuario, String fechaReserva) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.usuario = usuario;
        this.fechaReserva = fechaReserva;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
