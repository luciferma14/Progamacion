package com.proyecto;

public class Libro {

    private String titulo;
    private String autor;
    private long isbn;
    private String genero;
    private boolean disponible;
    private String isbnString;

    public Libro(String titulo, String autor, long isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.isbnString = String.valueOf(isbn);
    }

    public Libro(String titulo, String autor, long isbn, String genero, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.isbnString = String.valueOf(isbn);
        this.disponible = disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbnString() {
        return isbnString;
    }

    public void setIsbnString(String isbnString) {
        this.isbnString = isbnString;
    }

    public boolean setDisponible(boolean disponible){
        this.disponible = disponible;
        return disponible;
    }

    public boolean getDisponible(){
        return disponible;
    }

    // Comprueba la disponibilidad en un formato fácil de usar
    public String getDisponibilidadTexto() {
        return disponible ? "Si" : "No";
    }
}