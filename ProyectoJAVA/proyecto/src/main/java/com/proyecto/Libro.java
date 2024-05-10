package com.proyecto;

public class Libro {

    private String titulo;
    private String autor;
    private long isbn;
    private String genero;
    private String isbnString;

    public Libro(String titulo, String autor, long isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.isbnString = String.valueOf(isbn);
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
}