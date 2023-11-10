/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import util.MySQLConexion;
import util.RenderImage;
import java.sql.*;

/**
 *
 * @author JMMOLLER
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        var RI = new RenderImage(this);
        RI.setImageLabel(Hero, "CamionGas.png");
        RI.setIconFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound = new util.PanelRound();
        panelRound3 = new util.PanelRound();
        panelRound4 = new util.PanelRound();
        btnRegistrar = new javax.swing.JButton();
        tfEmailUser = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfContraseñaUserR = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        tfNombreUserR = new javax.swing.JTextField();
        Hero = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1030, 570));

        panelRound.setBackground(new java.awt.Color(35, 35, 35));
        panelRound.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelRound.setRoundBottomLeft(30);
        panelRound.setRoundBottomRight(30);
        panelRound.setRoundTopLeft(30);
        panelRound.setRoundTopRight(30);
        panelRound.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound3.setBackground(new java.awt.Color(27, 27, 27));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(43, 209, 195));
        panelRound4.setForeground(new java.awt.Color(255, 255, 255));
        panelRound4.setToolTipText("");
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegistrar.setSelected(true);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarhandleLoginClick(evt);
            }
        });
        panelRound4.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        panelRound3.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 240, -1));

        tfEmailUser.setBackground(new java.awt.Color(56, 56, 56));
        tfEmailUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfEmailUser.setForeground(new java.awt.Color(204, 204, 204));
        tfEmailUser.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelRound3.add(tfEmailUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 236, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Usuario:");
        panelRound3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(43, 209, 195));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Registrate");
        panelRound3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, 60));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Email:");
        panelRound3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Contraseña:");
        panelRound3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        tfContraseñaUserR.setBackground(new java.awt.Color(56, 56, 56));
        tfContraseñaUserR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfContraseñaUserR.setForeground(new java.awt.Color(204, 204, 204));
        tfContraseñaUserR.setBorder(new EmptyBorder(10,10,10,10));
        tfContraseñaUserR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseñaUserRActionPerformed(evt);
            }
        });
        panelRound3.add(tfContraseñaUserR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 236, 40));

        jLabel6.setForeground(new java.awt.Color(255, 180, 40));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/editar (2).png"))); // NOI18N
        panelRound3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 80));

        tfNombreUserR.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreUserR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreUserR.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreUserR.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelRound3.add(tfNombreUserR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 236, 40));

        panelRound.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 320, 410));

        Hero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CamionGas.png"))); // NOI18N
        Hero.setPreferredSize(new java.awt.Dimension(589, 550));
        panelRound.add(Hero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 570));

        lblLogin.setForeground(new java.awt.Color(32, 158, 147));
        lblLogin.setText("¿Ya tienes cuenta?");
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginhandleRegisterClick(evt);
            }
        });
        panelRound.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, -1, -1));

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
        panelRound.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 18, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarLoginActionPerformed

    }//GEN-LAST:event_btnIngresarLoginActionPerformed

    private void lblLoginhandleRegisterClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginhandleRegisterClick
        Login view = new Login();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_lblLoginhandleRegisterClick

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarhandleLoginClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarhandleLoginClick
        String nombre = tfNombreUserR.getText();
    String email = tfEmailUser.getText();
    String contraseña = new String(tfContraseñaUserR.getPassword());

    String insertarUsuarioSQL  = "INSERT INTO usuarios (nombre, contraseña, activo, correo) VALUES(?, ?, ?, ?)";
    if (nombre.isEmpty() || email.isEmpty() || contraseña.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
    } else {
        try (Connection conexion = MySQLConexion.getConexion()) {
            int idUsuario;
            try (PreparedStatement ps = conexion.prepareStatement(insertarUsuarioSQL , Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nombre);
                ps.setString(2, contraseña);
                ps.setInt(3, 1);
                ps.setString(4, email);

                int filas = ps.executeUpdate();
                if (filas > 0) {
                    try (ResultSet id = ps.getGeneratedKeys()) {
                        if (id.next()) {
                            idUsuario = id.getInt(1);
                            
                            String sqlRolUsuarios = "INSERT INTO rol_usuarios (usuarios_id, rol_id) VALUES (?, ?)";
                            try (PreparedStatement psRolUsuarios = conexion.prepareStatement(sqlRolUsuarios)) {
                                psRolUsuarios.setInt(1, idUsuario);
                                psRolUsuarios.setInt(2, 2);
                                psRolUsuarios.executeUpdate();
                            }

                            System.out.println("Registro de usuario exitoso.");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    }//GEN-LAST:event_btnRegistrarhandleLoginClick

    private void tfContraseñaUserRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseñaUserRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseñaUserRActionPerformed

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setIcon(new ImageIcon(getClass().getResource("/Iconos/c11.png")));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setIcon(new ImageIcon(getClass().getResource("/Iconos/celestex.png")));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnClosehandleClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosehandleClick
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnClosehandleClick

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registro().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hero;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblLogin;
    private util.PanelRound panelRound;
    private util.PanelRound panelRound3;
    private util.PanelRound panelRound4;
    private javax.swing.JPasswordField tfContraseñaUserR;
    private javax.swing.JTextField tfEmailUser;
    private javax.swing.JTextField tfNombreUserR;
    // End of variables declaration//GEN-END:variables
}
