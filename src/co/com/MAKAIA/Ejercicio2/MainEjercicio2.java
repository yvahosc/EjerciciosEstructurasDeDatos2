package co.com.MAKAIA.Ejercicio2;

import co.com.MAKAIA.Ejercicio1.Peticiones;

public class MainEjercicio2 {
    public static void main(String[] args) {
        boolean programaEnEjecucion = true;
        GestorProductos gestorProductos = GestorProductos.getGestorProductos();

        while(programaEnEjecucion){
            mostrarMenu();
            int opcionMenu = Peticiones.pedirNumeroEntero("Ingrese número de " +
                    "acción que desea realizar:");
            switch (opcionMenu){
                case 1:
                    gestorProductos.agregarProducto();
                    break;
                case 2:
                    gestorProductos.mostrarListaProductos();
                    break;
                case 3:
                    gestorProductos.agregarProductoAUnaCategoria();
                    break;
                case 4:
                    gestorProductos.mostrarProductosPorCategoria();
                    break;
                case 5:
                    gestorProductos.mostrarProductoBuscadoPorCodigo();
                    break;
                case 6:
                    gestorProductos.actualizarStock();
                    break;
                case 7:
                    gestorProductos.eliminarProducto();
                    break;
                case 8:
                    gestorProductos.calcularValorTotalDelInventario();
                    break;
                case 9:
                    gestorProductos.mostrarProductosPrecioMaximoYMinimo();
                    break;
                case 10:
                    programaEnEjecucion = false;
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Ingrese un valor válido.");
            }
        }
    }

    public static void mostrarMenu(){
        System.out.println("\nGestión de productos.");
        System.out.println("1. Agregar un producto a la lista.");
        System.out.println("2. Mostrar todos los productos.");
        System.out.println("3. Agregar producto a una categoría");
        System.out.println("4. Mostrar productos agrupados por categoría.");
        System.out.println("5. Buscar un producto por su código.");
        System.out.println("6. Actualizar stock de un producto.");
        System.out.println("7. Eliminar un producto de la lista.");
        System.out.println("8. Calcular el valor total de inventario");
        System.out.println("9. Mostrar productos con precio mas alto y mas " +
                "bajo respectivamente");
        System.out.println("10. Salir del programa.");
    }
}
