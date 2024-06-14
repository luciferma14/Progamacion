package com.proyecto;

/**
 * Clase que representa a un usuario de la biblioteca.
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;

    /**
     * Constructor para crear un objeto Usuario, excluyendo el apellido de éste.
     * 
     * @param idUsuario el id del usuario
     * @param nombre el nombre del usuario
     * @param email el email del usuario
     */
    public Usuario (int idUsuario,String nombre, String email){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Constructor para crear un objeto Usuario, incluyendo el apellido y excluyendo el id de éste.
     * 
     * @param nombre2 el nombre del usuario
     * @param apellido2 el apellido del usuario
     * @param email2 el email del usuario
     */
    public Usuario(String nombre2, String apellido2, String email2) {
        this.nombre = nombre2;
        this.apellido = apellido2;
        this.email = email2;
    }

    /**
     * Constructor para crear un objeto Usuario, incluyendo todos los parametros de éste.
     * 
     * @param idUsuario2 el id del usuario
     * @param nombre2 el nombre del usuario
     * @param apellido2 el apellido del usuario
     * @param email2 el email de usuario
     */
    public Usuario(int idUsuario2, String nombre2, String apellido2, String email2) {
        this.idUsuario = idUsuario2;
        this.nombre = nombre2;
        this.apellido = apellido2;
        this.email = email2;
    }

    /**
     * Obtiene el id del usuario.
     * 
     * @return el id del usuario
     */
    public int getIdUsuario(){
        return idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return el apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param apellido el apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return el email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email el email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }
}