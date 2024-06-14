package com.proyecto;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * Controlador para manejar la navegación entre diferentes ventanas de la aplicación.
 */
public class busResPresDevController {

    /**
     * Cierra la sesión actual y vuelve a la primera ventana.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cerrarSesion() throws IOException {
        App.setRoot("primeraVentana");
    }

    /**
     * Cambia a la ventana de búsqueda de libros.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaABuscar() throws IOException {
        App.setRoot("ventanaBuscar");
    }

    /**
     * Cambia a la ventana de reserva de libros.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaAReservar() throws IOException {
        App.setRoot("ventanaReservar");
    }

    /**
     * Cambia a la ventana de préstamo de libros.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaAPrestar() throws IOException {
        App.setRoot("ventanaPrestar");
    }

    /**
     * Cambia a la ventana de devolución de libros.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaADevolver() throws IOException {
        App.setRoot("ventanaDevolver");
    }

    /**
     * Cambia a la primera ventana de la aplicación.
     * 
     * @throws IOException si ocurre un error al cambiar la ventana.
     */
    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }
}
