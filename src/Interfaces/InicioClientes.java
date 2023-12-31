package Interfaces;

import Clases.CarritoModelo;
import Clases.ProductoModelo;
import Clases.UserLogged;
import DAO.ProductosDAO;
import DAO.VentaDAO;
import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import util.RenderImage;

/**
 *
 * @author JMMOLLER
 */
public class InicioClientes extends javax.swing.JFrame {

    private DefaultTableModel model;
    private DefaultTableModel modelCarrito;
    private SwingWorker<Void, Void> searchWorker;
    private List<ProductoModelo> productos = ProductosDAO.getAllProducts();
    private final List<ProductoModelo> filtrado = new ArrayList<>(productos);
    private final List<CarritoModelo> carrito = new ArrayList<>();
    private String lastText = "";
    private double total = 0.00;

    /**
     * Creates new form ProductosClientes
     *
     * @throws java.sql.SQLException
     */
    public InicioClientes() throws SQLException {
        initComponents();
        var RI = new RenderImage(this);
        setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        RI.setIconFrame();
        updateTableProducts();
    }

    private void initializeSearch() {
        // Obtener el texto actual
        String textoBusqueda = txtBuscar.getText();

        if (lastText.equals(textoBusqueda)) {
            return;
        }

        lastText = textoBusqueda;

        // Cancelar cualquier tarea de búsqueda anterior (si la hay)
        if (searchWorker != null && !searchWorker.isDone()) {
            searchWorker.cancel(true);
        }

        // Crear un nuevo SwingWorker para realizar la búsqueda en segundo plano
        searchWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                System.out.println("Realizando búsqueda para: " + textoBusqueda);
                filtrado.clear();
                for (int i = 0; i < productos.size(); i++) {
                    // Comprobar si se cancela la tarea
                    if (isCancelled()) {
                        filtrado.clear();
                        return null;
                    }
                    if (containsIgnoreCase(productos.get(i), textoBusqueda)) {
                        filtrado.add(productos.get(i));
                    }
                }
                if (!cbOrdenar.getItemAt(0).equals("Seleccionar")) {
                    ordenarLista(filtrado);
                }
                updateTableProducts();
                return null;
            }

