package ExExtraOrdPractica.Ex3;

import java.time.LocalDate;

public class ValidacionesLibro {
    public static boolean validarLibro(Libro libro) {
        if (libro.getTitulo().isEmpty()) return false;
        if (libro.getAutor().isEmpty()) return false;
        if (!libro.getIsbn().matches("\\d{13}")) return false;
        int anio = libro.getAnioPublicacion();
        if (anio < 1900 || anio > LocalDate.now().getYear()) return false;
        if (!libro.getGenero().equalsIgnoreCase("Ficción") &&
            !libro.getGenero().equalsIgnoreCase("No Ficción") &&
            !libro.getGenero().equalsIgnoreCase("Educativo") &&
            !libro.getGenero().equalsIgnoreCase("Científico") &&
            !libro.getGenero().equalsIgnoreCase("Biográfico")) return false;
        return true;
    }
}
