package ExExtraOrdPractica.Ex2;

public class ValidacionesEmpleados {
    public static boolean validarEmpleado(Empleado empleado) {
        if (empleado.getNombre().isEmpty()) {
            return false;
        }
        if (empleado.getEdad() < 18 || empleado.getEdad() > 65) {
            return false;
        }
        if (empleado.getSalario() < 1000 || empleado.getSalario() > 10000) {
            return false;
        }
        if (!empleado.getDepartamento().equalsIgnoreCase("IT") &&
            !empleado.getDepartamento().equalsIgnoreCase("HR") &&
            !empleado.getDepartamento().equalsIgnoreCase("Finance") &&
            !empleado.getDepartamento().equalsIgnoreCase("Sales")) {
            return false;
        }
        return true;
    }
}
