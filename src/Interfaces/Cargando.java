/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Cargando extends javax.swing.JFrame implements Runnable{

    Thread h1;
    private boolean credencialesCorrectas;
    private String privilegios;
    
    public Cargando(boolean credencialesCorrectas,String privilegios) {
        this.credencialesCorrectas = credencialesCorrectas;
        this.privilegios=privilegios;
        initComponents();
        h1=new Thread(this);
        h1.start();
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        
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
        pCargando = new rojerusan.componentes.RSProgressCircleAnimated();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(35, 35, 35));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        pCargando.setBackground(new java.awt.Color(153, 153, 153));
        pCargando.setForeground(new java.awt.Color(43, 209, 195));
        pCargando.setColorText(new java.awt.Color(43, 209, 195));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(pCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Cargando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargando.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.componentes.RSProgressCircleAnimated pCargando;
    private util.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        if (credencialesCorrectas) {
        for (int i = 1; i < 101; i++) {
            pCargando.setValue(i);
            pCargando.setString(String.valueOf(i) + " %");
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cargando.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(privilegios.equals("Administrador")){
            dispose();
            Inicio view = new Inicio();
            view.setVisible(true);
        }else if(privilegios.equals("Cliente")){
            try {
                dispose();
                InicioClientes vie= new InicioClientes();
                vie.setVisible(true);
            } catch (SQLException ex) {
                System.out.println(ex.getCause());
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al iniciar el cliente. Por favor inténtelo más tarde.", "Error inesperado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

        
    }
}
