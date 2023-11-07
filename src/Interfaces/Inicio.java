/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

/**
 *
 * @author JMMOLLER
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        var view = new Login();
        view.setImageLabel(this.lblLogo, "logo.png");
        view.setIconFrame(this);

        paintGraph(10, 3);
    }
    
    private void paintGraph(int total, int complete){
        PanelGraph.repaint();

        int tareasPendientes = total - complete;

        double porcentajeCompletadas = (double) complete / total;
        double porcentajePendientes = (double) tareasPendientes / total;

        int anguloCompletadas = (int) (porcentajeCompletadas * 360);
        int anguloPendientes = (int) (porcentajePendientes * 360);

        Graphics graph = PanelGraph.getGraphics();

        graph.setColor(Color.GREEN);
        graph.fillArc(50, 50, 100, 100, 0, anguloCompletadas);
        graph.setColor(Color.RED);
        graph.fillArc(50, 50, 100, 100, anguloCompletadas, anguloPendientes);
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

        panelRound1 = new util.PanelRound();
        btnClose = new javax.swing.JButton();
        panelNav = new util.PanelRound();
        lblLogo = new javax.swing.JLabel();
        sectionHome = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sectionReport = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        contentRecent = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitleRecent = new javax.swing.JLabel();
        contentClients = new javax.swing.JPanel();
        lblTitleClients = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        contentProducts = new javax.swing.JPanel();
        lblTitleProducts = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        contentPendings = new javax.swing.JPanel();
        lblTitlePendings = new javax.swing.JLabel();
        lblPenText = new javax.swing.JLabel();
        PanelGraph = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        lblPenText1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        panelRound1.setBackground(new java.awt.Color(35, 35, 35));
        panelRound1.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cerrar.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setDefaultCapable(false);
        btnClose.setFocusPainted(false);
        btnClose.setFocusable(false);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosehandleClick(evt);
            }
        });
        panelRound1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1243, 10, 25, 25));

        panelNav.setBackground(new java.awt.Color(251, 176, 47));
        panelNav.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelNav.setRoundBottomLeft(30);
        panelNav.setRoundBottomRight(30);
        panelNav.setRoundTopLeft(30);
        panelNav.setRoundTopRight(30);
        panelNav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo-150.png"))); // NOI18N
        lblLogo.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        panelNav.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 160, 110));

        sectionHome.setBackground(new java.awt.Color(255, 135, 9));
        sectionHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sectionHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sectionHomeMouseExited(evt);
            }
        });
        sectionHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/home-50.png"))); // NOI18N
        sectionHome.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inicio");
        sectionHome.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 17, -1, -1));

        panelNav.add(sectionHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 60));

        sectionReport.setBackground(new java.awt.Color(251, 176, 47));
        sectionReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sectionReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sectionReportMouseExited(evt);
            }
        });
        sectionReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/analysis-50.png"))); // NOI18N
        sectionReport.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Reporte");
        sectionReport.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 17, -1, -1));

        panelNav.add(sectionReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 60));

        panelRound1.add(panelNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 720));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("¡Bienvenido, usuario!");
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        contentRecent.setBackground(new java.awt.Color(35, 35, 35));
        contentRecent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha venta", "Producto", "Cantidad", "Cliente", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        contentRecent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 540, 300));

        lblTitleRecent.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        lblTitleRecent.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleRecent.setText("Ventas Recientes");
        contentRecent.add(lblTitleRecent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelRound1.add(contentRecent, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 540, 340));

        contentClients.setBackground(new java.awt.Color(35, 35, 35));
        contentClients.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleClients.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        lblTitleClients.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleClients.setText("Mejores Clientes");
        contentClients.add(lblTitleClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        contentClients.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 350, 220));

        panelRound1.add(contentClients, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 350, 260));

        contentProducts.setBackground(new java.awt.Color(35, 35, 35));
        contentProducts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleProducts.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        lblTitleProducts.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleProducts.setText("Productos Más Vendidos");
        contentProducts.add(lblTitleProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        contentProducts.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 340, 220));

        panelRound1.add(contentProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 440, 340, 260));

        contentPendings.setBackground(new java.awt.Color(35, 35, 35));
        contentPendings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitlePendings.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        lblTitlePendings.setForeground(new java.awt.Color(255, 255, 255));
        lblTitlePendings.setText("Ventas Pendientes");
        contentPendings.add(lblTitlePendings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblPenText.setForeground(new java.awt.Color(255, 255, 255));
        lblPenText.setText("Pendientes: 0");
        contentPendings.add(lblPenText, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 228, -1, -1));

        PanelGraph.setBackground(new java.awt.Color(35, 35, 35));
        PanelGraph.setFocusable(false);
        PanelGraph.setRequestFocusEnabled(false);

        javax.swing.GroupLayout PanelGraphLayout = new javax.swing.GroupLayout(PanelGraph);
        PanelGraph.setLayout(PanelGraphLayout);
        PanelGraphLayout.setHorizontalGroup(
            PanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        PanelGraphLayout.setVerticalGroup(
            PanelGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        contentPendings.add(PanelGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 180, 170));

        jPanel2.setBackground(new java.awt.Color(153, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        contentPendings.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 225, -1, -1));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        contentPendings.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 220, 5, 30));

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        contentPendings.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 225, -1, -1));

        lblPenText1.setForeground(new java.awt.Color(255, 255, 255));
        lblPenText1.setText("Completados: 0");
        contentPendings.add(lblPenText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 229, -1, -1));

        panelRound1.add(contentPendings, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 440, 290, 260));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 431, 10, 270));
        panelRound1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 1050, 10));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        panelRound1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 431, 10, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClosehandleClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosehandleClick
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnClosehandleClick

    private void sectionHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionHomeMouseEntered
        this.handleCursorChange(true);
    }//GEN-LAST:event_sectionHomeMouseEntered

    private void sectionHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionHomeMouseExited
        this.handleCursorChange(false);
    }//GEN-LAST:event_sectionHomeMouseExited

    private void sectionReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionReportMouseEntered
        this.handleCursorChange(true);
    }//GEN-LAST:event_sectionReportMouseEntered

    private void sectionReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sectionReportMouseExited
        this.handleCursorChange(false);
    }//GEN-LAST:event_sectionReportMouseExited

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
    private javax.swing.JPanel PanelGraph;
    private javax.swing.JButton btnClose;
    private javax.swing.JPanel contentClients;
    private javax.swing.JPanel contentPendings;
    private javax.swing.JPanel contentProducts;
    private javax.swing.JPanel contentRecent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPenText;
    private javax.swing.JLabel lblPenText1;
    private javax.swing.JLabel lblTitleClients;
    private javax.swing.JLabel lblTitlePendings;
    private javax.swing.JLabel lblTitleProducts;
    private javax.swing.JLabel lblTitleRecent;
    private util.PanelRound panelNav;
    private util.PanelRound panelRound1;
    private javax.swing.JPanel sectionHome;
    private javax.swing.JPanel sectionReport;
    // End of variables declaration//GEN-END:variables
}
