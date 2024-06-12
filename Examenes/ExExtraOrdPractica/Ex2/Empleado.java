package ExExtraOrdPractica.Ex2;

public class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;

    public Empleado(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public boolean validar() {
        return ValidacionesEmpleados.validarEmpleado(this);
    }
}
