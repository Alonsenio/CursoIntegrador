
package Clases;

public class Detalles_venta {
    private int id;
    private int ventaId;
    private int productoId;
    private int cantidad;
    private int subtotal; // Cambio el tipo de dato a int

    // Constructor vacío
    public Detalles_venta() {
        
    }

    // Constructor con todos los campos
    public Detalles_venta(int id, int ventaId, int productoId, int cantidad, int subtotal) {
        this.id = id;
        this.ventaId = ventaId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
