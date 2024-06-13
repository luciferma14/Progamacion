package ExExtraOrdPractica.Ex3;

import java.util.regex.Pattern;

public class ValidacionesUsuario {
    public static boolean validarUsuario(Usuario usuario) {
        if (usuario.getNombre().isEmpty()) return false;
        if (usuario.getIdUsuario().isEmpty()) return false; // Supone que la unicidad se verifica en otro lugar
        if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").matcher(usuario.getEmail()).matches()) return false;
        if (!usuario.getTelefono().matches("\\d{10}")) return false;
        return true;
    }
}
