/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.ProductoModelo;
import DAO.ProductosDAO;
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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JMMOLLER
 */
public class InicioClientes extends javax.swing.JFrame {

    private DefaultTableModel model;
    private DefaultTableModel modelCarrito;
    private SwingWorker<Void, Void> searchWorker;
    private final List<ProductoModelo> productos = ProductosDAO.getAllProducts();
    private final List<ProductoModelo> filtrado = new ArrayList<>(productos);
    private final List<ProductoModelo> carrito = new ArrayList<>();
    private String lastText = "";

    /**
     * Creates new form ProductosClientes
     *
     * @throws java.sql.SQLException
     */
    public InicioClientes() throws SQLException {
        initComponents();
        setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        updateTableList();
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
                // Simular una búsqueda que puede llevar tiempo
                // Sustituye esto con tu lógica de búsqueda real
                System.out.println("Realizando búsqueda para: " + textoBusqueda);
                filtrado.clear();
                for (int i = 0; i < productos.size(); i++) {
                    // Simular la espera
                    Thread.sleep(50);
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
                updateTableList();
                return null;
            }

            @Override
            protected void done() {
            }
        };

        // Ejecutar el SwingWorker
        searchWorker.execute();
    }

    private void updateTableList() {
        model.setRowCount(0);
        filtrado.forEach(producto -> {
            model.addRow(new Object[]{
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getStock(),
                producto.getPrecio()
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
        int selected = tblProducts.getSelectedRow();
        int stock = Integer.parseInt(tblProducts.getValueAt(selected, 2).toString());
        
        sldCantidad.setMaximum(stock);
        
        btnComprar.setEnabled(true);
        btnComprar.setBackground(new Color(51, 204, 0));
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
                "Nombre", "Cantidad", "Precio"
            }
        );
        tblCarrito = new rojerusan.RSTableMetro();
        tblCarrito.setModel(modelCarrito);
        jScrollPane8 = new javax.swing.JScrollPane();
        model = new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String [] {
                "Nombre ", "Descripción", "Stock", "Precio",
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
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

        tblCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ));
        tblCarrito.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane9.setViewportView(tblCarrito);

        panelRound1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 270, 180));

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
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

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
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setBackground(new java.awt.Color(255, 0, 0));
        panelRound2.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 40, 40));

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
        placeholder.setText("Buscar algo...");
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
        panelRound2.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 7, 190, 25));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 240, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carrito");
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, -1, -1));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelRound1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 230, -1, -1));

        sldCantidad.setMaximum(0);
        sldCantidad.setValue(0);
        sldCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldCantidadStateChanged(evt);
            }
        });
        panelRound1.add(sldCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 233, 180, -1));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad: 0");
        panelRound1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 210, -1, -1));

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
        initializeSearch();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cbOrdenarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrdenarItemStateChanged
        if (cbOrdenar.getItemAt(0).equals("Seleccionar")) {
            cbOrdenar.removeItemAt(0);
        }
        ordenarLista(filtrado);
        updateTableList();
    }//GEN-LAST:event_cbOrdenarItemStateChanged

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnComprarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        System.out.println(sldCantidad.getValue());
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void sldCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldCantidadStateChanged
        lblCantidad.setText("Cantidad: "+sldCantidad.getValue());
    }//GEN-LAST:event_sldCantidadStateChanged

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
    private javax.swing.JComboBox<String> cbOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblCantidad;
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
