/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;


import java.util.List;
import modelo.Usuario;

/**
 *
 * @author cmongez
 */

public interface UsuarioInterface {

    Usuario obtenerUsuarioPorRut(int rut);

    String eliminarUsuario(int rut);

    List<Usuario> listarUsuario();

    int agregarUsuario(Usuario usuario);

    int actualizarUsuario(Usuario usuario);
}
