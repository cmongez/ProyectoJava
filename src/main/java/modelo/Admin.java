/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author cmongez
 */
public class Admin {
    private int idAdmin;    
    private String correo;
    private String contrasenia;

    public Admin() {
    }
    
    public Admin(int idAdmin, String correo, String contrasenia) {
        this.idAdmin = idAdmin;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
