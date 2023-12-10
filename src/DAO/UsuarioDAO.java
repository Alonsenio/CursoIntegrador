/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.UserLogged;
import Clases.Usuarios;
import Interfaces.Cargando;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.MySQLConexion;

/**
 *
 * @author JMMOLLER
 */
public class UsuarioDAO {

    private final Connection conn = MySQLConexion.getConexion();

    public UserLogged authUser(String usuario, String pass) {
        String sql = "SELECT u.*, r.nombreRol FROM usuarios u JOIN rol_usuarios ru ON u.id = ru.usuarios_id JOIN rol r ON ru.rol_id = r.id WHERE u.activo = 1 AND u.nombre = ? AND u.contraseña = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, usuario);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Integer activo = rs.getInt("activo");
                String privilegio = rs.getString("nombreRol");
                String correo = rs.getString("correo");
                String fechaCreacion = rs.getString("fecha_creacion");
                String fechaModificacion = rs.getString("fecha_modificacion");
                
                return new UserLogged(userId, nombre, pass, activo, correo, privilegio, fechaCreacion, fechaModificacion);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + e.getMessage());
        }
        return null;
    }
}
