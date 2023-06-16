/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Admin;

/**
 *
 * @author cmongez
 */
public class AdminDAO {

    public AdminDAO() {
    }
    
    public Admin obtenerAdminPorId(int idAdmin) {
       
        Admin admin = null;
        
        String query = "SELECT ID_ADMIN, CORREO FROM ADMIN WHERE ID_ADMIN = ?";
        
        System.out.println("obtenerAdmin query: "+query);

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setInt(1, idAdmin);
                ResultSet rs = sent.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setIdAdmin(rs.getInt("ID_CARGO"));
                admin.setCorreo(rs.getString("CORREO"));

            }
            
            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        return admin;
    }
    
    
    
    public Admin agregarAdmin(Admin admin) {

            System.out.println(admin.toString());

        Admin nuevoAdmin = null;

        String query = "INSERT INTO ADMIN (CORREO, CONTRASENIA) VALUES (?, ?)";

        System.out.println("insertarAdmin query: " + query);
        try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        

        try {
            PreparedStatement sent = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            sent.setString(1, admin.getCorreo());
            sent.setString(2, admin.getContrasenia());
            int filasInsertadas = sent.executeUpdate();
            // Verificar si se insertó al menos una fila
            if (filasInsertadas > 0) {
                ResultSet generatedKeys = sent.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    admin.setIdAdmin(idGenerado);
                    nuevoAdmin = admin;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    listarAdmin();
    return nuevoAdmin; // 
    }
public List<Admin> listarAdmin() {
    List<Admin> listaAdmin = new ArrayList<>();

    String query = "SELECT ID_ADMIN,CORREO FROM ADMIN ORDER BY CORREO";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        try {
            PreparedStatement sent = con.prepareStatement(query);
            ResultSet rs = sent.executeQuery();

            while (rs.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(rs.getInt("ID_ADMIN"));
                admin.setCorreo(rs.getString("CORREO"));
                listaAdmin.add(admin);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        con.close();

    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    
    return listaAdmin;
}

public String eliminarAdmin(int idAdmin) {

    String msg = "Admin NO FUE ELIMINADO CORRECTAMENTE.";
    String query = "DELETE FROM ADMIN WHERE ID_ADMIN = ?";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();

        try {
            PreparedStatement sent = con.prepareStatement(query);
            sent.setInt(1, idAdmin);
            int filaEliminada = sent.executeUpdate();

            // Verificar si se actualizó al menos una fila
            if (filaEliminada > 0) {
                msg = "ADMIN ELIMINADO CORRECTAMENTE."; // La eliminación fue exitosa
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    return msg;
}

public int actualizarAdmin(Admin admin) {
    int filasAgregadas = 0;
    

    String query = "UPDATE ADMIN SET CORREO=?, CONTRASENIA=? WHERE ID_ADMIN=?";
    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        PreparedStatement sent = con.prepareStatement(query);
        sent.setString(1, admin.getCorreo());
        sent.setString(2, admin.getContrasenia());
        sent.setInt(3, admin.getIdAdmin());


        
        filasAgregadas = sent.executeUpdate();
         System.out.println(filasAgregadas + "FILAAAAAAAAAAAAAAAAA");
         
        sent.close();
        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    return filasAgregadas;
}

}
