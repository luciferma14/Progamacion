package ExamenOrdinaria;

//////////////////////////////////
// SI ME TOCAS QUEDAS DESPEDIDO //
//////////////////////////////////

import java.io.FileWriter;
import java.io.IOException;

public class Validador {

    public static Boolean esValido(Doc documento) {

        return documento.verifica();

    }

    public static void fichero(Doc documento) {

        if (esValido(documento)) {
            try {
                FileWriter fw = new FileWriter("docs_ok.txt", true);
                fw.write(documento.toString() + "\n");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}