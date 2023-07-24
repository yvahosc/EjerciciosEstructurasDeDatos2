package co.com.MAKAIA.Ejercicio2;

import co.com.MAKAIA.Ejercicio1.Peticiones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorProductos {
    private static GestorProductos gestorProductos;
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private Map<String, ArrayList<Producto>> productosPorCategoria =
            new HashMap<>();

    private GestorProductos(){}

    public static GestorProductos getGestorProductos(){
        if(gestorProductos == null){
            gestorProductos = new GestorProductos();
        }
        return gestorProductos;
    }

    public void agregarProducto(){

        String codigo = Peticiones.pedirTexto("Ingrese el código del producto" +
                " a agregar:");
        String nombre = Peticiones.pedirTexto("Ingrese el nombre del " +
                "producto a agregar:");
        int precio = Peticiones.pedirNumeroEntero("Ingrese el precio del " +
                "producto a agregar:");
        int stock = Peticiones.pedirNumeroEntero("Ingrese el stock del " +
                "producto a agregar:");
        Producto producto = new Producto(codigo, nombre, precio, stock);
        listaProductos.add(producto);
        System.out.println("El producto '" + producto + "' ha sido agregado a" +
                " la lista de productos.");
    }

    public void mostrarListaProductos(){
        if(listaProductos.size() == 0){
            System.out.println("La lista de productos está vacía.");
        } else{
            System.out.println("Mostrando lista de productos:");
            for (int i = 0; i < listaProductos.size(); i++) {
                System.out.println((i + 1) + ". " + listaProductos.get(i).toString());
            }
        }
    }

    public Producto buscarProductoPorCodigo (){
        Producto producto = null;
        String codigo = Peticiones.pedirTexto("Ingrese el código" +
                " del producto a buscar:");

        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getCodigo().equals(codigo)){
                producto = listaProductos.get(i);
            }
        }
        return producto;
    }

    public void mostrarProductoBuscadoPorCodigo(){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        }else{
            Producto producto = buscarProductoPorCodigo();
            if(producto == null){
                System.out.println("El código buscado no corresponde a ningún" +
                        " producto de la lista.");
            } else{
                System.out.println("El producto buscado es: " + producto + ".");
            }
        }
    }

    public void eliminarProducto (){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        } else{
            Producto productoAEliminar = null;
            while(productoAEliminar == null){
                mostrarListaProductos();
                productoAEliminar = buscarProductoPorCodigo();
                if(productoAEliminar == null){
                    System.out.println("Ingrese código de producto existente.");
                }
            }

            System.out.println("Se desea eliminar producto '" +
                    productoAEliminar + "'.");
            listaProductos.remove(productoAEliminar);
            for(String categoria: productosPorCategoria.keySet()){
                ArrayList<Producto> productos =
                        productosPorCategoria.get(categoria);
                productos.remove(productoAEliminar);
            }

            System.out.println("Producto eliminado de la lista.");
        }
    }

    public int pedirIndiceDeLista(){
        boolean indiceValido = false;
        int indiceProducto = 0;

        while(!indiceValido){
            indiceProducto = (Peticiones.pedirNumeroEntero("Ingrese" +
                    " el número correspondiente al producto:")) - 1;

            if(indiceProducto >= 0 &&
                    indiceProducto < listaProductos.size()){
                indiceValido = true;
            } else{
                System.out.println("Ingrese un valor válido.");
            }
        }
        return indiceProducto;
    }

    public void mostrarProductosPrecioMaximoYMinimo(){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        }else{
            int maximo = listaProductos.get(0).getPrecio();
            Producto productoPrecioMaximo = listaProductos.get(0);
            int minimo = listaProductos.get(0).getPrecio();
            Producto productoPrecioMinimo = listaProductos.get(0);

            for(Producto producto: listaProductos){
                if(producto.getPrecio() > maximo){
                    maximo = producto.getPrecio();
                    productoPrecioMaximo = producto;
                }

                if(producto.getPrecio() < minimo){
                    minimo = producto.getPrecio();
                    productoPrecioMinimo = producto;
                }
            }

            System.out.println("El producto con el precio más alto es: " +
                    productoPrecioMaximo);
            System.out.println("El producto con el precio más bajo es: " +
                    productoPrecioMinimo);
        }
    }

    public void calcularValorTotalDelInventario(){
        int valorTotalDelInventario = 0;
        for(Producto producto: listaProductos){
            valorTotalDelInventario += producto.getPrecio() * producto.getStock();
        }

        System.out.println("El valor total del inventario es: $" +
                valorTotalDelInventario + ".");
    }

    public void agregarProductoAUnaCategoria(){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        }else{
            mostrarListaProductos();
            int indiceProductoAAgregarACategoria = pedirIndiceDeLista();
            Producto productoAAgregar =
                    listaProductos.get(indiceProductoAAgregarACategoria);
            String categoria = Peticiones.pedirTexto("Ingrese el nombre" +
                    " de la categoría a la cual agregar el producto " +
                    "seleccionado.");

            ArrayList<Producto> productosDeUnaCategoria;
            if(productosPorCategoria.containsKey(categoria)){
                productosDeUnaCategoria = productosPorCategoria.get(categoria);
            }else{
                productosDeUnaCategoria = new ArrayList<>();
            }
            if(productosDeUnaCategoria.contains(productoAAgregar)){
                System.out.println("El producto '" + productoAAgregar + "' que" +
                        " intenta agregar ya pertenece a la categoría "+ categoria + ".");
            } else{
                productosDeUnaCategoria.add(productoAAgregar);
                productosPorCategoria.put(categoria,
                        productosDeUnaCategoria);

                System.out.println("El producto '" + productoAAgregar + "' ha " +
                        "sido agregado a la categoría " + categoria + ".");
            }
        }
    }

    public void mostrarProductosPorCategoria(){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        } else{
            if(productosPorCategoria.isEmpty()){
                System.out.println("La categorización de los productos está " +
                        "vacía.");
            } else{
                for (String clave: productosPorCategoria.keySet()) {
                    ArrayList<Producto> productos =
                            productosPorCategoria.get(clave);
                    if(!productos.isEmpty()){
                        System.out.println("\nCategoría de: " + clave);
                        for(Producto producto: productos){
                            System.out.println(producto);
                        }
                    }
                }
            }
        }
    }

    public void actualizarStock(){
        if(listaProductos.isEmpty()){
            System.out.println("La lista de productos está vacía.");
        } else{
            Producto productoAActualizar = null;
            while(productoAActualizar == null){
                mostrarListaProductos();
                productoAActualizar = buscarProductoPorCodigo();
                if(productoAActualizar == null){
                    System.out.println("Ingrese código de producto existente.");
                }
            }

            System.out.println("Se desea actualizar el stock del producto '" +
                    productoAActualizar + "'.");

            int cantidadNuevaDeStock = Peticiones.pedirNumeroEntero("Ingrese la " +
                    "cantidad nueva de stock del producto seleccionado.");

            productoAActualizar.setStock(cantidadNuevaDeStock);

            System.out.println("El stock del producto '" + productoAActualizar +
                    "'  ha sido actualizado.");
        }
    }
}
