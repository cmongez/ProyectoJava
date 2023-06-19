/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import DAO.UsuarioDAO;
import interfaces.UsuarioInterface;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author cmongez
 */

public class UsuarioServicio implements UsuarioInterface {

    private final UsuarioDAO usuarioDAO;

    public UsuarioServicio() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public Usuario obtenerUsuarioPorRut(int rut) {
        return usuarioDAO.obtenerUsuarioPorRut(rut);
    }

    @Override
    public String eliminarUsuario(int rut) {
        return usuarioDAO.eliminarUsuario(rut);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDAO.listarUsuario();
    }

    @Override
    public int agregarUsuario(Usuario usuario) {
        return usuarioDAO.agregarUsuario(usuario);
    }

    @Override
    public int actualizarUsuario(Usuario usuario) {
        return usuarioDAO.actualizarUsuario(usuario);
    }
}
