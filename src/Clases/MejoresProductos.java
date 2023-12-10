/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author JMMOLLER
 */
public class MejoresProductos {
    private final String nombre;
    private final double precio;
    private final int stock;
    private final int totalVendido;

    public MejoresProductos(String nombre, float precio, int stock,  int totalVendido) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.totalVendido = totalVendido;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public int getTotalVendido() {
        return totalVendido;
    }
}
