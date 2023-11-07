/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;



/**
 *
 * @author ASUS
 */
public final class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setImageLabel(jlLogin, "CamionGas.png");
        this.setIconFrame(this);
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
        jlLogin = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfNombreUser1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfContraseña1 = new javax.swing.JPasswordField();
        jCheckBox2 = new javax.swing.JCheckBox();
        panelRound3 = new util.PanelRound();
        btnIngresarLogin1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1030, 570));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1030, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(35, 35, 35));
        panelRound1.setPreferredSize(new java.awt.Dimension(1230, 530));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CamionGas.png"))); // NOI18N
        jlLogin.setText("jLabel1");
        jlLogin.setPreferredSize(new java.awt.Dimension(589, 550));
        panelRound1.add(jlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 570));

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
                handleClick(evt);
            }
        });
        panelRound1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 10, 25, 25));
        btnClose.getAccessibleContext().setAccessibleName("Cerrar ventana");

        jPanel2.setBackground(new java.awt.Color(27, 27, 27));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(43, 209, 195));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Iniciar");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 18, -1, 56));

        jLabel6.setForeground(new java.awt.Color(255, 180, 40));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario (1).png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 321, 46));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Usuario:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 132, -1, -1));

        tfNombreUser1.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreUser1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreUser1.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreUser1.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel2.add(tfNombreUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 162, 236, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Contraseña:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 222, -1, -1));

        tfContraseña1.setBackground(new java.awt.Color(56, 56, 56));
        tfContraseña1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfContraseña1.setForeground(new java.awt.Color(204, 204, 204));
        tfContraseña1.setBorder(new EmptyBorder(10,10,10,10));
        tfContraseña1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseña1ActionPerformed(evt);
            }
        });
        jPanel2.add(tfContraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 252, 236, 40));

        jCheckBox2.setBackground(new java.awt.Color(27, 27, 27));
        jCheckBox2.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox2.setText("Mostrar");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 304, 70, 30));

        panelRound3.setBackground(new java.awt.Color(43, 209, 195));
        panelRound3.setForeground(new java.awt.Color(255, 255, 255));
        panelRound3.setToolTipText("");
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresarLogin1.setBackground(new java.awt.Color(255, 0, 0));
        btnIngresarLogin1.setText("Ingresar");
        btnIngresarLogin1.setContentAreaFilled(false);
        btnIngresarLogin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresarLogin1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnIngresarLogin1.setSelected(true);
        btnIngresarLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarLogin1MouseClicked(evt);
            }
        });
        btnIngresarLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handleLoginClick(evt);
            }
        });
        panelRound3.add(btnIngresarLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

        jPanel2.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 240, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Sesión");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 18, -1, 56));

        panelRound1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, -1, 410));

        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setText("¿No tienes cuenta?");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleRegisterClick(evt);
            }
        });
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleDescription("Ir a ventana de registro");

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void handleClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleClick
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_handleClick

    private void tfContraseña1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseña1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseña1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void btnIngresarLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarLogin1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarLogin1MouseClicked

    private void handleRegisterClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleRegisterClick
        Registro view = new Registro();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_handleRegisterClick

    private void handleLoginClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handleLoginClick
        var view = new Inicio();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_handleLoginClick

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
    //Metodos
    public void setImageLabel(JLabel labelName, String resourceName) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/imagenes/" + resourceName);
            if (inputStream != null) {
                ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
                Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                    labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH
                ));
                labelName.setIcon(icon);
                this.repaint();
            } else {        
                System.err.println("No se pudo cargar la imagen: " + resourceName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setIconFrame(JFrame frame){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/iconos/ico.png");
            if (inputStream != null) {
                ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
                frame.setIconImage(image.getImage());
            } else {        
                System.err.println("No se pudo cargar el icono");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnIngresarLogin1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlLogin;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound3;
    private javax.swing.JPasswordField tfContraseña1;
    private javax.swing.JTextField tfNombreUser1;
    // End of variables declaration//GEN-END:variables
}
