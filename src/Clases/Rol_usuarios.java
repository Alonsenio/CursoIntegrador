
package Clases;

public class Rol_usuarios {
    private int id;
    private int rolId;
    private int usuarioId;

    // Constructor vacío
    public Rol_usuarios() {
        
    }

    // Constructor con todos los campos
    public Rol_usuarios(int id, int rolId, int usuarioId) {
        this.id = id;
        this.rolId = rolId;
        this.usuarioId = usuarioId;
    }

    // Métodos getters y setters para acceder y modificar los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
