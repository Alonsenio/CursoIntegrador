/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author JMMOLLER
 */
public class CarritoModelo {
    private int cantidad;
    private final int id;
    private final String nombre;
    private final double precio;
    private double subTotal;

    public CarritoModelo(ProductoModelo producto, int cantidad) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.cantidad = cantidad;
        this.subTotal = this.precio * cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.subTotal = this.precio * cantidad;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return "CarritoModelo{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }
    
    
}
