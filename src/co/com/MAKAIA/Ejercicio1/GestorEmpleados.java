package co.com.MAKAIA.Ejercicio1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorEmpleados {
    private static GestorEmpleados gestorEmpleados;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private Map<String, ArrayList<Empleado>> empleadosPorDepartamento;

    private GestorEmpleados(){}

    public static GestorEmpleados getGestorEmpleados(){
        if(gestorEmpleados == null){
            gestorEmpleados = new GestorEmpleados();
        }
        return gestorEmpleados;
    }

    public void agregarEmpleado(){

        String nombre = Peticiones.pedirTexto("Ingrese el nombre del empleado" +
                " a agregar:");
        String apellido = Peticiones.pedirTexto("Ingrese el apellido del " +
                "empleado a agregar:");
        int edad = Peticiones.pedirNumeroEntero("Ingrese la edad del empleado" +
                " a agregar:");
        String departamento = Peticiones.pedirTexto("Ingrese el departamento " +
                "del empleado a agregar:");
        Empleado empleado = new Empleado(nombre, apellido, edad, departamento);
        listaEmpleados.add(empleado);
        System.out.println("El empleado '" + empleado + "' ha sido agregado a " +
                "la lista de empleados.");
    }

    public void mostrarListaEmpleados(){
        if(listaEmpleados.size() == 0){
            System.out.println("La lista de empleados está vacía.");
        } else{
            System.out.println("Mostrando lista de empleados:");
            for (int i = 0; i < listaEmpleados.size(); i++) {
                System.out.println((i + 1) + ". " + listaEmpleados.get(i).toString());
            }
        }
    }

    public void buscarEmpleadoPorNombreYApellido (){
        if(listaEmpleados.isEmpty()){
            System.out.println("La lista de empleados está vacía.");
        } else{
            String nombre = Peticiones.pedirTexto("Ingrese el nombre" +
                    " del empleado a buscar:");
            String apellido = Peticiones.pedirTexto("Ingrese el apellido" +
                    " del empleado a buscar:");

            boolean empleadoEncontrado = false;
            for (int i = 0; i < listaEmpleados.size(); i++) {
                if(listaEmpleados.get(i).getNombre().equals(nombre)){
                    if(listaEmpleados.get(i).getApellido().equals(apellido)){
                        System.out.println("El empleado buscado es: " +
                                listaEmpleados.get(i).toString() + ".");
                        empleadoEncontrado = true;
                    }
                }
            }

            if(!empleadoEncontrado){
                System.out.println("El nombre buscado no corresponde a ningún " +
                        "empleado de la lista.");
            }
        }
    }

    public void eliminarEmpleado (){
        if(listaEmpleados.isEmpty()){
            System.out.println("La lista de empleados está vacía.");
        } else{
            mostrarListaEmpleados();
            int indiceContactoAActualizar = pedirIndiceDeLista();
            listaEmpleados.remove(indiceContactoAActualizar);
            System.out.println("Empleado eliminado de la lista.");
        }
    }

    public void organizarEmpleadosPorDepartamento(){
        empleadosPorDepartamento = new HashMap<>();
        for (Empleado empleado: listaEmpleados) {
            ArrayList<Empleado> empleadosDeUnDepartamento;
            if(empleadosPorDepartamento.containsKey(empleado.getDepartamento())){
                empleadosDeUnDepartamento = empleadosPorDepartamento.get(empleado.getDepartamento());
            }else{
                empleadosDeUnDepartamento = new ArrayList<>();
            }
            empleadosDeUnDepartamento.add(empleado);
            empleadosPorDepartamento.put(empleado.getDepartamento(),
                    empleadosDeUnDepartamento);
        }
    }

    public void mostrarEmpleadosPorDepartamento(){
        if(listaEmpleados.isEmpty()){
            System.out.println("La lista de empleados está vacía.");
        } else{
            organizarEmpleadosPorDepartamento();
            for (String clave: empleadosPorDepartamento.keySet()) {
                ArrayList<Empleado> empleados =
                        empleadosPorDepartamento.get(clave);
                System.out.println("\nDepartamento de: " + clave);
                for(Empleado empleado: empleados){
                    System.out.println(empleado);
                }
            }
        }
    }

    public int pedirIndiceDeLista(){
        boolean indiceValido = false;
        int indiceContactoAActualizar = 0;

        while(!indiceValido){
            indiceContactoAActualizar = (Peticiones.pedirNumeroEntero("Ingrese" +
                    " el número correspondiente al empleado:")) - 1;

            if(indiceContactoAActualizar >= 0 &&
                    indiceContactoAActualizar < listaEmpleados.size()){
                indiceValido = true;
            } else{
                System.out.println("Ingrese un valor válido.");
            }
        }
        return indiceContactoAActualizar;
    }
}
