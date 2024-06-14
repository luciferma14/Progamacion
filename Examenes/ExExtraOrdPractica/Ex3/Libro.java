package ExExtraOrdPractica.Ex3;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private String genero;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn, int anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.prestado = false;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public String getGenero() { return genero; }
    public boolean isPrestado() { return prestado; }
    public void setPrestado(boolean prestado) { this.prestado = prestado; }

    public boolean validar() {
        return ValidacionesLibro.validarLibro(this);
    }
}
