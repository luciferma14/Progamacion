package com.proyecto;

import java.time.LocalDate;

// -----------MYSQL-----------
// CREATE TABLE reservas (
//   id_reserva INT PRIMARY KEY AUTO_INCREMENT,
//   id_libro INT NOT NULL,
//   id_usuario INT NOT NULL,
//   fecha_reserva DATE NOT NULL,
//   FOREIGN KEY (id_libro) REFERENCES libros(id),
//   FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
// );
//---------------------------------

public class Reserva {
    
    private int idLibro;
    private int idUsuario;
    private LocalDate fechaReserva;

    
    public Reserva(int idLibro, int idUsuario, LocalDate fechaReserva) {
        this.idLibro = idLibro;
        this.idUsuario = idUsuario;
        this.fechaReserva = fechaReserva;
    }


    public int getIdLibro() {
        return idLibro;
    }


    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }


    public int getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    public LocalDate getFechaReserva() {
        return fechaReserva;
    }


    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}