package co.com.MAKAIA.Ejercicio2;

public class Producto {
    private String codigo;
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String codigo, String nombre, int precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", nombre: " + nombre + ", precio: " + precio +
                ", stock: " + stock ;
    }
}
