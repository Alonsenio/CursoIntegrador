/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author JMMOLLER
 */
public class UserLogged {
    private static int ID;
    private static String NOMBRE;
    private static String PASS;
    private static int ACTIVO;
    private static String CORREO;
    private static String FECHA_CREACION;
    private static String FECHA_MODIFICACION;
    private static String PRIVILEGIO;
    
    private static UserLogged isLogged;

    public UserLogged(int id, String nombre, String contraseña, int activo, String correo, String privilegio, String fechaCreacion, String fechaModificacion) {
        if(isLogged != null) throw new Error("Ya existe un usuario loggeado");
        
        ID = id;
        NOMBRE = nombre;
        PASS = contraseña;
        ACTIVO = activo;
        CORREO = correo;
        PRIVILEGIO = privilegio;
        FECHA_CREACION = fechaCreacion;
        FECHA_MODIFICACION = fechaModificacion;
        isLogged = this;
    }

    public static int getID() {
        return ID;
    }

    public static String getNOMBRE() {
        return NOMBRE;
    }

    public static String getPASS() {
        return PASS;
    }

    public static int getACTIVO() {
        return ACTIVO;
    }

    public static String getCORREO() {
        return CORREO;
    }

    public static String getFECHA_CREACION() {
        return FECHA_CREACION;
    }

    public static String getFECHA_MODIFICACION() {
        return FECHA_MODIFICACION;
    }

    public static String getPRIVILEGIO() {
        return PRIVILEGIO;
    }

    public static UserLogged getIsLogged() {
        return isLogged;
    }
    
}
