package com.proyecto;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;

public class User implements Serializable {

	private int id;
	// private String usr;
	// private String apell;
	// private String nom;
	// private String pas;
	
	public SimpleStringProperty usr = new SimpleStringProperty();
	public SimpleStringProperty apell = new SimpleStringProperty();
	public SimpleStringProperty nom = new SimpleStringProperty();
	public SimpleStringProperty pas = new SimpleStringProperty();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return usr.get();
	}

	// public void setUser(String user) {
	// 	this.usr = user;
	// }

	public String getApellido() {
		return apell.get();
	}

	// public void setApellido(String apellido) {
	// 	this.apell = apellido;
	// }

	public String getNombre() {
		return nom.get();
	}

	// public void setNombre(String nombre) {
	// 	this.nom= nombre;
	// }

	public String getPass() {
		return pas.get();
	}

	// public void setPass(String pass) {
	// 	this.pas = pass;
	// }

}