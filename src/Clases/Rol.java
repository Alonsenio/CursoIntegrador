
package Clases;

public class Rol {
    private int id;
    private String nombreRol;

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
}
