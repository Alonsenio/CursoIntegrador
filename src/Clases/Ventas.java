
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Ventas {
    private int id;
    private String fechaVenta;
    private int clienteId;
    private int totalVenta;
    private List<Detalles_venta> detallesVenta;
    
    // Constructor vacío
    public Ventas() {
        
    }

    // Constructor con todos los campos
    public Ventas(int id, String fechaVenta, int clienteId, int totalVenta) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.clienteId = clienteId;
        this.totalVenta = totalVenta;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }
    
    public void agregarDetalleVenta(Detalles_venta detalleVenta) {
        if (detallesVenta == null) {
            detallesVenta = new ArrayList<>();
        }
        detallesVenta.add(detalleVenta);
    }
}
