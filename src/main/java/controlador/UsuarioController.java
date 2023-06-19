/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import servicio.LoginServicio;

/**
 *
 * @author cmongez
 */
public class UsuarioController extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = new Usuario();
    String opcion = "";
    int rutUsuario = 0;
    List<Usuario> listaUsuario;

    protected void obtenerDatosFormUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (opcion.equals("agregar") || opcion.equals("actualizar")) {
            // Datos usuario
            String rut = request.getParameter("rut");

            char dv = request.getParameter("dv").charAt(0);
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String correo = request.getParameter("correo");
            
            String fechaNacimiento = request.getParameter("fechaNacimiento");
            String genero = request.getParameter("genero");
            String fechaContratacion = request.getParameter("fechaContratacion");
            int idCargo = Integer.parseInt(request.getParameter("idCargo"));
            String telefonoUsuario = request.getParameter("telefonoUsuario");

            usuario.setRut(rut);
            usuario.setDv(dv);
            usuario.setNombres(nombres);
            usuario.setApellidos(apellidos);
            usuario.setCorreo(correo);
            usuario.setFechaNacimiento(fechaNacimiento);
            usuario.setGenero(genero);
            usuario.setFechaContratacion(fechaContratacion);
            usuario.setIdCargo(idCargo);
            usuario.setTelefonoUsuario(telefonoUsuario);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginServicio auth = new LoginServicio();
        Optional<String> usernameOptional = auth.getUsername(request);
        if (!usernameOptional.isPresent()) {
            getServletContext().getRequestDispatcher("/login").forward(request, response);
            return;
        }
        opcion = request.getParameter("opcion");
        if (opcion == null) {
            opcion = "";
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispatcherTrabajadores = request.getRequestDispatcher("trabajadores.jsp");
        RequestDispatcher dispatcherFormTrabajadores = request.getRequestDispatcher("formtrabajadores.jsp");

        System.out.println(opcion + "OPCION");
        switch (opcion) {
            case "crear":

                
                usuario = new Usuario();
                request.setAttribute("modoEditar", false);
                dispatcherFormTrabajadores.forward(request, response);
                return;

            case "editar":
                rutUsuario = Integer.parseInt(request.getParameter("rutUsuario"));
                usuario = usuarioDAO.obtenerUsuarioPorRut(rutUsuario);
                request.setAttribute("usuario", usuario);
                request.setAttribute("modoEditar", true);

                dispatcherFormTrabajadores.forward(request, response);
                return;

            case "eliminar":
                rutUsuario = Integer.parseInt(request.getParameter("rutUsuario"));
                System.out.println(rutUsuario);
                usuarioDAO.eliminarUsuario(rutUsuario);
                listaUsuario = usuarioDAO.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);
                dispatcherTrabajadores.forward(request, response);
                return;

            default:
                listaUsuario = usuarioDAO.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);

                dispatcherTrabajadores.forward(request, response);
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispatcherTrabajadores = request.getRequestDispatcher("trabajadores.jsp");

        switch (opcion) {

            case "agregar":
                // Datos usuario
                obtenerDatosFormUsuario(request, response);
                usuarioDAO.agregarUsuario(usuario);
                listaUsuario = usuarioDAO.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);
                dispatcherTrabajadores.forward(request, response);
                return;

            case "actualizar":

                obtenerDatosFormUsuario(request, response);
                usuarioDAO.actualizarUsuario(usuario);
                listaUsuario = usuarioDAO.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);
                dispatcherTrabajadores.forward(request, response);
                return;

            default:
                throw new AssertionError();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
