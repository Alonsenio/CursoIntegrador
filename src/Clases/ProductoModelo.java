package Clases;

/**
 *
 * @author JMMOLLER
 */
public class ProductoModelo {
    private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private int stock;
    private int proveedorId;

    // Constructor vacío
    public ProductoModelo() {
    }

    // Constructor con todos los campos
    public ProductoModelo(int id, String nombre, String descripcion, int precio, int stock, int proveedorId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedorId = proveedorId;
    }
    
    public ProductoModelo(String nombre, String descripcion, float precio, int stock) {
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
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

    @Override
    public String toString() {
        return "Productos{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", proveedorId=" + proveedorId + '}';
    }

}
