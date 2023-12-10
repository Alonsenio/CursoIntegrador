/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.CarritoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import util.MySQLConexion;

/**
 *
 * @author JMMOLLER
 */
public class VentaDAO {

    private final Connection conn = MySQLConexion.getConexion();

    public boolean crearVenta(int clientId, List<CarritoModelo> cart, double total) throws SQLException {
        String sql = "INSERT INTO `ventas`(`cliente_id`, `total_venta`) VALUES (?, ?)";
        boolean registro = false;
        try (conn) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, clientId);
            stmt.setDouble(2, total);

            int res = stmt.executeUpdate();

            if (res > 0) {
                registro = true;
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        for (var carrito : cart) {
                            boolean sucess = crearDetalleVenta(generatedKeys.getInt(1), carrito);
                            if (!sucess) {
                                registro = sucess;
                                break;
                            }
                        }
                    } else {
                        System.out.println("No se pudo obtener el ID de venta generado");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return registro;
    }

    private boolean crearDetalleVenta(int ventaId, CarritoModelo cart) throws SQLException {
        String sql = "INSERT INTO `detalles_venta`(`venta_id`, `producto_id`, `cantidad`, `subtotal`) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ventaId);
            stmt.setInt(2, cart.getId());
            stmt.setInt(3, cart.getCantidad());
            stmt.setDouble(4, cart.getSubTotal());
            
            int res = stmt.executeUpdate();
            
            if(res > 0) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
