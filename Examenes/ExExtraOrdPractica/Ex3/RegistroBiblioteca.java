package ExExtraOrdPractica.Ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroBiblioteca {
    private List<Libro> libros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<String> prestamos = new ArrayList<>();
    private List<String> devoluciones = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        if (libro.validar()) {
            libros.add(libro);
            registrarLibroValido(libro);
        } else {
            registrarError("Libro", libro.getTitulo() + "," + libro.getAutor() + "," + libro.getIsbn() + "," + libro.getAnioPublicacion() + "," + libro.getGenero(), "Datos inválidos");
        }
    }

    public void agregarUsuario(Usuario usuario) {
        if (usuario.validar()) {
            usuarios.add(usuario);
            registrarUsuarioValido(usuario);
        } else {
            registrarError("Usuario", usuario.getNombre() + "," + usuario.getIdUsuario() + "," + usuario.getEmail() + "," + usuario.getTelefono(), "Datos inválidos");
        }
    }

    public void registrarPrestamo(String titulo, String idUsuario, String fechaPrestamo, String fechaLimite) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && !libro.isPrestado() && buscarUsuario(idUsuario) != null) {
            libro.setPrestado(true);
            String prestamo = "Préstamo: " + titulo + " - " + idUsuario + " - " + fechaPrestamo + " - " + fechaLimite;
            prestamos.add(prestamo);
            registrarPrestamoValido(prestamo);
        } else {
            registrarError("Préstamo", titulo + "," + idUsuario + "," + fechaPrestamo + "," + fechaLimite, "Préstamo inválido");
        }
    }

    public void registrarDevolucion(String titulo, String idUsuario, String fechaDevolucion) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && libro.isPrestado() && buscarUsuario(idUsuario) != null) {
            libro.setPrestado(false);
            String devolucion = "Devolución: " + titulo + " - " + idUsuario + " - " + fechaDevolucion;
            devoluciones.add(devolucion);
            registrarDevolucionValida(devolucion);
        } else {
            registrarError("Devolución", titulo + "," + idUsuario + "," + fechaDevolucion, "Devolución inválida");
        }
    }

    private Libro buscarLibro(String titulo) {
        return libros.stream().filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo)).findFirst().orElse(null);
    }

    private Usuario buscarUsuario(String idUsuario) {
        return usuarios.stream().filter(usuario -> usuario.getIdUsuario().equalsIgnoreCase(idUsuario)).findFirst().orElse(null);
    }

    private void registrarLibroValido(Libro libro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("libros_validos.txt", true))) {
            writer.write("Libro: " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn() + " - " + libro.getAnioPublicacion() + " - " + libro.getGenero());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarUsuarioValido(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios_validos.txt", true))) {
            writer.write("Usuario: " + usuario.getNombre() + " - " + usuario.getIdUsuario() + " - " + usuario.getEmail() + " - " + usuario.getTelefono());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarPrestamoValido(String prestamo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prestamos.txt", true))) {
            writer.write(prestamo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarDevolucionValida(String devolucion) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("devoluciones.txt", true))) {
            writer.write(devolucion);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarError(String tipo, String datos, String mensaje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("errores.log", true))) {
            writer.write("Error en " + tipo + ": " + datos + " - " + mensaje);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
