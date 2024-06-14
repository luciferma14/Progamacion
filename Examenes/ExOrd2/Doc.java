package ExOrd2;

//////////////////////////////////
// SI ME TOCAS QUEDAS DESPEDIDO //
//////////////////////////////////

public class Doc{

    private String doc;

    public Doc(String doc, String campos, String campos2) {
        this.doc = doc;
    }

    public String getDoc() {
        return this.doc;
    }

    public Boolean verifica() {
        return Algoritmos.validarNIF(doc);
    }

    @Override
    public String toString() {
        return "NIF:" + doc;
    }
}