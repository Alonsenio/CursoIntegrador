package DAO;

import Clases.ProductoModelo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

/**
 *
 * @author JMMOLLER
 */
public class ProductosDAO {
    
    public static List<ProductoModelo> getAllProducts() throws SQLException{
        String sql = "SELECT * FROM productos";
        var conn = MySQLConexion.getConexion();
        var productos = new ArrayList<ProductoModelo>();
        try(PreparedStatement ps = conn.prepareStatement(sql)){
            
            try (ResultSet rs = ps.executeQuery()) {
                if(rs == null) return null;
                while(rs.next()){
                    int stock = rs.getInt("stock");
                    float precio = rs.getFloat("precio");
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripción");
                    
                    var producto = new ProductoModelo(nombre, descripcion, precio, stock);
                    
                    productos.add(producto);
                }
            } catch(SQLException e){
                System.out.println(e);
                return null;
            }
        } catch(SQLException e){
            System.out.println(e);
            return null;
        } finally {
            conn.close();
        }
        return productos;
    }
}
