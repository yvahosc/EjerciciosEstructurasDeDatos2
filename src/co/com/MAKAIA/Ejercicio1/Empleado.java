package co.com.MAKAIA.Ejercicio1;

public class Empleado {
    private String nombre;
    private String apellido;
    private int edad;
    private String departamento;

    public Empleado(String nombre, String apellido, int edad, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + ", apellido: " + apellido + ", edad: " + edad +
                " años, departamento: " + departamento;
    }
}
