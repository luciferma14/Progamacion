package com.proyecto;

import java.io.Serializable;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class User implements Serializable {

	@FXML
	private String idUser;

	@FXML
	private String idPass;

	@FXML
	private String idNombre;

	@FXML
	private String idApellido;


	public String getUser() {
		return idUser;
	}

	public void setUser(String idUser) {
		this.idUser = idUser;
	}

	public String getApellido() {
		return idApellido;
	}

	public void setApellido(String idApellido) {
	 	this.idApellido = idApellido;
	}

	public String getNombre() {
		return idNombre;
	}

	public void setNombre(String idNombre) {
	 	this.idNombre= idNombre;
}

	public String getPass() {
		return idPass;
	}

	 void setPass(String idPass) {
		this.idPass = idPass;
	}

}