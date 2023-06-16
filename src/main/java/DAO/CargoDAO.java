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
import modelo.Cargo;

/**
 *
 * @author cmongez
 */
public class CargoDAO {

    public CargoDAO() {
    }
    
    public Cargo obtenerCargoPorId(int idCargo) {
       
        Cargo cargo = null;
        
        String query = "SELECT ID_CARGO, ID_TIPO_CARGO, NOMBRE_CARGO FROM CARGO WHERE ID_CARGO = ?";
        
        System.out.println("obtenerCargo query: "+query);

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setInt(1, idCargo);
                ResultSet rs = sent.executeQuery();

            if (rs.next()) {
                cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("ID_CARGO"));
                cargo.setIdTipoCargo(rs.getInt("ID_TIPO_CARGO"));
                cargo.setNombreCargo(rs.getString("NOMBRE_CARGO"));

            }
            
            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        return cargo;
    }
    
    
    
    public Cargo agregarCargo(Cargo cargo) {

            System.out.println(cargo.toString());

        Cargo nuevoCargo = null;

        String query = "INSERT INTO CARGO (ID_TIPO_CARGO, NOMBRE_CARGO) VALUES (?, ?)";

        System.out.println("insertarUsuario query: " + query);
        try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        

        try {
            PreparedStatement sent = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            sent.setInt(1, cargo.getIdTipoCargo());
            sent.setString(2, cargo.getNombreCargo());
            int filasInsertadas = sent.executeUpdate();
            // Verificar si se insertó al menos una fila
            if (filasInsertadas > 0) {
                ResultSet generatedKeys = sent.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    cargo.setIdCargo(idGenerado);
                    nuevoCargo = cargo;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    listarCargo();
    return nuevoCargo; // se envia el objeto usuario con los datos registrados
    }
public List<Cargo> listarCargo() {
    List<Cargo> listaCargo = new ArrayList<>();

    String query = "SELECT c.ID_CARGO, c.ID_TIPO_CARGO, c.NOMBRE_CARGO, tc.NOMBRE_TIPO_CARGO FROM CARGO c INNER JOIN TIPO_CARGO tc ON c.ID_TIPO_CARGO = tc.ID_TIPO_CARGO ORDER BY c.NOMBRE_CARGO";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        try {
            PreparedStatement sent = con.prepareStatement(query);
            ResultSet rs = sent.executeQuery();

            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("ID_CARGO"));
                cargo.setIdTipoCargo(rs.getInt("ID_TIPO_CARGO"));
                cargo.setNombreCargo(rs.getString("NOMBRE_CARGO"));
                cargo.setNombreTipoCargo(rs.getString("NOMBRE_TIPO_CARGO"));

                listaCargo.add(cargo);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        con.close();

    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    
    return listaCargo;
}

public String eliminarCargo(int idCargo) {

    String msg = "Cargo NO FUE ELIMINADO CORRECTAMENTE.";
    String query = "DELETE FROM CARGO WHERE ID_CARGO = ?";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();

        try {
            PreparedStatement sent = con.prepareStatement(query);
            sent.setInt(1, idCargo);
            int filaEliminada = sent.executeUpdate();

            // Verificar si se actualizó al menos una fila
            if (filaEliminada > 0) {
                msg = "CARGO ELIMINADO CORRECTAMENTE."; // La eliminación fue exitosa
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

public int actualizarCargo(Cargo cargo) {
    int filasAgregadas = 0;
    

    String query = "UPDATE CARGO SET ID_TIPO_CARGO=?, NOMBRE_CARGO=? WHERE ID_CARGO=?";
    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        PreparedStatement sent = con.prepareStatement(query);
        sent.setInt(1, cargo.getIdTipoCargo());
        sent.setString(2, cargo.getNombreCargo());
        sent.setInt(3, cargo.getIdCargo());


        
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
