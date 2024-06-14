package ExExtraOrdPractica.Ex3;

public class Usuario {
    private String nombre;
    private String idUsuario;
    private String email;
    private String telefono;

    public Usuario(String nombre, String idUsuario, String email, String telefono) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }
    public String getIdUsuario() { return idUsuario; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }

    public boolean validar() {
        return ValidacionesUsuario.validarUsuario(this);
    }
}
