package com.proyecto;

public class Prestamo {
    
    private String titulo;
    private String usuarioPrestador;
    private String fechaPrestamo;
    private int idLibro;

 

    public Prestamo(String titulo, String usuarioPrestador, String fechaPrestamo) {
        this.titulo = titulo;
        this.usuarioPrestador = usuarioPrestador;
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUsuarioPrestador() {
        return usuarioPrestador;
    }

    public void setUsuarioPrestador(String usuarioPrestador) {
        this.usuarioPrestador = usuarioPrestador;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public long getIdLibro() {
        return idLibro;
    }
}
