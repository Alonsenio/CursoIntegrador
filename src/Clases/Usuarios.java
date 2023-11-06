
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Usuarios {
    private int id;
    private String nombre;
    private String contraseña;
    private int activo;
    private String correo;
    private String fechaCreacion;
    private String fechaModificacion;
    private int creadoPor;
    private int modificadoPor;
    private List<Rol_usuarios> rolesUsuarios;

    // Constructor vacío
    public Usuarios() {
        
    }

    // Constructor con todos los campos
    public Usuarios(int id, String nombre, String contraseña, int activo, String correo, String fechaCreacion, String fechaModificacion, int creadoPor, int modificadoPor) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.activo = activo;
        this.correo = correo;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(int creadoPor) {
        this.creadoPor = creadoPor;
    }

    public int getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(int modificadoPor) {
        this.modificadoPor = modificadoPor;
    }
    
    public void agregarRolUsuario(Rol_usuarios rolUsuario) {
        if (rolesUsuarios == null) {
            rolesUsuarios = new ArrayList<>();
        }
        rolesUsuarios.add(rolUsuario);
    }

    public void quitarRolUsuario(Rol_usuarios rolUsuario) {
        if (rolesUsuarios != null) {
            rolesUsuarios.remove(rolUsuario);
        }
    }
}
