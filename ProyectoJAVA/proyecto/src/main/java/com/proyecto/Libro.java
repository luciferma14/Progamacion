package com.proyecto;

/**
 * Clase que representa un libro en la biblioteca.
 */
public class Libro {

    private int idLibro;
    private String titulo;
    private String autor;
    private long isbn;
    private String genero;
    private String disponible;
    private String isbnString;

    /**
     * Constructor para crear un libro sin especificar disponibilidad e ID.
     * 
     * @param titulo  el título del libro
     * @param autor   el autor del libro
     * @param isbn    el ISBN del libro
     * @param genero  el género del libro
     */
    public Libro(String titulo, String autor, long isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.isbnString = String.valueOf(isbn);
    }

    /**
     * Constructor para crear un libro especificando disponibilidad e ID.
     * 
     * @param titulo      el título del libro
     * @param autor       el autor del libro
     * @param isbn        el ISBN del libro
     * @param genero      el género del libro
     * @param disponible  la disponibilidad del libro
     * @param idLibro     el ID del libro
     */
    public Libro(String titulo, String autor, long isbn, String genero, String disponible, int idLibro) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.isbnString = String.valueOf(isbn);
        this.disponible = disponible;
    }

    /**
     * Obtiene el ID del libro.
     * 
     * @return el ID del libro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Obtiene el título del libro.
     * 
     * @return el título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     * 
     * @param titulo el nuevo título del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     * 
     * @return el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     * 
     * @param autor el nuevo autor del libro
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el ISBN del libro.
     * 
     * @return el ISBN del libro
     */
    public long getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     * 
     * @param isbn el nuevo ISBN del libro
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el género del libro.
     * 
     * @return el género del libro
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género del libro.
     * 
     * @param genero el nuevo género del libro
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el ISBN del libro en formato de cadena.
     * 
     * @return el ISBN del libro en formato de cadena
     */
    public String getIsbnString() {
        return isbnString;
    }

    /**
     * Establece el ISBN del libro en formato de cadena.
     * 
     * @param isbnString el nuevo ISBN del libro en formato de cadena
     */
    public void setIsbnString(String isbnString) {
        this.isbnString = isbnString;
    }

    /**
     * Establece si un libro está disponible del libro.
     * 
     * @param disponible la nueva disponibilidad del libro
     * @return la disponibilidad establecida
     */
    public String setDisponible(String disponible) {
        this.disponible = disponible;
        return disponible;
    }

    /**
     * Obtiene la disponibilidad del libro.
     * 
     * @return la disponibilidad del libro
     */
    public String getDisponible() {
        return disponible;
    }
}