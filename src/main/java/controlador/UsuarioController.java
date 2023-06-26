/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

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
import servicio.UsuarioServicio;

/**
 * Este controlador maneja las solicitudes relacionadas con los usuarios.
 * Implementa los métodos doPost y doGet para procesar las solicitudes POST y
 * GET, respectivamente.
 *
 * @author cmongez
 */
public class UsuarioController extends HttpServlet {

    UsuarioServicio usuarioServicio = new UsuarioServicio();
    Usuario usuario = new Usuario();
    String opcion = "";
    int rutUsuario = 0;
    List<Usuario> listaUsuario;

    /**
     * Obtiene los datos del formulario relacionados con el usuario y los
     * almacena en el objeto Usuario.
     *
     * @param request el objeto HttpServletRequest que contiene los parámetros
     * del formulario
     * @param response el objeto HttpServletResponse utilizado para enviar la
     * respuesta
     * @throws ServletException si ocurre un error al procesar la solicitud
     * @throws IOException si ocurre un error de entrada/salida
     */
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

    /**
     * Procesa la solicitud POST o GET. Verifica la autenticación del usuario y
     * procesa la opción seleccionada en el formulario.
     *
     * @param request el objeto HttpServletRequest que contiene la solicitud
     * @param response el objeto HttpServletResponse utilizado para enviar la
     * respuesta
     * @throws ServletException si ocurre un error al procesar la solicitud
     * @throws IOException si ocurre un error de entrada/salida
     */
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

    /**
     * Procesa la solicitud GET. Maneja las diferentes opciones seleccionadas en
     * el formulario y redirige a las páginas correspondientes.
     *
     * @param request el objeto HttpServletRequest que contiene la solicitud GET
     * @param response el objeto HttpServletResponse utilizado para enviar la
     * respuesta
     * @throws ServletException si ocurre un error al procesar la solicitud
     * @throws IOException si ocurre un error de entrada/salida
     */
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
                usuario = usuarioServicio.obtenerUsuarioPorRut(rutUsuario);
                request.setAttribute("usuario", usuario);
                request.setAttribute("modoEditar", true);

                dispatcherFormTrabajadores.forward(request, response);
                return;

            case "eliminar":
                rutUsuario = Integer.parseInt(request.getParameter("rutUsuario"));
                System.out.println(rutUsuario);
                usuarioServicio.eliminarUsuario(rutUsuario);
                listaUsuario = usuarioServicio.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);
                dispatcherTrabajadores.forward(request, response);
                return;

            default:
                listaUsuario = usuarioServicio.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);

                dispatcherTrabajadores.forward(request, response);
                break;
        }
    }

    /**
     * Procesa la solicitud POST. Maneja las diferentes opciones seleccionadas
     * en el formulario y realiza las operaciones correspondientes en la base de
     * datos.
     *
     * @param request el objeto HttpServletRequest que contiene la solicitud
     * POST
     * @param response el objeto HttpServletResponse utilizado para enviar la
     * respuesta
     * @throws ServletException si ocurre un error al procesar la solicitud
     * @throws IOException si ocurre un error de entrada/salida
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
                usuarioServicio.agregarUsuario(usuario);
                listaUsuario = usuarioServicio.listarUsuario();
                request.setAttribute("usuarios", listaUsuario);
                dispatcherTrabajadores.forward(request, response);
                return;

            case "actualizar":

                obtenerDatosFormUsuario(request, response);
                usuarioServicio.actualizarUsuario(usuario);
                listaUsuario = usuarioServicio.listarUsuario();
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
