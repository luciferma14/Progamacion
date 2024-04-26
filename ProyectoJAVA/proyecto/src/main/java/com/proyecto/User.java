package com.proyecto;

import java.io.Serializable;

public class User implements Serializable {

	private int id;
	private String usr;
	private String apell;
	private String nom;
	private String pas;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return usr;
	}

	public void setUser(String user) {
		this.usr = user;
	}

	public String getApellido() {
		return apell;
	}

	public void setApellido(String apellido) {
	 	this.apell = apellido;
	}

	public String getNombre() {
		return nom;
	}

	public void setNombre(String nombre) {
	 	this.nom= nombre;
}

	public String getPass() {
		return pas;
	}

	 void setPass(String pass) {
		this.pas = pass;
	}

}