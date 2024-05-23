package com.proyecto;

/**
 * Clase que representa un préstamo de un libro en la biblioteca.
 */
public class Prestamo {

    private String titulo;
    private String usuarioPrestador;
    private String fechaPrestamo;
    private int idLibro;

    /**
     * Constructor para crear un objeto Prestamo.
     * 
     * @param titulo           el título del libro prestado
     * @param usuarioPrestador el usuario que prestó el libro
     * @param fechaPrestamo    la fecha en que se prestó el libro
     */
    public Prestamo(String titulo, String usuarioPrestador, String fechaPrestamo) {
        this.titulo = titulo;
        this.usuarioPrestador = usuarioPrestador;
        this.fechaPrestamo = fechaPrestamo;
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
     * Obtiene el usuario que ha prestado el libro.
     * 
     * @return el usuario que prestó el libro
     */
    public String getUsuarioPrestador() {
        return usuarioPrestador;
    }

    /**
     * Establece el usuario que ha prestado el libro.
     * 
     * @param usuarioPrestador el nuevo usuario que prestó el libro
     */
    public void setUsuarioPrestador(String usuarioPrestador) {
        this.usuarioPrestador = usuarioPrestador;
    }

    /**
     * Obtiene la fecha en que se ha prestado el libro.
     * 
     * @return la fecha del préstamo
     */
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Establece la fecha en que se ha prestado el libro.
     * 
     * @param fechaPrestamo la nueva fecha del préstamo
     */
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Obtiene el ID del libro prestado.
     * 
     * @return el ID del libro
     */
    public int getIdLibro() {
        return idLibro;
    }
}
