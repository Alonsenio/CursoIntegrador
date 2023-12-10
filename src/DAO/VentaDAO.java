/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.MejoresProductos;
import Clases.CarritoModelo;
import Clases.MejoresClientes;
import Clases.ResumenVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public List<ResumenVenta> getResumenVentas(){
        String sql = "SELECT v.id, u.nombre AS cliente, v.fecha_venta, v.total_venta, "
                + "(SELECT COUNT(*) FROM detalles_venta WHERE venta_id = v.id) AS productos FROM ventas v JOIN "
                + "usuarios u ON v.cliente_id = u.id;";
        
        List<ResumenVenta> resumen = new ArrayList<>();
        try(conn){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                resumen.add(new ResumenVenta(
                        res.getInt("id"), 
                        res.getString("cliente"), 
                        res.getInt("productos"), 
                        res.getDouble("total_venta"),
                        res.getString("fecha_venta"))
                );
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return resumen;
    }
    
    public List<MejoresClientes> getMejoresClientes(){
        String sql = "SELECT u.nombre AS nombre_cliente, COUNT(v.id) AS total_ventas FROM "
                + "usuarios u JOIN ventas v ON u.id = v.cliente_id GROUP BY u.id, u.nombre ORDER BY total_ventas DESC;";
        List<MejoresClientes> clientes = new ArrayList<>();
        try(conn) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                clientes.add(new MejoresClientes(
                        res.getString("nombre_cliente"),
                        res.getInt("total_ventas")
                    )
                );
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return clientes;
    }
    
    public List<MejoresProductos> getMejoresProductos(){
        String sql = "SELECT p.nombre AS nombre_producto, p.precio, p.stock, SUM(dv.cantidad) AS total_vendido "
                + "FROM detalles_venta dv JOIN productos p ON dv.producto_id = p.id GROUP BY dv.producto_id, "
                + "p.nombre ORDER BY total_vendido DESC;";
        List<MejoresProductos> productos = new ArrayList<>();
        try(conn) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()){
                productos.add(new MejoresProductos(
                        res.getString("nombre_producto"),
                        res.getFloat("precio"),
                        res.getInt("stock"),
                        res.getInt("total_vendido")
                    )
                );
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return productos;
    }
}
