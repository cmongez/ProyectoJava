/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Login;
import modelo.Usuario;

/**
 *
 * @author cmongez
 */
public class LoginDAO {

    public LoginDAO() {
    }
     public boolean validarDatosLogin(Login dataLogin) {
        boolean datosValidos = false;

        String query = "SELECT  CORREO, CONTRASENIA FROM LOGIN WHERE CORREO = ? AND CONTRASENIA = ?";

        System.out.println("validarLogin query: " + query);

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setString(1, dataLogin.getCorreo());
                sent.setString(2, dataLogin.getContrasenia());

                ResultSet rs = sent.executeQuery();

                datosValidos = rs.next();
                rs.close();
                sent.close();
                con.close();

            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        return datosValidos;
    }

    
}
