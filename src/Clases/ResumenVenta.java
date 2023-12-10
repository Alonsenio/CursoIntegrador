/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author JMMOLLER
 */
public class ResumenVenta {
    private final int idVenta;
    private final String cliente;
    private final int cantidadProductos;
    private final String fecha;
    private final double total;

    public ResumenVenta(int idVenta, String cliente, int cantidadProductos, double total, String fecha) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
        this.cantidadProductos = cantidadProductos;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public double getTotal() {
        return total;
    }
    
    public String getFecha(){
        return this.fecha;
    }
}
