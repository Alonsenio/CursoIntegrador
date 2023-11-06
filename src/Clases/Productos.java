
package Clases;

public class Productos {
    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int stock;
    private int proveedorId;

    // Constructor vacío
    public Productos() {
    }

    // Constructor con todos los campos
    public Productos(int id, String nombre, String descripcion, int precio, int stock, int proveedorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedorId = proveedorId;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }
}
