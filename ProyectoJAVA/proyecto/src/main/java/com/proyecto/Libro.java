package com.proyecto;

import javafx.scene.control.TableColumn;

public class Libro {

    private String titulo;
    private String autor;
    private int isbn;
    private String genero;

    public Libro(String titulo2, String autor2, int isbn2, String genero2) {
        this.titulo = titulo2;
        this.autor = autor2;
        this.isbn = isbn2;
        this.genero = genero2;
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
