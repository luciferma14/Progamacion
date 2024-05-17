package com.proyecto;

public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;

    public Usuario (int idUsuario,String nombre, String email){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
    }

    public Usuario(String nombre2, String apellido2, String email2) {
        this.nombre = nombre2;
        this.apellido = apellido2;
        this.email = email2;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
