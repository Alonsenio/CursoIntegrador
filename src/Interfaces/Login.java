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
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;



/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setImageLabel(jlLogin, "CamionGas.png");


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Interfaces.PanelRound();
        jlLogin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfNombreUser = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfContraseña = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        panelRound2 = new Interfaces.PanelRound();
        btnIngresarLogin = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        panelRound1.add(jlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 515, 554));

        jPanel1.setBackground(new java.awt.Color(27, 27, 27));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(43, 209, 195));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Iniciar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 18, -1, 56));

        jLabel5.setForeground(new java.awt.Color(255, 180, 40));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/usuario (1).png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 321, 46));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Usuario:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 132, -1, -1));

        tfNombreUser.setBackground(new java.awt.Color(56, 56, 56));
        tfNombreUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfNombreUser.setForeground(new java.awt.Color(204, 204, 204));
        tfNombreUser.setBorder(new EmptyBorder(10, 10, 10, 10));
        tfNombreUser.setCaretPosition(0);
        jPanel1.add(tfNombreUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 162, 236, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Contraseña");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 222, -1, -1));

        tfContraseña.setBackground(new java.awt.Color(56, 56, 56));
        tfContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfContraseña.setForeground(new java.awt.Color(204, 204, 204));
        tfContraseña.setBorder(new EmptyBorder(10,10,10,10));
        tfContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(tfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 252, 236, 40));

        jCheckBox1.setBackground(new java.awt.Color(27, 27, 27));
        jCheckBox1.setForeground(new java.awt.Color(153, 153, 153));
        jCheckBox1.setText("Mostrar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 304, 70, 30));

        panelRound2.setBackground(new java.awt.Color(43, 209, 195));
        panelRound2.setForeground(new java.awt.Color(255, 255, 255));
        panelRound2.setToolTipText("");
        panelRound2.setRoundBottomLeft(15);
        panelRound2.setRoundBottomRight(15);
        panelRound2.setRoundTopLeft(15);
        panelRound2.setRoundTopRight(15);

        btnIngresarLogin.setBackground(new java.awt.Color(255, 0, 0));
        btnIngresarLogin.setText("Ingresar");
        btnIngresarLogin.setContentAreaFilled(false);
        btnIngresarLogin.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnIngresarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIngresarLoginMouseClicked(evt);
            }
        });
        btnIngresarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(btnIngresarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIngresarLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sesión");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 18, -1, 56));

        panelRound1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, 410));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContraseñaActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            tfContraseña.setEchoChar((char) 0);
        } else {
            tfContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btnIngresarLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarLoginMouseClicked

    private void btnIngresarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarLoginActionPerformed

    }//GEN-LAST:event_btnIngresarLoginActionPerformed

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
    private void setImageLabel(JLabel labelName, String resourceName) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/imagenes/" + resourceName);
            if (inputStream != null) {
                ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
                Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
                labelName.setIcon(icon);
                this.repaint();
            } else {        
                System.err.println("No se pudo cargar la imagen: " + resourceName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarLogin;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlLogin;
    private Interfaces.PanelRound panelRound1;
    private Interfaces.PanelRound panelRound2;
    private javax.swing.JPasswordField tfContraseña;
    private javax.swing.JTextField tfNombreUser;
    // End of variables declaration//GEN-END:variables
}
