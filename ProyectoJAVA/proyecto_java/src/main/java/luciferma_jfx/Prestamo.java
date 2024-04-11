package luciferma_jfx;

import java.util.Date;
import java.util.List;

public class Prestamo{
    private int id;
    private Libros libro;
    private Usuarios usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public static List<Prestamo> obtenerPrestActivos(Usuarios usuario){
        //Consultar en la base de datos los préstamos activos del usuario 
        return null; //de momento
    }

    public void renovar(){
        //Actualizar la fecha de los préstamos en la base de datos
    }

    public void cancelar(){
        //Eliminar el préstamo de la base de datos
    }
}