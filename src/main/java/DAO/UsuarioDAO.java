/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change usuario setlicense
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit usuario settemplate
 */
package DAO;
import log.CrearLog;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author cmongez
 */
public class UsuarioDAO {

    public UsuarioDAO() {
    }

    public Usuario obtenerUsuarioPorRut(int rut) {

        Usuario usuario = null;

        String query = "SELECT RUT, DV, NOMBRES, APELLIDOS, CORREO, FECHA_NACIMIENTO, GENERO, FECHA_CONTRATACION, ID_CARGO, TELEFONO_USUARIO FROM USUARIO WHERE RUT = ?";

        System.out.println("obtenerUsuarioPorRut query: " + query);

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setInt(1, rut);
                ResultSet rs = sent.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setRut(rs.getString("RUT"));
                    String dvString = rs.getString("DV");
                    if (dvString != null && !dvString.isEmpty()) {
                        usuario.setDv(dvString.charAt(0));
                    }
                    usuario.setNombres(rs.getString("NOMBRES"));
                    usuario.setApellidos(rs.getString("APELLIDOS"));
                    usuario.setCorreo(rs.getString("CORREO"));
                    usuario.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                    usuario.setGenero(rs.getString("GENERO"));
                    usuario.setFechaContratacion(rs.getString("FECHA_CONTRATACION"));
                    usuario.setIdCargo(rs.getInt("ID_CARGO"));
                    usuario.setTelefonoUsuario(rs.getString("TELEFONO_USUARIO"));
                    

                }
                rs.close();
                sent.close();
                con.close();

            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
                 CrearLog.errorLog("Error select Log - obtenerUsuarioPorRut: " + ex.getMessage());
            }
            con.close();

        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
        return usuario;
    }

    public String eliminarUsuario(int rut) {

        String msg = "USUARIO NO FUE ELIMINADO CORRECTAMENTE.";
        String query = "DELETE FROM USUARIO WHERE RUT = ?";

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();

            try {
                PreparedStatement sent = con.prepareStatement(query);
                sent.setInt(1, rut);
                int filaEliminada = sent.executeUpdate();

                // Verificar si se actualizó al menos una fila
                if (filaEliminada > 0) {
                    msg = "USUARIO ELIMINADO CORRECTAMENTE."; // La eliminación fue exitosa
                }
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
                CrearLog.errorLog("Error delete Log - eliminarUsuario: " + ex.getMessage());
            }

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return msg;
    }

    public List listarUsuario() {

        String query = "SELECT RUT, DV, NOMBRES, APELLIDOS, CORREO,  FECHA_NACIMIENTO, GENERO, FECHA_CONTRATACION, ID_CARGO, TELEFONO_USUARIO FROM USUARIO ORDER BY NOMBRES";
        List<Usuario> lista = new ArrayList();

        try {
            Conexion db = new Conexion();
            Connection con = db.conexion();
            PreparedStatement sent = con.prepareStatement(query);
            ResultSet rs = sent.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setRut(rs.getString("RUT"));
                String dvString = rs.getString("DV");
                if (dvString != null && !dvString.isEmpty()) {
                    usuario.setDv(dvString.charAt(0));
                }
                usuario.setNombres(rs.getString("NOMBRES"));
                usuario.setApellidos(rs.getString("APELLIDOS"));
                usuario.setCorreo(rs.getString("CORREO"));
                usuario.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                usuario.setGenero(rs.getString("GENERO"));
                usuario.setFechaContratacion(rs.getString("FECHA_CONTRATACION"));
                usuario.setIdCargo(rs.getInt("ID_CARGO"));
                usuario.setTelefonoUsuario(rs.getString("TELEFONO_USUARIO"));

                lista.add(usuario);

            }

            rs.close();
            sent.close();
            con.close();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());

        }
        return lista;
    }

   public int agregarUsuario(Usuario usuario) {
       int filasAgregadas = 0;
       String query = "INSERT INTO USUARIO (RUT, DV, NOMBRES, APELLIDOS, CORREO,  FECHA_NACIMIENTO, GENERO,  FECHA_CONTRATACION, ID_CARGO, TELEFONO_USUARIO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

       try {
           Conexion db = new Conexion();
           Connection con = db.conexion();
           PreparedStatement sent = con.prepareStatement(query);
           sent.setString(1, usuario.getRut());
           sent.setString(2, String.valueOf(usuario.getDv()));
           sent.setString(3, usuario.getNombres());
           sent.setString(4, usuario.getApellidos());
           sent.setString(5, usuario.getCorreo());
           sent.setString(6, usuario.getFechaNacimiento());
           sent.setString(7, usuario.getGenero());
           sent.setString(8, usuario.getFechaContratacion());
           sent.setInt(9, usuario.getIdCargo());
           sent.setString(10, usuario.getTelefonoUsuario());

           filasAgregadas = sent.executeUpdate();

           sent.close();
           con.close();
       } catch (Exception ex) {
           System.out.println("Error:" + ex.getMessage());
       }
       return filasAgregadas;
   }
      public int actualizarUsuario(Usuario usuario) {
       int filasAgregadas = 0;
          System.out.println(usuario.getIdCargo());
                    System.out.println(usuario.getIdCargo());

                              System.out.println(usuario.getIdCargo());
          System.out.println(usuario.getIdCargo());


       String query = "UPDATE USUARIO SET RUT=?, DV = ?, NOMBRES = ?, APELLIDOS = ?, CORREO = ?, FECHA_NACIMIENTO = ?, GENERO = ?, FECHA_CONTRATACION = ?, ID_CARGO = ?, TELEFONO_USUARIO = ?  WHERE RUT = ?";
       try {
           Conexion db = new Conexion();
           Connection con = db.conexion();
           PreparedStatement sent = con.prepareStatement(query);
           sent.setString(1, usuario.getRut());
           sent.setString(2, String.valueOf(usuario.getDv()));
           sent.setString(3, usuario.getNombres());
           sent.setString(4, usuario.getApellidos());
           sent.setString(5, usuario.getCorreo());
           sent.setString(6, usuario.getFechaNacimiento());
           sent.setString(7, usuario.getGenero());
           sent.setString(8, usuario.getFechaContratacion());
           sent.setInt(9, usuario.getIdCargo());
           sent.setString(10, usuario.getTelefonoUsuario());
           sent.setString(11, usuario.getRut());
           
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
