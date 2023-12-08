/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.MySQLConexion;

import util.RenderImage;

/**
 *
 * @author JMMOLLER
 */
public class Inicio extends javax.swing.JFrame {
    private int total_p = 10;
    private int pendientes = 3;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        var RI = new RenderImage(this);
        RI.setImageLabel(jlFotoUsuario, "siNoTieneFoto2.jpg");
        
        RI.setIconFrame();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        cargarProductosPorDefecto();
        cargarProveedoresPorDefecto();
        cargarProveedores();
        cargarProductos();
        cargarAlmacen();
        cargarRoles();
        cargarUsuarios();
        
    }

private void cargarProveedores() {
    try (Connection connection = MySQLConexion.getConexion()) {
        String sql = "SELECT nombre FROM proveedores";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                List<String> proveedores = new ArrayList<>();
                while (resultSet.next()) {
                    proveedores.add(resultSet.getString("nombre"));
                }
                cbProveedores.setModel(new DefaultComboBoxModel<>(proveedores.toArray(new String[0])));
            }
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
}
private void cargarProductos() {
    try (Connection connection = MySQLConexion.getConexion()) {
        String sql = "SELECT nombre FROM productos";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                List<String> proveedores = new ArrayList<>();
                while (resultSet.next()) {
                    proveedores.add(resultSet.getString("nombre"));
                }
                cbProductos.setModel(new DefaultComboBoxModel<>(proveedores.toArray(new String[0])));
            }
        }
    } catch (SQLException e) {
        System.out.println(e.toString());
    }
}

    
    private void mostrarPendientes(int total, int completado, Graphics graph) {
        lblPenText1.setText("Pendiente(s): " + Integer.toString(total - completado));
        lblPenTextC1.setText("Completado(s): " + completado);
        graficar(total, completado, graph);
    }
    
    public void graficar(int total, int completado, Graphics graph){

        int tareasPendientes = total - completado;

        double porcentajeCompletadas = (double) completado / total;
        double porcentajePendientes = (double) tareasPendientes / total;

        int anguloCompletadas = (int) (porcentajeCompletadas * 360);
        int anguloPendientes = (int) (porcentajePendientes * 360);

        int radio = 100;
        int centroPanel = 75; // Mitad de 150 (tamaño del JPanel)
        int centroCirculo = centroPanel - radio / 2; // Centra el círculo en el JPanel
        Color color_completado = new Color(102,255,102); // Crea el color para los completados
        Color color_pendiene = new Color(255,255,51); // Crea el color para los pendientes

        graph.setColor(color_completado);
        graph.fillArc(centroCirculo, centroCirculo, radio, radio, 0, anguloCompletadas);
        graph.setColor(color_pendiene);
        graph.fillArc(centroCirculo, centroCirculo, radio, radio, anguloCompletadas, anguloPendientes);
    }
    
    public void handleCursorChange(boolean mouseEntered){
        if(mouseEntered){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else{
            this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelGraph = new javax.swing.JPanel(){
            @Override
            public void paint(Graphics graph){
                super.paint(graph);

                mostrarPendientes(total_p, pendientes, graph);
            }
        };
        rSProgressCircleAnimatedBeanInfo1 = new rojerusan.componentes.RSProgressCircleAnimatedBeanInfo();
        panelRound1 = new util.PanelRound();
        DashBoard = new util.PanelRound();
        lblLogo = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        Provedores = new javax.swing.JButton();
        exit = new util.PanelRound();
        jButton7 = new javax.swing.JButton();
        panelRound2 = new util.PanelRound();
        jlFotoUsuario = new javax.swing.JLabel();
        rSButtonCustom1 = new rsbuttoncustom.RSButtonCustom();
        rSButtonCustom2 = new rsbuttoncustom.RSButtonCustom();
        btnInventario = new javax.swing.JButton();
        panelPrincipal = new util.PanelRound();
        panelHome = new util.PanelRound();
        jLabel7 = new javax.swing.JLabel();
        contentRecent1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        lblTitleRecent1 = new javax.swing.JLabel();
        contentClients1 = new javax.swing.JPanel();
        lblTitleClients1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        contentProducts1 = new javax.swing.JPanel();
        lblTitleProducts1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        contentPendings1 = new javax.swing.JPanel();
        lblTitlePendings1 = new javax.swing.JLabel();
        lblPenText1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        lblPenTextC1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        panelUsuarios = new util.PanelRound();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfNombreUsuario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfContraseñaUsuario = new javax.swing.JPasswordField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnCrearUsuario = new rsbuttongradiente.RSButtonGradiente();
        tfBuscarUsuarios = new javax.swing.JTextField();
        btnBuscarUsuarios = new rsbuttongradiente.RSButtonGradiente();
        btnEliminarUsuarios = new rsbuttongradiente.RSButtonGradiente();
        btnModificarUsuarios = new rsbuttongradiente.RSButtonGradiente();
        btnMostrarUsuarios = new rsbuttongradiente.RSButtonGradiente();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableUsuarios = new rojerusan.RSTableMetro();
        tfActivoUUU = new javax.swing.JTextField();
        tfCorreoUUU = new javax.swing.JTextField();
        cbRolUUU = new javax.swing.JComboBox<>();
        panelProductos = new util.PanelRound();
        jLabel2 = new javax.swing.JLabel();
        btnBuscar = new rsbuttongradiente.RSButtonGradiente();
        tfBuscar = new javax.swing.JTextField();
        rSButtonGradiente2 = new rsbuttongradiente.RSButtonGradiente();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new rojerusan.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taDescripcionProducto = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfAlmacenProducto = new javax.swing.JTextField();
        tfNombreProducto = new javax.swing.JTextField();
        tfPrecioProducto = new javax.swing.JTextField();
        tfCategoriaProducto = new javax.swing.JTextField();
        tfStockProducto = new javax.swing.JTextField();
        btnEliminar = new rsbuttongradiente.RSButtonGradiente();
        btnModificar = new rsbuttongradiente.RSButtonGradiente();
        btnMostrarProductos = new rsbuttongradiente.RSButtonGradiente();
        panelProvedores = new util.PanelRound();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfNombreProvedor = new javax.swing.JTextField();
        tfTelefonoProvedor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfDireccionProvedor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCorreoProvedor = new javax.swing.JTextField();
        btnCrearProvedor = new rsbuttongradiente.RSButtonGradiente();
        tfBuscarProvedor = new javax.swing.JTextField();
        btnBuscarProvedor = new rsbuttongradiente.RSButtonGradiente();
        btnEliminarProvedor = new rsbuttongradiente.RSButtonGradiente();
        btnModificarProvedor = new rsbuttongradiente.RSButtonGradiente();
        btnMostrarProvedor = new rsbuttongradiente.RSButtonGradiente();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProvedor = new rojerusan.RSTableMetro();
        panelInventario = new util.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbProveedores = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfCantidadProducto = new javax.swing.JTextField();
        cbProductos = new javax.swing.JComboBox<>();
        btnIngresarProductoAlmacen = new rsbuttongradiente.RSButtonGradiente();
        tfBuscarInventario = new javax.swing.JTextField();
        btnBuscarProvedor1 = new rsbuttongradiente.RSButtonGradiente();
        btnEliminarProvedor1 = new rsbuttongradiente.RSButtonGradiente();
        btnModificarProvedor1 = new rsbuttongradiente.RSButtonGradiente();
        btnMostrarProvedor1 = new rsbuttongradiente.RSButtonGradiente();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableAlmacen = new rojerusan.RSTableMetro();

        PanelGraph.setBackground(new java.awt.Color(35, 35, 35));
        PanelGraph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        PanelGraph.setFocusable(false);
        PanelGraph.setRequestFocusEnabled(false);

        javax.swing.GroupLayout PanelGraphLayout = new javax.swing.GroupLayout(PanelGraph);
        PanelGraph.setLayout(PanelGraphLayout);
        PanelGraphLayout.setHorizontalGroup(
            PanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        PanelGraphLayout.setVerticalGroup(
            PanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        panelRound1.setBackground(new java.awt.Color(35, 35, 35));
        panelRound1.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashBoard.setBackground(new java.awt.Color(27, 27, 27));
        DashBoard.setPreferredSize(new java.awt.Dimension(1230, 570));
        DashBoard.setRoundBottomLeft(30);
        DashBoard.setRoundTopLeft(30);
        DashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-150.png"))); // NOI18N
        lblLogo.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        DashBoard.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 150));

        btnHome.setBackground(new java.awt.Color(27, 27, 27));
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/casa (1).png"))); // NOI18N
        btnHome.setText("            Home");
        btnHome.setContentAreaFilled(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        DashBoard.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 40));

        btnUsuarios.setBackground(new java.awt.Color(27, 27, 27));
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario.png"))); // NOI18N
        btnUsuarios.setText("          Usuarios");
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        DashBoard.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 250, 40));

        btnProductos.setBackground(new java.awt.Color(27, 27, 27));
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/gas.png"))); // NOI18N
        btnProductos.setText("       Productos");
        btnProductos.setContentAreaFilled(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        DashBoard.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 40));

        Provedores.setBackground(new java.awt.Color(27, 27, 27));
        Provedores.setForeground(new java.awt.Color(255, 255, 255));
        Provedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/proveedor.png"))); // NOI18N
        Provedores.setText("      Provedores");
        Provedores.setContentAreaFilled(false);
        Provedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Provedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProvedoresActionPerformed(evt);
            }
        });
        DashBoard.add(Provedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, 40));

        exit.setBackground(new java.awt.Color(43, 209, 195));
        exit.setRoundBottomLeft(15);
        exit.setRoundBottomRight(15);
        exit.setRoundTopLeft(15);
        exit.setRoundTopRight(15);

        jButton7.setBackground(new java.awt.Color(27, 27, 27));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Exit");
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exitLayout = new javax.swing.GroupLayout(exit);
        exit.setLayout(exitLayout);
        exitLayout.setHorizontalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        exitLayout.setVerticalGroup(
            exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DashBoard.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, 40));

        panelRound2.setBackground(new java.awt.Color(56, 56, 56));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jlFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/siNoTieneFoto2.jpg"))); // NOI18N
        jlFotoUsuario.setText("jLabel1");

        rSButtonCustom1.setBackground(new java.awt.Color(27, 27, 27));
        rSButtonCustom1.setForeground(new java.awt.Color(43, 209, 195));
        rSButtonCustom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/configuraciones.png"))); // NOI18N
        rSButtonCustom1.setColorMaterial(new java.awt.Color(43, 209, 195));
        rSButtonCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonCustom1ActionPerformed(evt);
            }
        });

        rSButtonCustom2.setBackground(new java.awt.Color(27, 27, 27));
        rSButtonCustom2.setForeground(new java.awt.Color(43, 209, 195));
        rSButtonCustom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/imagen.png"))); // NOI18N
        rSButtonCustom2.setColorMaterial(new java.awt.Color(43, 209, 195));
        rSButtonCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonCustom2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSButtonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFotoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(rSButtonCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rSButtonCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DashBoard.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 200, 160));

        btnInventario.setBackground(new java.awt.Color(27, 27, 27));
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/inventario (1).png"))); // NOI18N
        btnInventario.setText("        Inventario");
        btnInventario.setContentAreaFilled(false);
        btnInventario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });
        DashBoard.add(btnInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 40));

        panelRound1.add(DashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 630));

        panelPrincipal.setBackground(new java.awt.Color(35, 35, 35));
        panelPrincipal.setRoundBottomLeft(30);
        panelPrincipal.setRoundBottomRight(30);
        panelPrincipal.setRoundTopLeft(30);
        panelPrincipal.setRoundTopRight(30);
        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelHome.setBackground(new java.awt.Color(35, 35, 35));
        panelHome.setRoundBottomRight(30);
        panelHome.setRoundTopRight(30);

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("¡Bienvenido, usuario!");

        contentRecent1.setBackground(new java.awt.Color(35, 35, 35));
        contentRecent1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Producto", "Cantidad", "Cliente", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        contentRecent1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 410, 220));

        lblTitleRecent1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblTitleRecent1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleRecent1.setText("Ventas Recientes");
        contentRecent1.add(lblTitleRecent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        contentClients1.setBackground(new java.awt.Color(35, 35, 35));
        contentClients1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleClients1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblTitleClients1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleClients1.setText("Mejores Clientes");
        contentClients1.add(lblTitleClients1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombres", "Total compras"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        contentClients1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 330, 170));

        contentProducts1.setBackground(new java.awt.Color(35, 35, 35));
        contentProducts1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleProducts1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblTitleProducts1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleProducts1.setText("Productos Más Vendidos");
        contentProducts1.add(lblTitleProducts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Stock"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        contentProducts1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 350, 160));

        contentPendings1.setBackground(new java.awt.Color(35, 35, 35));
        contentPendings1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitlePendings1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        lblTitlePendings1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitlePendings1.setText("Ventas Pendientes");
        contentPendings1.add(lblTitlePendings1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblPenText1.setForeground(new java.awt.Color(255, 255, 255));
        lblPenText1.setText("Pendiente(s): 0");
        contentPendings1.add(lblPenText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, -1));

        jPanel4.setBackground(new java.awt.Color(102, 255, 102));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPendings1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        contentPendings1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        lblPenTextC1.setForeground(new java.awt.Color(255, 255, 255));
        lblPenTextC1.setText("Completado(s): 0");
        contentPendings1.add(lblPenTextC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        contentPendings1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                            .addComponent(contentRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(contentPendings1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7)
                        .addGroup(panelHomeLayout.createSequentialGroup()
                            .addComponent(contentClients1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(contentProducts1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentRecent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentPendings1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentProducts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contentClients1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHomeLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelPrincipal.add(panelHome, "card2");

        panelUsuarios.setBackground(new java.awt.Color(35, 35, 35));

        jLabel20.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("Usuarios");

        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setText("Nombre:");

        tfNombreUsuario.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreUsuario.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreUsuario.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreUsuarioActionPerformed(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Contraseña:");

        tfContraseñaUsuario.setBackground(new java.awt.Color(56, 56, 56));
        tfContraseñaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfContraseñaUsuario.setForeground(new java.awt.Color(204, 204, 204));
        tfContraseñaUsuario.setBorder(new EmptyBorder(10,10,10,10));
        tfContraseñaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseñaUsuarioActionPerformed(evt);
            }
        });

        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("Activo:");

        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Correo:");

        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("Rol:");

        btnCrearUsuario.setBackground(new java.awt.Color(43, 209, 195));
        btnCrearUsuario.setText("Crear Usuario");
        btnCrearUsuario.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnCrearUsuario.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnCrearUsuario.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        tfBuscarUsuarios.setBackground(new java.awt.Color(56, 56, 56));
        tfBuscarUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfBuscarUsuarios.setForeground(new java.awt.Color(204, 204, 204));
        tfBuscarUsuarios.setText("Buscar por Nombre, Rol y Activo");
        tfBuscarUsuarios.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfBuscarUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarUsuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarUsuariosFocusLost(evt);
            }
        });
        tfBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarUsuariosActionPerformed(evt);
            }
        });

        btnBuscarUsuarios.setBackground(new java.awt.Color(43, 209, 195));
        btnBuscarUsuarios.setText("Buscar");
        btnBuscarUsuarios.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnBuscarUsuarios.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnBuscarUsuarios.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuariosActionPerformed(evt);
            }
        });

        btnEliminarUsuarios.setBackground(new java.awt.Color(43, 209, 195));
        btnEliminarUsuarios.setText("Eliminar");
        btnEliminarUsuarios.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnEliminarUsuarios.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnEliminarUsuarios.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnEliminarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuariosActionPerformed(evt);
            }
        });

        btnModificarUsuarios.setBackground(new java.awt.Color(43, 209, 195));
        btnModificarUsuarios.setText("Editar");
        btnModificarUsuarios.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnModificarUsuarios.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnModificarUsuarios.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnModificarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuariosActionPerformed(evt);
            }
        });

        btnMostrarUsuarios.setBackground(new java.awt.Color(43, 209, 195));
        btnMostrarUsuarios.setText("Todos");
        btnMostrarUsuarios.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnMostrarUsuarios.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnMostrarUsuarios.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnMostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUsuariosActionPerformed(evt);
            }
        });

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre ", "activo", "Rol", "Correo", "Creación", "Modificado"
            }
        ));
        tableUsuarios.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane8.setViewportView(tableUsuarios);

        tfActivoUUU.setBackground(new java.awt.Color(56, 56, 56));
        tfActivoUUU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfActivoUUU.setForeground(new java.awt.Color(204, 204, 204));
        tfActivoUUU.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfActivoUUU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfActivoUUUActionPerformed(evt);
            }
        });

        tfCorreoUUU.setBackground(new java.awt.Color(56, 56, 56));
        tfCorreoUUU.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCorreoUUU.setForeground(new java.awt.Color(204, 204, 204));
        tfCorreoUUU.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfCorreoUUU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCorreoUUUActionPerformed(evt);
            }
        });

        cbRolUUU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(561, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosLayout.createSequentialGroup()
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbRolUUU, 0, 256, Short.MAX_VALUE)
                            .addComponent(tfNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(tfContraseñaUsuario))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(tfCorreoUUU, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(tfActivoUUU)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelUsuariosLayout.createSequentialGroup()
                        .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20)
                            .addGroup(panelUsuariosLayout.createSequentialGroup()
                                .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMostrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfBuscarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                            .addComponent(jScrollPane8))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel20)
                .addGap(28, 28, 28)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel23)
                    .addComponent(tfActivoUUU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(tfCorreoUUU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(cbRolUUU, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        panelPrincipal.add(panelUsuarios, "card3");

        panelProductos.setBackground(new java.awt.Color(35, 35, 35));
        panelProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Listado Productos");
        panelProductos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(43, 209, 195));
        btnBuscar.setText("Buscar");
        btnBuscar.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnBuscar.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnBuscar.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelProductos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 88, 40));

        tfBuscar.setBackground(new java.awt.Color(56, 56, 56));
        tfBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfBuscar.setForeground(new java.awt.Color(204, 204, 204));
        tfBuscar.setText("Buscar por nombre, precio y categoria");
        tfBuscar.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarFocusLost(evt);
            }
        });
        tfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarActionPerformed(evt);
            }
        });
        panelProductos.add(tfBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 698, 40));

        rSButtonGradiente2.setBackground(new java.awt.Color(43, 209, 195));
        rSButtonGradiente2.setText("Crear producto");
        rSButtonGradiente2.setColorPrimario(new java.awt.Color(43, 209, 195));
        rSButtonGradiente2.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        rSButtonGradiente2.setColorSecundario(new java.awt.Color(0, 102, 102));
        rSButtonGradiente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonGradiente2ActionPerformed(evt);
            }
        });
        panelProductos.add(rSButtonGradiente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 153, -1));

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Descripción", "Precio", "Stock", "Categoria", "Almacen "
            }
        ));
        tableProductos.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(tableProductos);
        if (tableProductos.getColumnModel().getColumnCount() > 0) {
            tableProductos.getColumnModel().getColumn(5).setHeaderValue("Categoria");
            tableProductos.getColumnModel().getColumn(6).setHeaderValue("Almacen ");
        }

        panelProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 698, 180));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Nombre:");
        panelProductos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Descripción:");
        panelProductos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        taDescripcionProducto.setBackground(new java.awt.Color(56, 56, 56));
        taDescripcionProducto.setColumns(20);
        taDescripcionProducto.setForeground(new java.awt.Color(204, 204, 204));
        taDescripcionProducto.setRows(5);
        taDescripcionProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(56, 56, 56)));
        taDescripcionProducto.setCaretColor(new java.awt.Color(56, 56, 56));
        taDescripcionProducto.setDisabledTextColor(new java.awt.Color(56, 56, 56));
        taDescripcionProducto.setSelectedTextColor(new java.awt.Color(56, 56, 56));
        taDescripcionProducto.setSelectionColor(new java.awt.Color(56, 56, 56));
        taDescripcionProducto.setVerifyInputWhenFocusTarget(false);
        taDescripcionProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taDescripcionProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taDescripcionProducto);

        panelProductos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 256, 100));

        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Precio:");
        panelProductos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Stock:");
        panelProductos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Categoria:");
        panelProductos.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Almacen:");
        panelProductos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        tfAlmacenProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfAlmacenProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfAlmacenProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfAlmacenProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfAlmacenProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAlmacenProductoActionPerformed(evt);
            }
        });
        panelProductos.add(tfAlmacenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 256, 40));

        tfNombreProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreProductoActionPerformed(evt);
            }
        });
        panelProductos.add(tfNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 256, 40));

        tfPrecioProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfPrecioProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfPrecioProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfPrecioProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPrecioProductoActionPerformed(evt);
            }
        });
        panelProductos.add(tfPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 256, 40));

        tfCategoriaProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfCategoriaProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCategoriaProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfCategoriaProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfCategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCategoriaProductoActionPerformed(evt);
            }
        });
        panelProductos.add(tfCategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 256, 40));

        tfStockProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfStockProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfStockProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfStockProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfStockProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStockProductoActionPerformed(evt);
            }
        });
        panelProductos.add(tfStockProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 256, 40));

        btnEliminar.setBackground(new java.awt.Color(43, 209, 195));
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnEliminar.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnEliminar.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelProductos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 88, 40));

        btnModificar.setBackground(new java.awt.Color(43, 209, 195));
        btnModificar.setText("Editar");
        btnModificar.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnModificar.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnModificar.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panelProductos.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 88, 40));

        btnMostrarProductos.setBackground(new java.awt.Color(43, 209, 195));
        btnMostrarProductos.setText("Todos");
        btnMostrarProductos.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnMostrarProductos.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnMostrarProductos.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnMostrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProductosActionPerformed(evt);
            }
        });
        panelProductos.add(btnMostrarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 88, 40));

        panelPrincipal.add(panelProductos, "card4");

        panelProvedores.setBackground(new java.awt.Color(35, 35, 35));

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Listado Provedores");

        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Dirección: ");

        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Nombre:");

        tfNombreProvedor.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreProvedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreProvedor.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreProvedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfNombreProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreProvedorActionPerformed(evt);
            }
        });

        tfTelefonoProvedor.setBackground(new java.awt.Color(56, 56, 56));
        tfTelefonoProvedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfTelefonoProvedor.setForeground(new java.awt.Color(204, 204, 204));
        tfTelefonoProvedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfTelefonoProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonoProvedorActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Telefono:");

        tfDireccionProvedor.setBackground(new java.awt.Color(56, 56, 56));
        tfDireccionProvedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDireccionProvedor.setForeground(new java.awt.Color(204, 204, 204));
        tfDireccionProvedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfDireccionProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionProvedorActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Correo");

        tfCorreoProvedor.setBackground(new java.awt.Color(56, 56, 56));
        tfCorreoProvedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCorreoProvedor.setForeground(new java.awt.Color(204, 204, 204));
        tfCorreoProvedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfCorreoProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCorreoProvedorActionPerformed(evt);
            }
        });

        btnCrearProvedor.setBackground(new java.awt.Color(43, 209, 195));
        btnCrearProvedor.setText("Crear Provedor");
        btnCrearProvedor.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnCrearProvedor.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnCrearProvedor.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnCrearProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProvedorActionPerformed(evt);
            }
        });

        tfBuscarProvedor.setBackground(new java.awt.Color(56, 56, 56));
        tfBuscarProvedor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfBuscarProvedor.setForeground(new java.awt.Color(204, 204, 204));
        tfBuscarProvedor.setText("Buscar por id, nombre y dirección");
        tfBuscarProvedor.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfBuscarProvedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarProvedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarProvedorFocusLost(evt);
            }
        });
        tfBuscarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarProvedorActionPerformed(evt);
            }
        });

        btnBuscarProvedor.setBackground(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor.setText("Buscar");
        btnBuscarProvedor.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnBuscarProvedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnBuscarProvedorFocusGained(evt);
            }
        });
        btnBuscarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvedorActionPerformed(evt);
            }
        });

        btnEliminarProvedor.setBackground(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor.setText("Eliminar");
        btnEliminarProvedor.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnEliminarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProvedorActionPerformed(evt);
            }
        });

        btnModificarProvedor.setBackground(new java.awt.Color(43, 209, 195));
        btnModificarProvedor.setText("Editar");
        btnModificarProvedor.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnModificarProvedor.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnModificarProvedor.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnModificarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProvedorActionPerformed(evt);
            }
        });

        btnMostrarProvedor.setBackground(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor.setText("Todos");
        btnMostrarProvedor.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnMostrarProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProvedorActionPerformed(evt);
            }
        });

        tableProvedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Direccion", "Telefono", "Correo"
            }
        ));
        tableProvedor.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane3.setViewportView(tableProvedor);

        javax.swing.GroupLayout panelProvedoresLayout = new javax.swing.GroupLayout(panelProvedores);
        panelProvedores.setLayout(panelProvedoresLayout);
        panelProvedoresLayout.setHorizontalGroup(
            panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvedoresLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProvedoresLayout.createSequentialGroup()
                        .addComponent(btnBuscarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfBuscarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addGroup(panelProvedoresLayout.createSequentialGroup()
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProvedoresLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProvedoresLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)))
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDireccionProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCorreoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefonoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelProvedoresLayout.setVerticalGroup(
            panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProvedoresLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProvedoresLayout.createSequentialGroup()
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDireccionProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(panelProvedoresLayout.createSequentialGroup()
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTelefonoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCorreoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(18, 18, 18)
                .addComponent(btnCrearProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfBuscarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProvedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelProvedores, "card5");

        panelInventario.setBackground(new java.awt.Color(35, 35, 35));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Inventario de la empresa");

        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Proveedor");

        cbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Proveedor" }));
        cbProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProveedoresActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Producto");

        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Cantidad");

        tfCantidadProducto.setBackground(new java.awt.Color(56, 56, 56));
        tfCantidadProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfCantidadProducto.setForeground(new java.awt.Color(204, 204, 204));
        tfCantidadProducto.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfCantidadProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCantidadProductoActionPerformed(evt);
            }
        });

        cbProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Prodcuto" }));

        btnIngresarProductoAlmacen.setBackground(new java.awt.Color(43, 209, 195));
        btnIngresarProductoAlmacen.setText("Ingresar a Almacen");
        btnIngresarProductoAlmacen.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnIngresarProductoAlmacen.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnIngresarProductoAlmacen.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnIngresarProductoAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarProductoAlmacenActionPerformed(evt);
            }
        });

        tfBuscarInventario.setBackground(new java.awt.Color(56, 56, 56));
        tfBuscarInventario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfBuscarInventario.setForeground(new java.awt.Color(204, 204, 204));
        tfBuscarInventario.setText("Buscar por Fecha, Proveedor y Producto");
        tfBuscarInventario.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfBuscarInventario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarInventarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarInventarioFocusLost(evt);
            }
        });
        tfBuscarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBuscarInventarioActionPerformed(evt);
            }
        });

        btnBuscarProvedor1.setBackground(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor1.setText("Buscar");
        btnBuscarProvedor1.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor1.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnBuscarProvedor1.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnBuscarProvedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProvedor1ActionPerformed(evt);
            }
        });

        btnEliminarProvedor1.setBackground(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor1.setText("Eliminar");
        btnEliminarProvedor1.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor1.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnEliminarProvedor1.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnEliminarProvedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProvedor1ActionPerformed(evt);
            }
        });

        btnModificarProvedor1.setBackground(new java.awt.Color(43, 209, 195));
        btnModificarProvedor1.setText("Editar");
        btnModificarProvedor1.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnModificarProvedor1.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnModificarProvedor1.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnModificarProvedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProvedor1ActionPerformed(evt);
            }
        });

        btnMostrarProvedor1.setBackground(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor1.setText("Todos");
        btnMostrarProvedor1.setColorPrimario(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor1.setColorPrimarioHover(new java.awt.Color(43, 209, 195));
        btnMostrarProvedor1.setColorSecundario(new java.awt.Color(0, 102, 102));
        btnMostrarProvedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarProvedor1ActionPerformed(evt);
            }
        });

        tableAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Fecha ", "Producto", "Cantidad", "Precio", "Total", "Proveedor"
            }
        ));
        tableAlmacen.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        jScrollPane7.setViewportView(tableAlmacen);

        javax.swing.GroupLayout panelInventarioLayout = new javax.swing.GroupLayout(panelInventario);
        panelInventario.setLayout(panelInventarioLayout);
        panelInventarioLayout.setHorizontalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addComponent(btnIngresarProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(panelInventarioLayout.createSequentialGroup()
                                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInventarioLayout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(32, 32, 32)
                                        .addComponent(cbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelInventarioLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37))
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInventarioLayout.createSequentialGroup()
                                .addComponent(btnBuscarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnEliminarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnModificarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnMostrarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelInventarioLayout.setVerticalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(27, 27, 27)
                .addComponent(btnIngresarProductoAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarProvedor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelInventario, "card6");

        panelRound1.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 770, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        panelHome.setVisible(true);
        panelUsuarios.setVisible(false);
        panelProductos.setVisible(false);
        panelProvedores.setVisible(false);
        panelInventario.setVisible(false);
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        panelHome.setVisible(false);
        panelUsuarios.setVisible(true);
        panelProductos.setVisible(false);
        panelProvedores.setVisible(false);
        panelInventario.setVisible(false);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        panelHome.setVisible(false);
        panelUsuarios.setVisible(false);
        panelProductos.setVisible(true);
        panelProvedores.setVisible(false);
        panelInventario.setVisible(false);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void ProvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProvedoresActionPerformed
        panelHome.setVisible(false);
        panelUsuarios.setVisible(false);
        panelProductos.setVisible(false);
        panelProvedores.setVisible(true);
        panelInventario.setVisible(false);
    }//GEN-LAST:event_ProvedoresActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        panelHome.setVisible(false);
        panelUsuarios.setVisible(false);
        panelProductos.setVisible(false);
        panelProvedores.setVisible(false);
        panelInventario.setVisible(true);
    }//GEN-LAST:event_btnInventarioActionPerformed

    private void rSButtonCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCustom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonCustom1ActionPerformed

    private void rSButtonCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonCustom2ActionPerformed
        JFileChooser jf = new JFileChooser();
            jf.setMultiSelectionEnabled(false);

            if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jf.getSelectedFile();
                try {
                    BufferedImage originalImage = ImageIO.read(selectedFile);
                    int newWidth = 100;  
                    int newHeight = 130; 
                    Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
  
                    BufferedImage bufferedResizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
                    bufferedResizedImage.getGraphics().drawImage(resizedImage, 0, 0, null);
                    ImageIO.write(bufferedResizedImage, "png", new File("src/Imagenes/siNoTieneFoto2.jpg"));

                    jlFotoUsuario.setIcon(new ImageIcon(resizedImage));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }//GEN-LAST:event_rSButtonCustom2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void taDescripcionProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taDescripcionProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_taDescripcionProductoMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String criterio = tfBuscar.getText();
        String sql = "SELECT * FROM productos WHERE nombre LIKE ? OR precio LIKE ? OR categoria LIKE ?";

        try (Connection conexion = MySQLConexion.getConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, "%" + criterio + "%");
            ps.setString(2, "%" + criterio + "%");
            ps.setString(3, "%" + criterio + "%");
            ResultSet rs = ps.executeQuery();
            DefaultTableModel modeloTabla = (DefaultTableModel) tableProductos.getModel();
            modeloTabla.setRowCount(0);
            while (rs.next()) {
                Object[] fila = {rs.getString("id"),rs.getString("nombre"), rs.getString("descripción"), rs.getString("precio"), rs.getString("stock"),rs.getString("categoria"), rs.getString("almacen")};
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tfAlmacenProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAlmacenProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAlmacenProductoActionPerformed

    private void tfNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreProductoActionPerformed

    private void tfPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPrecioProductoActionPerformed

    private void tfCategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCategoriaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCategoriaProductoActionPerformed

    private void tfStockProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStockProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStockProductoActionPerformed

    private void rSButtonGradiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonGradiente2ActionPerformed
        String nombre=tfNombreProducto.getText();
        String descripcion=taDescripcionProducto.getText();
        String precio=tfPrecioProducto.getText();
        String stock=tfStockProducto.getText();
        String categoria=tfStockProducto.getText();
        String almacen=tfAlmacenProducto.getText();
        
        if (nombre.isEmpty()||descripcion.isEmpty()||almacen.isEmpty()||precio.isEmpty()||categoria.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
        }else{
            String sql="INSERT into productos (nombre,descripción,precio,stock,categoria,almacen) VALUES (?,?,?,?,?,?)";
            try (Connection conexion= MySQLConexion.getConexion()){
                try(PreparedStatement ps=conexion.prepareStatement(sql)){
                    ps.setString(1, nombre);
                    ps.setString(2, descripcion);
                    ps.setInt(3, Integer.parseInt(precio));
                    ps.setString(4, stock);
                    ps.setString(5, categoria);
                    ps.setString(6, almacen);
                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        cargarProductosPorDefecto();
                        JOptionPane.showMessageDialog(null, "Inserción exitosa");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al insertar el producto");
                    }
                    
                }
            } catch (Exception e) {
                 System.out.println(e.toString());
            }
        }
       
        
        
        
    }//GEN-LAST:event_rSButtonGradiente2ActionPerformed

    private void tfBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusGained
        if (tfBuscar.getText().equals("Buscar por nombre, precio y categoria")) {
                    tfBuscar.setText("");
                }
    }//GEN-LAST:event_tfBuscarFocusGained

    private void tfBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusLost
        if (tfBuscar.getText().isEmpty()) {
                    tfBuscar.setText("Buscar por nombre, precio y categoria");
                }
    }//GEN-LAST:event_tfBuscarFocusLost

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int filaSeleccionada = tableProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tableProductos.getModel();
            String id = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

            modeloTabla.removeRow(filaSeleccionada);
            eliminarFilaEnBaseDeDatos(id);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // Obtener los nuevos valores desde los campos de texto
        String nuevoNombre = tfNombreProducto.getText();
        String nuevaDescripcion = taDescripcionProducto.getText();
        String nuevoPrecio = tfPrecioProducto.getText();
        String nuevoStock = tfStockProducto.getText();
        String nuevaCategoria = tfCategoriaProducto.getText();
        String nuevoAlmacen = tfAlmacenProducto.getText();

        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = tableProductos.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el modelo de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) tableProductos.getModel();

            // Obtener el valor de la columna "id" de la fila seleccionada
            String id = modeloTabla.getValueAt(filaSeleccionada, 0).toString();

            // Realizar la actualización en la base de datos
            actualizarFilaEnBaseDeDatos(id, nuevoNombre, nuevaDescripcion, nuevoPrecio, nuevoStock, nuevaCategoria, nuevoAlmacen);
            cargarProductosPorDefecto();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para modificar.");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnMostrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProductosActionPerformed
        cargarProductosPorDefecto();
    }//GEN-LAST:event_btnMostrarProductosActionPerformed

    private void tfNombreProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreProvedorActionPerformed

    private void tfTelefonoProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonoProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefonoProvedorActionPerformed

    private void tfDireccionProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionProvedorActionPerformed

    private void tfCorreoProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCorreoProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCorreoProvedorActionPerformed

    private void btnCrearProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProvedorActionPerformed
        String nombre=tfNombreProvedor.getText().trim();
        String direccion=tfDireccionProvedor.getText().trim();
        String telefono=tfTelefonoProvedor.getText().trim();
        String correo=tfCorreoProvedor.getText().trim();
        if(nombre.isEmpty()||correo.isEmpty()||telefono.isEmpty()||correo.isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos son obligaotios, por favor llenar todos");
            return;
        }else if(!telefono.matches("\\d{9}")){
            JOptionPane.showMessageDialog(this, "Formato de teléfono incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
             return;
        }else if(!correo.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")){
            JOptionPane.showMessageDialog(this, "Formato de correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
        }else{
            String sql="INSERT INTO proveedores (nombre,dirección,teléfono,correo) values(?,?,?,?)";
            try(Connection conexion=MySQLConexion.getConexion()) {
                try(PreparedStatement ps=conexion.prepareStatement(sql)) {
                    ps.setString(1, nombre);
                    ps.setString(2, direccion);
                    ps.setString(3, telefono);
                    ps.setString(4, correo);
                    int filasAfectadas=ps.executeUpdate();
                    if (filasAfectadas>0){
                        JOptionPane.showMessageDialog(this, "Provedor agregado exitosamente");
                        cargarProductosPorDefecto();
                    }else{
                        JOptionPane.showMessageDialog(this, "Error al insertar provedor");
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            
        }
      
        
    }//GEN-LAST:event_btnCrearProvedorActionPerformed

    private void tfBuscarProvedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarProvedorFocusGained
        if(tfBuscarProvedor.getText().equals("Buscar por id, nombre y dirección")){
            tfBuscarProvedor.setText("");
        }
    }//GEN-LAST:event_tfBuscarProvedorFocusGained

    private void tfBuscarProvedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarProvedorFocusLost
        if (tfBuscarProvedor.getText().isEmpty()) {
                    tfBuscarProvedor.setText("Buscar por id, nombre y dirección");
        }
    }//GEN-LAST:event_tfBuscarProvedorFocusLost

    private void tfBuscarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarProvedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarProvedorActionPerformed

    private void tfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarActionPerformed

    private void btnBuscarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvedorActionPerformed
        String criterio=tfBuscarProvedor.getText();
        String sql="Select * from proveedores where id like ? or nombre like ? or dirección like ?";
        try (Connection conexion=MySQLConexion.getConexion()){
            try(PreparedStatement ps =conexion.prepareStatement(sql)){
                ps.setString(1, "%" + criterio + "%");
                ps.setString(2, "%" + criterio + "%");
                ps.setString(3, "%" + criterio + "%");
                ResultSet rs = ps.executeQuery();
                DefaultTableModel tabla=(DefaultTableModel) tableProvedor.getModel();
                tabla.setRowCount(0);
                while(rs.next()){
                    Object[] fila={rs.getString("id"),rs.getString("nombre"),rs.getString("dirección"),rs.getString("teléfono"),rs.getString("correo")};
                    tabla.addRow(fila);
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnBuscarProvedorActionPerformed

    private void btnEliminarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProvedorActionPerformed
        int filaSeleccionada=tableProvedor.getSelectedRow();
        if(filaSeleccionada!=-1){
            DefaultTableModel tabla=(DefaultTableModel) tableProvedor.getModel();
            String idProvedor=tabla.getValueAt(filaSeleccionada, 0).toString();
            tabla.removeRow(filaSeleccionada);
            String sql = "DELETE FROM proveedores WHERE id = ?";

            try (Connection conexion = MySQLConexion.getConexion();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {
                    ps.setString(1, idProvedor);
                int filasAfectadas = ps.executeUpdate();
                
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Proveedor Eliminado exitosamente!");
                } else {
                    System.out.println("No se pudo eliminar la fila de la base de datos.");
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar fila de la base de datos: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEliminarProvedorActionPerformed

    private void btnModificarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProvedorActionPerformed
        int filaSeleccionada=tableProvedor.getSelectedRow();
        String nombre=tfNombreProvedor.getText().trim();
        String direccion=tfDireccionProvedor.getText().trim();
        String telefono=tfTelefonoProvedor.getText().trim();
        String correo=tfCorreoProvedor.getText().trim();
        if(filaSeleccionada!=-1){
            DefaultTableModel tabla=(DefaultTableModel) tableProvedor.getModel();
            String idProvedor=tabla.getValueAt(filaSeleccionada, 0).toString();
            
            String sql = "UPDATE proveedores SET nombre = ?, dirección = ?, teléfono = ?, correo = ?WHERE id = ?";

            try (Connection conexion = MySQLConexion.getConexion();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {
                    ps.setString(1, nombre);
                    ps.setString(2, direccion);
                    ps.setString(3, telefono);
                    ps.setString(4, correo);
                    ps.setString(5, idProvedor);
                int filasAfectadas = ps.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Proveedor Actulizado exitosamente!");
                    cargarProveedoresPorDefecto();
                } else {
                    System.out.println("No se pudo actualizar la fila de la base de datos.");
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar fila de la base de datos: " + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnModificarProvedorActionPerformed

    private void btnMostrarProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProvedorActionPerformed
        cargarProveedoresPorDefecto();
    }//GEN-LAST:event_btnMostrarProvedorActionPerformed

    private void tfCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCantidadProductoActionPerformed

    private void btnIngresarProductoAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarProductoAlmacenActionPerformed
       String nombreProveedor = (String) cbProveedores.getSelectedItem();
    String nombreProducto = (String) cbProductos.getSelectedItem();
    int cantidad = Integer.parseInt(tfCantidadProducto.getText());
    BigDecimal idProveedor = obtenerCampo(nombreProveedor, "proveedores", "id");
    BigDecimal idProducto = obtenerCampo(nombreProducto, "productos", "id");
    BigDecimal precioProducto = obtenerCampo(nombreProducto, "productos", "precio");
    double montoTotal = precioProducto.doubleValue() * cantidad;

    String sqlInsertAlmacen = "INSERT INTO almacen (proveedor_id, producto_id, precio_compra, cantidad_unitaria) VALUES (?, ?, ?, ?)";
    String sqlUpdateProducto = "UPDATE productos SET stock = stock + ? WHERE id = ?";

    try (Connection conexion = MySQLConexion.getConexion()) {
        conexion.setAutoCommit(false);
        try (PreparedStatement psInsertAlmacen = conexion.prepareStatement(sqlInsertAlmacen);
             PreparedStatement psUpdateProducto = conexion.prepareStatement(sqlUpdateProducto)) {
            psInsertAlmacen.setInt(1, idProveedor.intValue());
            psInsertAlmacen.setInt(2, idProducto.intValue());
            psInsertAlmacen.setDouble(3, montoTotal);
            psInsertAlmacen.setInt(4, cantidad);

            psUpdateProducto.setInt(1, cantidad);
            psUpdateProducto.setInt(2, idProducto.intValue());

            psInsertAlmacen.executeUpdate();
            psUpdateProducto.executeUpdate();
            // Confirmar la transacción
            conexion.commit();
            JOptionPane.showMessageDialog(this, "Registro de almacén realizado exitosamente");
            cargarAlmacen();
            cargarProductosPorDefecto();
        } catch (SQLException ex) {
            // Si hay un error, hacer rollback
            conexion.rollback();
            JOptionPane.showMessageDialog(this, "Ocurrió un error en el registro al almacén");
            System.out.println(ex.toString());
        } finally {
            // Restaurar el modo de autocommit
            conexion.setAutoCommit(true);
        }
    } catch (SQLException ex) {
        System.out.println(ex.toString());
    }
    }//GEN-LAST:event_btnIngresarProductoAlmacenActionPerformed
    
    private BigDecimal obtenerCampo(String nombre, String tabla, String campo) {
    BigDecimal valorCampo = BigDecimal.ZERO;

    String sql = "SELECT p." + campo + " FROM " + tabla + " p WHERE p.nombre=?";
    
    try (Connection conexion = MySQLConexion.getConexion()) {
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    valorCampo = rs.getBigDecimal(campo);
                } else {
                    System.out.println("No se encontró el elemento con el nombre: " + nombre);
                }
            }
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener el campo " + campo + ": " + ex.toString());
    }

    return valorCampo;
}


    private void cbProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProveedoresActionPerformed
        
    }//GEN-LAST:event_cbProveedoresActionPerformed

    private void tfBuscarInventarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarInventarioFocusGained
        if(tfBuscarInventario.getText().equals("Buscar por Fecha, Proveedor y Producto")){
            tfBuscarInventario.setText("");
        }
    }//GEN-LAST:event_tfBuscarInventarioFocusGained

    private void tfBuscarInventarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarInventarioFocusLost
        if(tfBuscarInventario.getText().isEmpty()){
            tfBuscarInventario.setText("Buscar por Fecha, Proveedor y Producto");
        }
    
    }//GEN-LAST:event_tfBuscarInventarioFocusLost

    private void tfBuscarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarInventarioActionPerformed

    private void btnBuscarProvedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProvedor1ActionPerformed
        String criterio=tfBuscarInventario.getText();
        String sql="SELECT a.id, a.fecha_entrada,p.nombre as Producto,a.cantidad_unitaria,p.precio,a.precio_compra,pro.nombre as Proveedor FROM productos p INNER JOIN almacen a on  a.producto_id=p.id INNER JOIN proveedores pro on pro.id=a.proveedor_id WHERE a.fecha_entrada LIKE ? or pro.nombre like ? OR p.nombre like ?";
        if(criterio.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingresar la expresion que quiere buscar");
        }else{
            try(Connection conexion=MySQLConexion.getConexion()){
                try(PreparedStatement ps=conexion.prepareStatement(sql)){
                    ps.setString(1,"%" + criterio+ "%");
                    ps.setString(2,"%" + criterio+ "%");
                    ps.setString(3,"%" + criterio+ "%");
                    ResultSet rs= ps.executeQuery();
                    DefaultTableModel tabla= (DefaultTableModel) tableAlmacen.getModel();
                    tabla.setRowCount(0);
                    while(rs.next()){
                        Object[] fila={rs.getString("id"),rs.getString("fecha_entrada"),rs.getString("Producto"),rs.getString("cantidad_unitaria"),rs.getString("precio"),rs.getString("precio_compra"),rs.getString("Proveedor")};
                        tabla.addRow(fila);
                    }
                }
                
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnBuscarProvedor1ActionPerformed

    private void btnEliminarProvedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProvedor1ActionPerformed
        int filaSeleccionada = tableAlmacen.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel tabla = (DefaultTableModel) tableAlmacen.getModel();
            String nombreProducto = tabla.getValueAt(filaSeleccionada, 2).toString(); 
            String idalmacen = tabla.getValueAt(filaSeleccionada, 0).toString(); 
            System.out.println(nombreProducto);
            BigDecimal idProducto = obtenerCampo(nombreProducto, "productos", "id");
            System.out.println("el id es:"+idProducto);
            BigDecimal cantidadUnitaria = new BigDecimal(tabla.getValueAt(filaSeleccionada, 3).toString()); 
            System.out.println("cantidad"+cantidadUnitaria);
            tabla.removeRow(filaSeleccionada);

            String sqlEliminar = "DELETE FROM almacen WHERE id = ?";
            String sqlActualizarStock = "UPDATE productos SET stock = stock - ? WHERE id = ?";
            try (Connection conexion = MySQLConexion.getConexion()) {
                try (PreparedStatement psEliminar = conexion.prepareStatement(sqlEliminar)) {
                    psEliminar.setInt(1, Integer.parseInt(idalmacen));
                    int filasAfectadasEliminar = psEliminar.executeUpdate();
                    if (filasAfectadasEliminar > 0) {
                        try (PreparedStatement psActualizarStock = conexion.prepareStatement(sqlActualizarStock)) {
                            psActualizarStock.setInt(1, cantidadUnitaria.intValueExact());
                            psActualizarStock.setInt(2, idProducto.intValue());
                            int filasAfectadasActualizarStock = psActualizarStock.executeUpdate();

                            if (filasAfectadasActualizarStock > 0) {
                                JOptionPane.showMessageDialog(this, "Registro eliminado y stock actualizado exitosamente!");
                                cargarAlmacen();
                                cargarProductosPorDefecto();
                                cargarProductos();
                            } else {
                                System.out.println("No se pudo actualizar el stock del producto.");
                            }
                        }
                    } else {
                        System.out.println("No se pudo eliminar el registro de la tabla almacen.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al realizar la eliminación y actualizar el stock: " + e.getMessage());
            }
        }

           

    }//GEN-LAST:event_btnEliminarProvedor1ActionPerformed

    private void btnModificarProvedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProvedor1ActionPerformed
       String nuevoNombreProveedor = (String) cbProveedores.getSelectedItem();
                    String nuevoNombreProducto = (String) cbProductos.getSelectedItem();
                    String nuevaCantidad = tfCantidadProducto.getText();
        if(nuevoNombreProveedor.isEmpty()||nuevoNombreProducto.isEmpty()||nuevaCantidad.isEmpty()){
            JOptionPane.showMessageDialog(this, "No a completado todos los campos");
        }else{
        int filaSeleccionada = tableAlmacen.getSelectedRow();
        if (filaSeleccionada != -1) {
            DefaultTableModel tabla = (DefaultTableModel) tableAlmacen.getModel();
            String nombreProductoAntiguo = tabla.getValueAt(filaSeleccionada, 2).toString();
            BigDecimal idProductoAntiguo = obtenerCampo(nombreProductoAntiguo, "productos", "id");
            BigDecimal cantidadAntigua = new BigDecimal(tabla.getValueAt(filaSeleccionada, 3).toString());
            // Eliminar la cantidad asignada al antiguo producto
            String sqlRestarStockAntiguo = "UPDATE productos SET stock = stock - ? WHERE id = ?";
            try (Connection conexion = MySQLConexion.getConexion();
                 PreparedStatement psRestarStockAntiguo = conexion.prepareStatement(sqlRestarStockAntiguo)) {
                psRestarStockAntiguo.setBigDecimal(1, cantidadAntigua);
                psRestarStockAntiguo.setInt(2, idProductoAntiguo.intValue());
                int filasAfectadasRestarStockAntiguo = psRestarStockAntiguo.executeUpdate();

                if (filasAfectadasRestarStockAntiguo > 0) {
                    

                    BigDecimal idProductoNuevo = obtenerCampo(nuevoNombreProducto, "productos", "id");
                    BigDecimal idProveedorNuevo = obtenerCampo(nuevoNombreProveedor, "proveedores", "id");

                    tabla.setValueAt(nuevoNombreProveedor, filaSeleccionada, 6);
                    tabla.setValueAt(nuevoNombreProducto, filaSeleccionada, 2);
                    tabla.setValueAt(nuevaCantidad, filaSeleccionada, 3);

                     String sqlActualizar = "UPDATE almacen SET proveedor_id = ?, producto_id = ?, cantidad_unitaria = ? WHERE id = ?";

                    try (PreparedStatement psActualizar = conexion.prepareStatement(sqlActualizar)) {
                        psActualizar.setInt(1, idProveedorNuevo.intValue());
                        psActualizar.setInt(2, idProductoNuevo.intValue());
                        psActualizar.setInt(3, Integer.parseInt(nuevaCantidad));
                        psActualizar.setInt(4, Integer.parseInt(tabla.getValueAt(filaSeleccionada, 0).toString()));

                        int filasAfectadasActualizar = psActualizar.executeUpdate();

                        if (filasAfectadasActualizar > 0) {
                            // Restar el stock del nuevo producto
                            String sqlRestarStockNuevo = "UPDATE productos SET stock = stock + ? WHERE id = ?";
                            try (PreparedStatement psRestarStockNuevo = conexion.prepareStatement(sqlRestarStockNuevo)) {
                                psRestarStockNuevo.setInt(1, Integer.parseInt(nuevaCantidad));
                                psRestarStockNuevo.setInt(2, idProductoNuevo.intValue());

                                int filasAfectadasRestarStockNuevo = psRestarStockNuevo.executeUpdate();

                                if (filasAfectadasRestarStockNuevo > 0) {
                                    JOptionPane.showMessageDialog(this, "Registro actualizado y stock actualizado exitosamente!");
                                    cargarAlmacen();;
                                    cargarProductosPorDefecto();
                                } else {
                                    System.out.println("No se pudo actualizar el stock del nuevo producto.");
                                }
                            }
                        } else {
                            System.out.println("No se pudo actualizar el registro de la tabla almacen.");
                        }
                    }
                } else {
                    System.out.println("No se pudo restar el stock del producto antiguo.");
                }
            } catch (SQLException e) {
                System.out.println("Error al realizar la actualización y actualizar el stock: " + e.getMessage());
            }
        }
        }

    }//GEN-LAST:event_btnModificarProvedor1ActionPerformed

    private void btnMostrarProvedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarProvedor1ActionPerformed
        cargarAlmacen();
    }//GEN-LAST:event_btnMostrarProvedor1ActionPerformed

    private void btnBuscarProvedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnBuscarProvedorFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProvedorFocusGained

    private void tfNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreUsuarioActionPerformed

    private void tfContraseñaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseñaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseñaUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        String nombre = tfNombreUsuario.getText();
        String contra = new String(tfContraseñaUsuario.getPassword());
        String correo = tfCorreoUUU.getText();
        String rol = (String) cbRolUUU.getSelectedItem();
        String activo = tfActivoUUU.getText();

        if (nombre.isEmpty() || contra.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llenar todos los campos, solo se puede omitir el cmapo de activo");
        } else {
            String sqlInsert = "INSERT INTO usuarios(nombre, contraseña, activo, correo) VALUES (?, ?, ?, ?)";
            try (Connection conexion = MySQLConexion.getConexion()) {
                try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
                    psInsert.setString(1, nombre);
                    psInsert.setString(2, contra);
                    psInsert.setString(3, activo);
                    psInsert.setString(4, correo);
                    int filasAfectadas = psInsert.executeUpdate();
                    if (filasAfectadas > 0) {
                        int idUsuario = obtenerIdUsuario(conexion, nombre, contra, correo);
                        asignarRolUsuario(conexion, idUsuario, rol);
                        JOptionPane.showMessageDialog(this, "Usuario creado correctamente! con su rol respectivo asignado");
                    } else {
                        JOptionPane.showMessageDialog(this, "Usuario no se pudo crear");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed
   private int obtenerIdUsuario(Connection conexion, String nombre, String contra, String correo) throws SQLException {
    int idUsuario = -1;
    String sqlObtenerId = "SELECT id FROM usuarios WHERE nombre = ? AND contraseña = ? AND correo = ?";

    try (PreparedStatement psObtenerId = conexion.prepareStatement(sqlObtenerId)) {
        psObtenerId.setString(1, nombre);
        psObtenerId.setString(2, contra);
        psObtenerId.setString(3, correo);

        try (ResultSet resultSet = psObtenerId.executeQuery()) {
            if (resultSet.next()) {
                idUsuario = resultSet.getInt("id");
            }
        }
    }

    return idUsuario;
}
    private void asignarRolUsuario(Connection conexion, int idUsuario, String rol) {
    String sqlObtenerRolId = "SELECT id FROM rol WHERE nombreRol = ?";
    String sqlAsignarRol = "INSERT INTO rol_usuarios(rol_id, usuarios_id) VALUES (?, ?)";

    try (PreparedStatement psObtenerRolId = conexion.prepareStatement(sqlObtenerRolId)) {
        psObtenerRolId.setString(1, rol);

        try (ResultSet resultSet = psObtenerRolId.executeQuery()) {
            if (resultSet.next()) {
                int idRol = resultSet.getInt("id");

                try (PreparedStatement psAsignarRol = conexion.prepareStatement(sqlAsignarRol)) {
                    psAsignarRol.setInt(1, idRol);
                    psAsignarRol.setInt(2, idUsuario);

                    int filasAfectadas = psAsignarRol.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Rol asignado correctamente");
                    } else {
                        System.out.println("Error al asignar el rol");
                    }
                }
            } else {
                System.out.println("No se encontró el ID del rol");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    private void cargarRoles(){
        try (Connection connection = MySQLConexion.getConexion()) {
        String sql = "SELECT nombreRol FROM rol";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                List<String> rol = new ArrayList<>();
                while (resultSet.next()) {
                    rol.add(resultSet.getString("nombreRol"));
                }
                cbRolUUU.setModel(new DefaultComboBoxModel<>(rol.toArray(new String[0])));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    private void tfBuscarUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarUsuariosFocusGained
        if(tfBuscarUsuarios.getText().equals("Buscar por Nombre, Rol y Activo")){
            tfBuscarUsuarios.setText("");
        }
    }//GEN-LAST:event_tfBuscarUsuariosFocusGained

    private void tfBuscarUsuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarUsuariosFocusLost
        if (tfBuscarUsuarios.getText().isEmpty()) {
            tfBuscarUsuarios.setText("Buscar por Nombre, Rol y Activo");
        }
    }//GEN-LAST:event_tfBuscarUsuariosFocusLost

    private void tfBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBuscarUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBuscarUsuariosActionPerformed

    private void btnBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosActionPerformed
        String criterio=tfBuscarUsuarios.getText();
        if (criterio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "LLenar el campo de busqueda");
        }else{
            String sql="SELECT u.id,u.nombre,u.activo,ro.nombreRol,u.correo,u.fecha_creacion,u.fecha_modificacion FROM rol ro INNER JOIN rol_usuarios r on ro.id=r.rol_id INNER JOIN usuarios u on u.id=r.usuarios_id where u.nombre like ? or ro.nombreRol like ? or u.activo like ? ";
            try (Connection con =MySQLConexion.getConexion()){
                try(PreparedStatement ps =con.prepareStatement(sql)){
                    ps.setString(1, "%" + criterio + "%");
                    ps.setString(2, "%" + criterio + "%");
                    ps.setString(3, "%" + criterio + "%");
                    try(ResultSet rs=ps.executeQuery()){
                        DefaultTableModel tabla= (DefaultTableModel)tableUsuarios.getModel();
                        tabla.setRowCount(0);
                        while(rs.next()){
                           Object[] fila={
                                rs.getString("u.id"),
                                rs.getString("u.nombre"),
                                rs.getString("u.activo"),
                                rs.getString("ro.nombreRol"),
                                rs.getString("u.correo"),
                                rs.getString("u.fecha_creacion"),
                                rs.getString("u.fecha_modificacion"),
                            };
                            tabla.addRow(fila);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_btnBuscarUsuariosActionPerformed

    private void btnEliminarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuariosActionPerformed
        int filaSelecionada=tableUsuarios.getSelectedRow();
        if (filaSelecionada!=-1) {
            DefaultTableModel tabla=(DefaultTableModel) tableUsuarios.getModel();
            String id=tabla.getValueAt(filaSelecionada, 0).toString();
            tabla.removeRow(filaSelecionada);
            eliminarFilaEnBaseDeDatos2(id);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarUsuariosActionPerformed

    private void btnModificarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuariosActionPerformed
        String nombre = tfNombreUsuario.getText();
        String contra = new String(tfContraseñaUsuario.getPassword());
        String correo = tfCorreoUUU.getText();
        String rol = (String) cbRolUUU.getSelectedItem();
        String activo = tfActivoUUU.getText();
        
        int filaSelecionada=tableUsuarios.getSelectedRow();
        if (filaSelecionada!=-1) {
            DefaultTableModel tabla=(DefaultTableModel) tableUsuarios.getModel();
            String id=tabla.getValueAt(filaSelecionada, 0).toString();
            editarUsuario(id,nombre,contra,correo,rol,activo);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para eliminar.");
        }
    }//GEN-LAST:event_btnModificarUsuariosActionPerformed
    public void editarUsuario(String id,String nombre,String contra, String correo, String rol, String activo){
        
        String sql="UPDATE usuarios\n" +
                    "SET nombre = ?, correo = ?, contraseña=?, activo=?\n" +
                    "WHERE id = ?;";
        try (Connection con=MySQLConexion.getConexion()){
            try(PreparedStatement ps=con.prepareStatement(sql)){
                ps.setString(1, nombre);
                ps.setString(2, correo);
                ps.setString(3, contra);
                ps.setString(4, activo);
                ps.setString(5, id);
                int filas=ps.executeUpdate();
                if(filas>0){
                    String sqlRol="update rol_usuarios set rol_id=? where usuarios_id=?";
                    try (Connection co=MySQLConexion.getConexion()){
                        try(PreparedStatement pss=co.prepareStatement(sqlRol)){
                            if(rol.equals("Administrador")){
                                rol="1";
                            }else{
                                rol="2";
                            }
                            pss.setString(1, rol);
                            pss.setString(2, id);
                            int filasRol = pss.executeUpdate();
                            if (filasRol > 0) {
                                JOptionPane.showMessageDialog(this, "El usuario fue actualizado exitosamente!");
                                cargarUsuarios();
                            } else {
                                JOptionPane.showMessageDialog(this, "Ocurrió un error al actualizar el rol del usuario");
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Ocurrio un error al actualizar el usuario");
                }
               
            }
        } catch (Exception e) {
        }
    }
    private void btnMostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUsuariosActionPerformed
        cargarUsuarios();
    }//GEN-LAST:event_btnMostrarUsuariosActionPerformed
    
    public void cargarUsuarios(){
        String sql="SELECT u.id,u.nombre,u.activo,ro.nombreRol,u.correo,u.fecha_creacion,u.fecha_modificacion FROM rol ro INNER JOIN rol_usuarios r on ro.id=r.rol_id INNER JOIN usuarios u on u.id=r.usuarios_id";
        try(Connection con=MySQLConexion.getConexion()){
            try(PreparedStatement ps=con.prepareStatement(sql)){
                ResultSet rs =ps.executeQuery();
                DefaultTableModel tabla= (DefaultTableModel) tableUsuarios.getModel();
                tabla.setRowCount(0);
                while(rs.next()){
                    Object[] fila={
                        rs.getString("u.id"),
                        rs.getString("u.nombre"),
                        rs.getString("u.activo"),
                        rs.getString("ro.nombreRol"),
                        rs.getString("u.correo"),
                        rs.getString("u.fecha_creacion"),
                        rs.getString("u.fecha_modificacion"),
                    };
                    tabla.addRow(fila);
                }
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    private void tfActivoUUUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfActivoUUUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfActivoUUUActionPerformed

    private void tfCorreoUUUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCorreoUUUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCorreoUUUActionPerformed
    private void limpiarCamposDeTexto() {
    tfAlmacenProducto.setText("");
    taDescripcionProducto.setText("");
    tfPrecioProducto.setText("");
    tfStockProducto.setText("");
    tfCategoriaProducto.setText("");
    tfAlmacenProducto.setText("");
}
    private void actualizarFilaEnBaseDeDatos(String id, String nuevoNombre, String nuevaDescripcion, String nuevoPrecio, String nuevoStock, String nuevaCategoria, String nuevoAlmacen) {
    String sql = "UPDATE productos SET nombre = ?, descripción = ?, precio = ?, stock = ?, categoria = ?, almacen = ? WHERE id = ?";

    try (Connection conexion = MySQLConexion.getConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        // Establecer los parámetros en la consulta preparada
        ps.setString(1, nuevoNombre);
        ps.setString(2, nuevaDescripcion);
        ps.setString(3, nuevoPrecio);
        ps.setString(4, nuevoStock);
        ps.setString(5, nuevaCategoria);
        ps.setString(6, nuevoAlmacen);
        ps.setString(7, id);

        // Ejecutar la consulta de actualización en la base de datos
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Fila actualizada en la base de datos.");
        } else {
            System.out.println("No se pudo actualizar la fila en la base de datos.");
        }
    } catch (SQLException e) {
        System.out.println("Error al actualizar fila en la base de datos: " + e.getMessage());
    }
}
    private void eliminarFilaEnBaseDeDatos(String id) {
    String sql = "DELETE FROM productos WHERE id = ?";

    try (Connection conexion = MySQLConexion.getConexion();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        // Establecer el parámetro en la consulta preparada
        ps.setString(1, id);

        // Ejecutar la consulta de eliminación en la base de datos
        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Fila eliminada de la base de datos.");
        } else {
            System.out.println("No se pudo eliminar la fila de la base de datos.");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar fila de la base de datos: " + e.getMessage());
    }
    
}
private void eliminarFilaEnBaseDeDatos2(String id) {
    String deleteRolUsuariosSql = "DELETE FROM rol_usuarios WHERE usuarios_id = ?";
    try (Connection conexion = MySQLConexion.getConexion();
         PreparedStatement psDeleteRolUsuarios = conexion.prepareStatement(deleteRolUsuariosSql)) {
        psDeleteRolUsuarios.setString(1, id);
        psDeleteRolUsuarios.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error al eliminar registros relacionados en rol_usuarios: " + e.getMessage());
        return; 
    }
    String deleteUsuarioSql = "DELETE FROM usuarios WHERE id = ?";
    try (Connection conexion = MySQLConexion.getConexion();
         PreparedStatement psDeleteUsuario = conexion.prepareStatement(deleteUsuarioSql)) {
        psDeleteUsuario.setString(1, id);
        int filasAfectadas = psDeleteUsuario.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Fila eliminada de la base de datos.");
            JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente");
            cargarUsuarios();
        } else {
            System.out.println("No se pudo eliminar la fila de la base de datos.");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar fila de la base de datos: " + e.getMessage());
    }
}

     private void cargarProductosPorDefecto() {
        String sql = "SELECT * FROM productos";

        try (Connection conexion = MySQLConexion.getConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            // Limpiar el modelo de la tabla antes de agregar nuevos datos
            DefaultTableModel modeloTabla = (DefaultTableModel) tableProductos.getModel();
            modeloTabla.setRowCount(0);
            
            while (resultSet.next()) {
                Object[] fila = {
                    resultSet.getString("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("descripción"),
                    resultSet.getString("precio"),
                    resultSet.getString("stock"),
                    resultSet.getString("categoria"),
                    resultSet.getString("almacen")
                };
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar productos por defecto: " + e.getMessage());
        }
    }
     private void cargarProveedoresPorDefecto() {
        String sql = "SELECT * FROM proveedores";

        try (Connection conexion = MySQLConexion.getConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tableProvedor.getModel();
            modeloTabla.setRowCount(0);
            while (resultSet.next()) {
                Object[] fila = {
                    resultSet.getString("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("dirección"),
                    resultSet.getString("teléfono"),
                    resultSet.getString("correo"),
                };
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar proveedores por defecto: " + e.getMessage());
        }
    }
     private void cargarAlmacen() {
        String sql = "SELECT a.id, a.fecha_entrada,p.nombre as Producto,a.cantidad_unitaria,p.precio,a.precio_compra,pro.nombre as Proveedor FROM productos p INNER JOIN almacen a on  a.producto_id=p.id INNER JOIN proveedores pro on pro.id=a.proveedor_id";

        try (Connection conexion = MySQLConexion.getConexion();
             Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            DefaultTableModel modeloTabla = (DefaultTableModel) tableAlmacen.getModel();
            modeloTabla.setRowCount(0);
            while (resultSet.next()) {
                Object[] fila = {
                    resultSet.getString("id"),
                    resultSet.getString("fecha_entrada"),
                    resultSet.getString("Producto"),
                    resultSet.getString("cantidad_unitaria"),
                    resultSet.getString("precio"),
                    resultSet.getString("precio_compra"),
                    resultSet.getString("Proveedor"),
                };
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar proveedores por defecto: " + e.getMessage());
        }
    }
     
    

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.PanelRound DashBoard;
    private javax.swing.JPanel PanelGraph;
    private javax.swing.JButton Provedores;
    private rsbuttongradiente.RSButtonGradiente btnBuscar;
    private rsbuttongradiente.RSButtonGradiente btnBuscarProvedor;
    private rsbuttongradiente.RSButtonGradiente btnBuscarProvedor1;
    private rsbuttongradiente.RSButtonGradiente btnBuscarUsuarios;
    private rsbuttongradiente.RSButtonGradiente btnCrearProvedor;
    private rsbuttongradiente.RSButtonGradiente btnCrearUsuario;
    private rsbuttongradiente.RSButtonGradiente btnEliminar;
    private rsbuttongradiente.RSButtonGradiente btnEliminarProvedor;
    private rsbuttongradiente.RSButtonGradiente btnEliminarProvedor1;
    private rsbuttongradiente.RSButtonGradiente btnEliminarUsuarios;
    private javax.swing.JButton btnHome;
    private rsbuttongradiente.RSButtonGradiente btnIngresarProductoAlmacen;
    private javax.swing.JButton btnInventario;
    private rsbuttongradiente.RSButtonGradiente btnModificar;
    private rsbuttongradiente.RSButtonGradiente btnModificarProvedor;
    private rsbuttongradiente.RSButtonGradiente btnModificarProvedor1;
    private rsbuttongradiente.RSButtonGradiente btnModificarUsuarios;
    private rsbuttongradiente.RSButtonGradiente btnMostrarProductos;
    private rsbuttongradiente.RSButtonGradiente btnMostrarProvedor;
    private rsbuttongradiente.RSButtonGradiente btnMostrarProvedor1;
    private rsbuttongradiente.RSButtonGradiente btnMostrarUsuarios;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JComboBox<String> cbProductos;
    private javax.swing.JComboBox<String> cbProveedores;
    private javax.swing.JComboBox<String> cbRolUUU;
    private javax.swing.JPanel contentClients1;
    private javax.swing.JPanel contentPendings1;
    private javax.swing.JPanel contentProducts1;
    private javax.swing.JPanel contentRecent1;
    private util.PanelRound exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JLabel jlFotoUsuario;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPenText1;
    private javax.swing.JLabel lblPenTextC1;
    private javax.swing.JLabel lblTitleClients1;
    private javax.swing.JLabel lblTitlePendings1;
    private javax.swing.JLabel lblTitleProducts1;
    private javax.swing.JLabel lblTitleRecent1;
    private util.PanelRound panelHome;
    private util.PanelRound panelInventario;
    private util.PanelRound panelPrincipal;
    private util.PanelRound panelProductos;
    private util.PanelRound panelProvedores;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound2;
    private util.PanelRound panelUsuarios;
    private rsbuttoncustom.RSButtonCustom rSButtonCustom1;
    private rsbuttoncustom.RSButtonCustom rSButtonCustom2;
    private rsbuttongradiente.RSButtonGradiente rSButtonGradiente2;
    private rojerusan.componentes.RSProgressCircleAnimatedBeanInfo rSProgressCircleAnimatedBeanInfo1;
    private javax.swing.JTextArea taDescripcionProducto;
    private rojerusan.RSTableMetro tableAlmacen;
    private rojerusan.RSTableMetro tableProductos;
    private rojerusan.RSTableMetro tableProvedor;
    private rojerusan.RSTableMetro tableUsuarios;
    private javax.swing.JTextField tfActivoUUU;
    private javax.swing.JTextField tfAlmacenProducto;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfBuscarInventario;
    private javax.swing.JTextField tfBuscarProvedor;
    private javax.swing.JTextField tfBuscarUsuarios;
    private javax.swing.JTextField tfCantidadProducto;
    private javax.swing.JTextField tfCategoriaProducto;
    private javax.swing.JPasswordField tfContraseñaUsuario;
    private javax.swing.JTextField tfCorreoProvedor;
    private javax.swing.JTextField tfCorreoUUU;
    private javax.swing.JTextField tfDireccionProvedor;
    private javax.swing.JTextField tfNombreProducto;
    private javax.swing.JTextField tfNombreProvedor;
    private javax.swing.JTextField tfNombreUsuario;
    private javax.swing.JTextField tfPrecioProducto;
    private javax.swing.JTextField tfStockProducto;
    private javax.swing.JTextField tfTelefonoProvedor;
    // End of variables declaration//GEN-END:variables
}
