
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Rol {
    private int id;
    private String nombreRol;
    private List<Usuarios> usuarios;

    // Constructor vacío
    public Rol() {
    }

    // Constructor con todos los campos
    public Rol(int id, String nombreRol) {
        this.id = id;
        this.nombreRol = nombreRol;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    public void agregarUsuario(Usuarios usuario) {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }
        usuarios.add(usuario);
    }

    public void quitarUsuario(Usuarios usuario) {
        if (usuarios != null) {
            usuarios.remove(usuario);
        }
    }
}
