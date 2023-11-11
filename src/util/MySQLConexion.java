package util;
import java.sql.*;

public class MySQLConexion {
    public static Connection getConexion() { 
        Connection con = null;
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); // Utiliza "com.mysql.cj.jdbc.Driver" en lugar de "com.mysql.jdbc.Driver" para versiones recientes de MySQL.
            String url = "jdbc:mysql://localhost:3306/bddistribuidoragas"; 
            String usr = "root"; // Reemplaza con tu nombre de usuario de la base de datos.
            String psw = ""; // Reemplaza con tu contraseña de la base de datos.
            con = DriverManager.getConnection(url, usr, psw); 
            System.out.println("Conexion exitosa a esta");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el controlador JDBC: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Error de SQL: " + ex.getMessage());
            ex.printStackTrace();
        }
        return con; 
    }
}
