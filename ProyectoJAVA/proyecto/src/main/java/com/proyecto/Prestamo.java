package com.proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Prestamo {
    
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;


    public Prestamo(Libro libro, Usuario usuario, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null; 
    }


    public Prestamo(String titulo, String usuarioPrestador, String fechaPrestamo2) {
        //TODO Auto-generated constructor stub
    }


    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    public void registrarPrestamo(Connection con) throws SQLException {

        String query = "INSERT INTO prestamos (idLibro, idUsuario, fecha_prestamo) VALUES (?, ?,CURRENT_DATE())";
        PreparedStatement st = con.prepareStatement(query);
        st.setLong(1, libro.getIdLibro());
        st.setInt(2, usuario.getIdUsuario());
        st.executeUpdate();
        st.close();

        String updateQuery = "UPDATE libros SET Disponible = false WHERE ISBN = ?";
        st = con.prepareStatement(updateQuery);
        st.setLong(1, libro.getIsbn());
        st.executeUpdate();
        st.close();
    }


    public String getTitulo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTitulo'");
    }
    
}
