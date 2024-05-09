package com.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private String genero;

    @FXML
    private TextField FTitulo;
    @FXML
    private TextField FAutor;
    @FXML
    private TextField FISBN;
    @FXML
    private TextField FGenero;

    public Libro(String titulo, String autor, String isbn, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
    }

    public Libro(TextField FTitulo, TextField FAutor, TextField FISBN, TextField FGenero) {
        this.FTitulo = FTitulo;
        this.FAutor = FAutor;
        this.FISBN = FISBN;
        this.FGenero = FGenero;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
