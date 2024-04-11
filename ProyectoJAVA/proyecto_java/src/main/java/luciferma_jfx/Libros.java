package luciferma_jfx;
import java.util.List;

public class Libros {
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;

    public static List<Libros>buscar(String criterio){

        //Consultar en la base de datos los libros que coincidan con el criterio
        return null; //De momento
    }

    public void reservar(){

        //Marcar el libro como reservado en la base de datos
    }

    public void prestar(Usuarios usuario){

        //Registrar el préstamo del libro al usuario en la base de datos
    }

    public void devolver(){

        //Registrar la devolución del libro en la base de datos
    }
}