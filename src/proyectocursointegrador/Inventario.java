

package proyectocursointegrador;

import Clases.Clientes;
import Clases.Detalles_venta;
import Clases.ProductoModelo;
import Clases.Ventas;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<ProductoModelo> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }
    //Metodos de inventario
    public void agregarProducto(ProductoModelo producto) {
        productos.add(producto);
    }

    public void eliminarProducto(int productoId) {
        productos.removeIf(p -> p.getId() == productoId);
    }

    public void actualizarProducto(ProductoModelo productoActualizado) {
        for (int i = 0; i < productos.size(); i++) {
            ProductoModelo producto = productos.get(i);
            if (producto.getId() == productoActualizado.getId()) {
                productos.set(i, productoActualizado);
                break;
            }
        }
    }

    public ProductoModelo obtenerProductoPorId(int productoId) {
        for (ProductoModelo producto : productos) {
            if (producto.getId() == productoId) {
                return producto;
            }
        }
        return null; 
    }

    public List<ProductoModelo> obtenerTodosLosProductos() {
        return new ArrayList<>(productos); 
    }
    
    //Metodos de venta
    public Ventas realizarVenta(Clientes cliente, List<Detalles_venta> detallesVenta) {
        double montoTotal = calcularMontoTotal(detallesVenta);

        if (verificarStockSuficiente(detallesVenta)) {
            reducirStockProductos(detallesVenta);

            Ventas ven=new Ventas();
            Ventas venta = new Ventas(ven.getId(), ven.getFechaVenta(), ven.getClienteId(), (int) montoTotal);
            venta.setDetallesVenta(detallesVenta);


            listaVentas.add(venta);

            return venta;
        } else {
            System.out.println("No hay suficiente stock para realizar la venta.");
            return null;
        }
    }

    private double calcularMontoTotal(List<Detalles_venta> detallesVenta) {
        double montoTotal = 0.0;
        for (Detalles_venta detalleVenta : detallesVenta) {
            montoTotal += detalleVenta.getSubtotal();
        }
        return montoTotal;
    }

    private boolean verificarStockSuficiente(List<Detalles_venta> detallesVenta) {
        for (Detalles_venta detalleVenta : detallesVenta) {
            int productoId = detalleVenta.getProductoId();
            int cantidad = detalleVenta.getCantidad();

            ProductoModelo producto = obtenerProductoPorId(productoId);

            if (producto != null && producto.getStock() < cantidad) {
                return false; 
            }
        }
        return true;
    }

    private void reducirStockProductos(List<Detalles_venta> detallesVenta) {
        for (Detalles_venta detalleVenta : detallesVenta) {
            int productoId = detalleVenta.getProductoId();
            int cantidad = detalleVenta.getCantidad();

            ProductoModelo producto = obtenerProductoPorId(productoId);

            if (producto != null) {
                producto.setStock(producto.getStock() - cantidad);
                actualizarProducto(producto);
            }
        }
    }
 
}
