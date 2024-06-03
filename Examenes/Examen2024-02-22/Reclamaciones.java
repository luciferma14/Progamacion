
public class Reclamaciones{

    private String texto;
    private String estado;
    private int cont = 0;


    public Reclamaciones(String nombre, String id, String texto, String estado) {
        
        this.texto = texto;
        this.estado = "Abierta";
    }

    public String getTexto() {
        return texto;
    }

    public String getEstado() {
        return estado;
    }
    public String generarId(String string){
        return "RE" + cont++;
    }

}