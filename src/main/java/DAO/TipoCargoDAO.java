/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoCargo;
import modelo.TipoCargoCantidad;

/**
 *
 * @author cmongez
 */
public class TipoCargoDAO {

    public TipoCargoDAO() {
    }
    
    public TipoCargo obtenerTipoCargoPorId(int idTipoCargo) {
       
        TipoCargo tipoCargo = null;
        
        String query = "SELECT ID_TIPO_CARGO, NOMBRE_TIPO_CARGO, DESCRIPCION_TIPO_CARGO  FROM TIPO_CARGO WHERE ID_TIPO_CARGO = ?";
        
        System.out.println("obtenerTipoCargo query: "+query);

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setInt(1, idTipoCargo);
                ResultSet rs = sent.executeQuery();

            if (rs.next()) {
                tipoCargo = new TipoCargo();
                tipoCargo.setIdTipoCargo(rs.getInt("ID_TIPO_CARGO"));
                tipoCargo.setNombreTipoCargo(rs.getString("NOMBRE_TIPO_CARGO"));
                tipoCargo.setDescripcionTipoCargo(rs.getString("DESCRIPCION_TIPO_CARGO"));

            }
            
            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        return tipoCargo;
    }
    
    
    
    public TipoCargo agregarTipoCargo(TipoCargo tipoCargo) {

        TipoCargo nuevoTipoCargo = null;

        String query = "INSERT INTO tipo_cargo (NOMBRE_TIPO_CARGO, DESCRIPCION_TIPO_CARGO) VALUES (?, ?)";

        System.out.println("insertarUsuario query: " + query);
        try {
        Conexion db = new Conexion();
        Connection con = db.conexion();

        try {
            PreparedStatement sent = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            sent.setString(1, tipoCargo.getNombreTipoCargo());
            sent.setString(2, tipoCargo.getDescripcionTipoCargo());
            int filasInsertadas = sent.executeUpdate();
            // Verificar si se insertó al menos una fila
            if (filasInsertadas > 0) {
                ResultSet generatedKeys = sent.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    tipoCargo.setIdTipoCargo(idGenerado);
                    nuevoTipoCargo = tipoCargo;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    listarTipoCargo();
    return nuevoTipoCargo; // se envia el objeto usuario con los datos registrados
    }
public List<TipoCargo> listarTipoCargo() {
    List<TipoCargo> listaTipoCargo = new ArrayList<>();

    String query = "SELECT ID_TIPO_CARGO, NOMBRE_TIPO_CARGO, DESCRIPCION_TIPO_CARGO FROM tipo_cargo ORDER BY ID_TIPO_CARGO";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        try {
            PreparedStatement sent = con.prepareStatement(query);
            ResultSet rs = sent.executeQuery();

            while (rs.next()) {
                TipoCargo tipoCargo = new TipoCargo();
                tipoCargo.setIdTipoCargo(rs.getInt("ID_TIPO_CARGO"));
                tipoCargo.setNombreTipoCargo(rs.getString("NOMBRE_TIPO_CARGO"));
                tipoCargo.setDescripcionTipoCargo(rs.getString("DESCRIPCION_TIPO_CARGO"));
                listaTipoCargo.add(tipoCargo);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        con.close();

    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    
    return listaTipoCargo;
}

public String eliminarTipoCargo(int idTipoCargo) {

    String msg = "TipoCargo NO FUE ELIMINADO CORRECTAMENTE.";
    String query = "DELETE FROM TIPO_CARGO WHERE ID_TIPO_CARGO = ?";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();

        try {
            PreparedStatement sent = con.prepareStatement(query);
            sent.setInt(1, idTipoCargo);
            int filaEliminada = sent.executeUpdate();

            // Verificar si se actualizó al menos una fila
            if (filaEliminada > 0) {
                msg = "TIPO CARGO ELIMINADO CORRECTAMENTE."; // La eliminación fue exitosa
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

public int actualizarTipoCargo(TipoCargo tipoCargo) {
    int filasAgregadas = 0;

    String query = "UPDATE TIPO_CARGO SET NOMBRE_TIPO_CARGO=?, DESCRIPCION_TIPO_CARGO=? WHERE ID_TIPO_CARGO=?";
    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        PreparedStatement sent = con.prepareStatement(query);
        sent.setString(1, tipoCargo.getNombreTipoCargo());
        sent.setString(2, tipoCargo.getDescripcionTipoCargo());
        sent.setInt(3, tipoCargo.getIdTipoCargo());

        
        filasAgregadas = sent.executeUpdate();
         System.out.println(filasAgregadas + "FILAAAAAAAAAAAAAAAAA");
         
        sent.close();
        con.close();
    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }
    return filasAgregadas;
}

public List<TipoCargoCantidad> obtenerCantidadCargosPorTipo() {
    List<TipoCargoCantidad> cantidadCargosPorTipo = new ArrayList<>();

    String query = "SELECT TC.NOMBRE_TIPO_CARGO, COUNT(*) AS CANTIDAD FROM CARGO C JOIN TIPO_CARGO TC ON C.ID_TIPO_CARGO = TC.ID_TIPO_CARGO GROUP BY TC.NOMBRE_TIPO_CARGO";

    try {
        Conexion db = new Conexion();
        Connection con = db.conexion();
        try {
            PreparedStatement sent = con.prepareStatement(query);
            ResultSet rs = sent.executeQuery();

            while (rs.next()) {
                String nombreTipoCargo = rs.getString("NOMBRE_TIPO_CARGO");
                int cantidad = rs.getInt("CANTIDAD");

                TipoCargoCantidad tipoCargoCantidad = new TipoCargoCantidad(nombreTipoCargo, cantidad);
                cantidadCargosPorTipo.add(tipoCargoCantidad);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        con.close();

    } catch (Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    return cantidadCargosPorTipo;
}


}
