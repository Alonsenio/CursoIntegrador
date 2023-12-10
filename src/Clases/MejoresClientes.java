/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author JMMOLLER
 */
public class MejoresClientes {
    private final String nombre;
    private final int totalCompras;

    public MejoresClientes(String nombre, int totalCompras) {
        this.nombre = nombre;
        this.totalCompras = totalCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTotalCompras() {
        return totalCompras;
    }
}
