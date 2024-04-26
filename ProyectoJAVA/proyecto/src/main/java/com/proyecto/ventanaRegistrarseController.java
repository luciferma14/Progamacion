package com.proyecto;

import java.io.IOException;

import javax.swing.Action;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ventanaRegistrarseController {

    @FXML
    private void cambiaAPrimeraVentana() throws IOException {
        App.setRoot("primeraVentana");
    }
    
    @FXML
    private void cambiaABusResPresDev() throws IOException {
        App.setRoot("busResPresDev");
    }

    @FXML
	private TextField idUser;
	@FXML
	private PasswordField idPass;
	@FXML
	private TextField idNombre;
	@FXML
	private TextField idApellido;


	@FXML
	public void registrar(ActionEvent event) {

        idUser.setText("");
        idPass.setText("");
        idNombre.setText("");
        idApellido.setText("");

        User user = new User();
        ObservableList<User> users;
        users = App.getUsers();
        user.usr.set(idUser.getText());
        user.pas.set(idPass.getText());
        user.nom.set(idNombre.getText());
        user.apell.set(idApellido.getText());
        users.add(user);
        
	}
}