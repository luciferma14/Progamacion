package ExExtraOrdPractica.Ex2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroEmpleados {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        if (empleado.validar()) {
            empleados.add(empleado);
            registrarEmpleadoValido(empleado);
        } else {
            registrarEmpleadoInvalido(empleado);
        }
    }

    private void registrarEmpleadoValido(Empleado empleado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleados_ok.txt", true))) {
            writer.write("Empleado: " + empleado.getNombre() + " - " + empleado.getEdad() + " - " + empleado.getSalario() + " - " + empleado.getDepartamento());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrarEmpleadoInvalido(Empleado empleado) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("empleados_ko.txt", true))) {
            writer.write(empleado.getNombre() + "," + empleado.getEdad() + "," + empleado.getSalario() + "," + empleado.getDepartamento());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
