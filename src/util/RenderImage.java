/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author JMMOLLER
 */
public class RenderImage {
    private final JFrame frameRef;
    
    public RenderImage(JFrame frame){
        this.frameRef = frame;
    }
    
    public void setImageLabel(JLabel labelName, String resourceName) {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/imagenes/" + resourceName);
            if (inputStream != null) {
                ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
                Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                    labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH
                ));
                labelName.setIcon(icon);
                this.frameRef.repaint();
            } else {        
                System.err.println("No se pudo cargar la imagen: " + resourceName);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void setIconFrame(){
        try {
            InputStream inputStream = getClass().getResourceAsStream("/iconos/ico.png");
            if (inputStream != null) {
                ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
                this.frameRef.setIconImage(image.getImage());
            } else {        
                System.err.println("No se pudo cargar el icono");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
