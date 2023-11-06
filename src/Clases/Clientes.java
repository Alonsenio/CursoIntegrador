
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Clientes {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private List<Ventas> ventas;
    
    // Constructor vacío
    public Clientes() {
    }
    
    // Constructor con todos los campos
    public Clientes(int id, String nombre, String direccion, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void agregarVenta(Ventas venta) {
        if (ventas == null) {
            ventas = new ArrayList<>();
        }
        ventas.add(venta);
    }

}
