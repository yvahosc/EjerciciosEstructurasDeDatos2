package co.com.MAKAIA.Ejercicio1;

public class MainEjercicio1 {
    public static void main(String[] args) {
        boolean programaEnEjecucion = true;
        GestorEmpleados gestorEmpleados = GestorEmpleados.getGestorEmpleados();

        while(programaEnEjecucion){
            mostrarMenu();
            int opcionMenu = Peticiones.pedirNumeroEntero("Ingrese número de " +
                    "acción que desea realizar:");
            switch (opcionMenu){
                case 1:
                    gestorEmpleados.agregarEmpleado();
                    break;
                case 2:
                    gestorEmpleados.mostrarListaEmpleados();
                    break;
                case 3:
                    gestorEmpleados.mostrarEmpleadosPorDepartamento();
                    break;
                case 4:
                    gestorEmpleados.buscarEmpleadoPorNombreYApellido();
                    break;
                case 5:
                    gestorEmpleados.eliminarEmpleado();
                    break;
                case 6:
                    programaEnEjecucion = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Ingrese un valor válido.");
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("\nGestión de empleados.");
        System.out.println("1. Agregar un empleado a la lista.");
        System.out.println("2. Mostrar todos los empleados.");
        System.out.println("3. Mostrar empleados agrupados por departamento.");
        System.out.println("4. Buscar un empleado por su nombre y apellido.");
        System.out.println("5. Eliminar un empleado por su nombre y apellido.");
        System.out.println("6. Salir del programa.");
    }
}