            @Override
            protected void done() {
            }
        };

        // Ejecutar el SwingWorker
        searchWorker.execute();
    }

    private void updateTableProducts() {
        model.setRowCount(0);
        filtrado.forEach(producto -> {
            model.addRow(new Object[]{
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getStock(),
                producto.getPrecio()
            });
        });
    }

    private void updateTableCart() {
        modelCarrito.setRowCount(0);
        carrito.forEach(cart -> {
            modelCarrito.addRow(new Object[]{
                cart.getId(),
                cart.getNombre(),
                cart.getCantidad(),
                cart.getPrecio()
            });
        });
    }

    private boolean containsIgnoreCase(ProductoModelo producto, String compare) {
        return producto.getNombre().toLowerCase().contains(compare.toLowerCase())
                || producto.getDescripcion().toLowerCase().contains(compare.toLowerCase());
    }

    private void ordenarLista(List<ProductoModelo> productos) {
        int indiceOrdenamiento = cbOrdenar.getSelectedIndex();
        switch (indiceOrdenamiento) {
            case 0 ->
                productos.sort(Comparator.comparing(ProductoModelo::getNombre));
            case 1 ->
                productos.sort(Comparator.comparing(ProductoModelo::getDescripcion));
            case 2 ->
                productos.sort(Comparator.comparingInt(ProductoModelo::getStock));
            case 3 ->
                productos.sort(Comparator.comparingDouble(ProductoModelo::getPrecio));
            default ->
                throw new IllegalArgumentException("Índice de ordenamiento no válido: " + indiceOrdenamiento);
        }
    }

    private void handleRowClick() {
        if (tblProducts.getSelectedRow() == -1) {
            sldCantidad.setMaximum(0);

            btnComprar.setBackground(new Color(0, 102, 0));
            return;
        }

        int selected = tblProducts.getSelectedRow();
        int stock = Integer.parseInt(tblProducts.getValueAt(selected, 3).toString());

        sldCantidad.setMaximum(stock);

        btnComprar.setBackground(new Color(51, 204, 0));
    }

    private void updateStockRow(int productId, String cantidadCarrito, boolean isEncrease) {
        var producto = findProductoById(productId);
        if(producto == null) return;
        
        int stock = producto.getStock();

        if (isEncrease) {
            stock += Integer.parseInt(cantidadCarrito);
        } else {
            stock -= Integer.parseInt(cantidadCarrito);
        }
        
        producto.setStock(stock);

        sldCantidad.setMaximum(stock);
        updateTableProducts();
    }
    
    private ProductoModelo findProductoById(int id){
        for (var producto : productos) {
            if(producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }
    
    private void updateTotal(){
        total = 0.0;
        carrito.forEach(cart -> total += cart.getSubTotal());
        lblTotal.setText("Total: S/" + total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new util.PanelRound();
        btnClose = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        modelCarrito = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID","Nombre", "Cantidad", "Precio"
            }
        ){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblCarrito = new rojerusan.RSTableMetro();
        jScrollPane8 = new javax.swing.JScrollPane();
        model = new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String [] {
                "ID","Nombre ", "Descripción", "Stock", "Precio",
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tblProducts = new rojerusan.RSTableMetro();
        tblProducts.setModel(model);
        TableColumnModel columnModel = tblProducts.getColumnModel();

        // Obtener la columna por nombre ("ID" en este caso)
        TableColumn columnID = columnModel.getColumn(columnModel.getColumnIndex("ID"));

        // Establecer el tamaño de la columna ID en 0
        columnID.setMinWidth(0);
        columnID.setMaxWidth(0);
        columnID.setPreferredWidth(0);
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblProducts.getColumnCount(); i++) {
            tblProducts.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }
        tblProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        var selectionModel = tblProducts.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    handleRowClick();
                }
            }
        });
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbOrdenar = new javax.swing.JComboBox<>();
        ((JLabel)cbOrdenar.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2 = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        panelRound2 = new util.PanelRound();
        search = new javax.swing.JLabel();
        placeholder = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        sldCantidad = new javax.swing.JSlider();
        lblCantidad = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setUndecorated(true);
        setResizable(false);

        panelRound1.setBackground(new java.awt.Color(35, 35, 35));
        panelRound1.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/celestex.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setDefaultCapable(false);
        btnClose.setFocusPainted(false);
        btnClose.setFocusable(false);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosehandleClick(evt);
            }
        });
        panelRound1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 18, 30, -1));

        tblCarrito.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        tblCarrito.setModel(modelCarrito);

        TableColumnModel columnCartModel = tblCarrito.getColumnModel();

        // Obtener la columna por nombre ("ID" en este caso)
        TableColumn columnCartID = columnCartModel.getColumn(0);

        // Establecer el tamaño de la columna ID en 0
        columnCartID.setMinWidth(0);
        columnCartID.setMaxWidth(0);
        columnCartID.setPreferredWidth(0);

        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblCarrito.getColumnCount(); i++) {
            tblCarrito.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }
        tblCarrito.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        var selectionCartModel = tblCarrito.getSelectionModel();
        selectionCartModel.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()) {
                    btnEliminar.setEnabled(true);
                }
            }
        });
        jScrollPane9.setViewportView(tblCarrito);

        panelRound1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 270, 180));

        tblProducts.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane8.setViewportView(tblProducts);

        panelRound1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 680, 410));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos Disponibles");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ordenar por:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 93, -1, -1));

        cbOrdenar.setBackground(new java.awt.Color(35, 35, 35));
        cbOrdenar.setForeground(new java.awt.Color(255, 255, 255));
        cbOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Nombre", "Descripción", "Stock", "Precio" }));
        cbOrdenar.setToolTipText("");
        cbOrdenar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrdenarItemStateChanged(evt);
            }
        });
        panelRound1.add(cbOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar:");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        btnComprar.setBackground(new java.awt.Color(0, 102, 0));
        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar");
        btnComprar.setBorder(null);
        btnComprar.setEnabled(false);
        btnComprar.setFocusPainted(false);
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        panelRound1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 100, 30));

        panelRound2.setBackground(new java.awt.Color(0, 0, 0));
        panelRound2.setRequestFocusEnabled(false);
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setBackground(new java.awt.Color(255, 0, 0));
        search.setRequestFocusEnabled(false);
        panelRound2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 40, 40));

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Iconos/search-50.png"));

        // Obtener el tamaño del JLabel
        int labelWidth = 25;
        int labelHeight = 25;

        // Escalar la imagen al tamaño del JLabel
        Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Establecer el ImageIcon en el JLabel
        search.setIcon(scaledIcon);

        placeholder.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        placeholder.setForeground(new java.awt.Color(153, 153, 153));
        placeholder.setText("Buscar por nombre o descripción...");
        panelRound2.add(placeholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        txtBuscar.setBackground(new java.awt.Color(0, 0, 0));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(153, 153, 153));
        txtBuscar.setBorder(null);
        txtBuscar.setCaretColor(new java.awt.Color(255, 255, 255));
        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        txtBuscar.setMargin(new Insets(7, 30, 7, 20));
        panelRound2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 230, 25));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 290, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carrito");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(0, 0, 153));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 127, -1, -1));

        sldCantidad.setBackground(new java.awt.Color(35, 35, 35));
        sldCantidad.setForeground(new java.awt.Color(0, 0, 204));
        sldCantidad.setMaximum(0);
        sldCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldCantidadStateChanged(evt);
            }
        });
        panelRound1.add(sldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 180, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad: 0");
        panelRound1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("Total: S/0.00");
        panelRound1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 270, -1));

        btnEliminar.setBackground(new java.awt.Color(204, 0, 0));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelRound1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setIcon(new ImageIcon(getClass().getResource("/Iconos/c11.png")));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setIcon(new ImageIcon(getClass().getResource("/Iconos/celestex.png")));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnClosehandleClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosehandleClick
        System.exit(0);
    }//GEN-LAST:event_btnClosehandleClick

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        placeholder.setVisible(false);
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (txtBuscar.getText().isEmpty() || txtBuscar.getText().isBlank()) {
            placeholder.setVisible(true);
            txtBuscar.setText(null);
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tblProducts.getSelectionModel().clearSelection();
        initializeSearch();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cbOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrdenarItemStateChanged
        if (cbOrdenar.getItemAt(0).equals("Seleccionar")) {
            cbOrdenar.removeItemAt(0);
        }
        ordenarLista(filtrado);
        updateTableProducts();
    }//GEN-LAST:event_cbOrdenarItemStateChanged

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        carrito.forEach(producto -> System.out.println(producto.toString()));
        
        try {
            var res = new VentaDAO().crearVenta(UserLogged.getID(), carrito, total);
            if(!res) throw new Error();
            
            JOptionPane.showMessageDialog(
                    this, 
                    "Se registró su reserva de compra con éxito. Puede realizar la compra en la sucursal.", 
                    "Pedido completado", 
                    JOptionPane.INFORMATION_MESSAGE
            );
            
            carrito.clear();
            productos = ProductosDAO.getAllProducts();
            updateTableProducts();
            updateTableCart();
        } catch (SQLException | Error ex ) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar registrar su pedido. Inténtelo más tarde.", "Error inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int selected = tblProducts.getSelectedRow();
        var id = String.valueOf(tblProducts.getValueAt(selected, 0));
        var cantidad = sldCantidad.getValue();
        boolean updated = false;

        for (var values : carrito) {
            if (values.getId() == Integer.parseInt(id)) {
                var producto = findProductoById(Integer.parseInt(id));
                int updatedStock = producto.getId() - cantidad;
                producto.setStock(updatedStock);
                values.setCantidad(cantidad);
                updated = true;
            }
        }

        if (!updated) {
            carrito.add(new CarritoModelo(findProductoById(Integer.parseInt(id)), cantidad));
        }

        //Actualizar la tabla carrito
        updateTableCart();

        // Actualizar total
        updateTotal();

        //Actualizar el stock de forma local
        updateStockRow(Integer.parseInt(id), String.valueOf(cantidad), false);

        //Actualizar el el estado de los botones
        btnEliminar.setEnabled(false);
        btnComprar.setEnabled(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void sldCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCantidadStateChanged
        lblCantidad.setText("Cantidad: " + sldCantidad.getValue());
        if (sldCantidad.getValue() > 0)
            btnAgregar.setEnabled(true);
        else
            btnAgregar.setEnabled(false);
    }//GEN-LAST:event_sldCantidadStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selected = tblCarrito.getSelectedRow();
        var id = String.valueOf(tblCarrito.getValueAt(selected, 0));
        var cantidad = String.valueOf(tblCarrito.getValueAt(selected, 2));

        carrito.remove(selected);
        updateTableCart();

        //Actualizar total
        updateTotal();

        //Actualizar stock
        updateStockRow(Integer.parseInt(id), cantidad, true);

        if (carrito.isEmpty())
            btnComprar.setEnabled(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new InicioClientes().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(InicioClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblTotal;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound2;
    private javax.swing.JLabel placeholder;
    private javax.swing.JLabel search;
    private javax.swing.JSlider sldCantidad;
    private rojerusan.RSTableMetro tblCarrito;
    private rojerusan.RSTableMetro tblProducts;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
