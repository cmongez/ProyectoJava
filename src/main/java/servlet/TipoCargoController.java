/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.TipoCargoDAO;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.TipoCargo;
import modelo.TipoCargoCantidad;
import servicio.LoginServicio;

/**
 *
 * @author cmongez
 */
public class TipoCargoController extends HttpServlet {

    TipoCargoDAO tipoCargoDAO = new TipoCargoDAO();

    TipoCargo tipoCargo = new TipoCargo();
    String opcion = "";
    int idTipoCargo = 0;
    List<TipoCargo> listaTipoCargo;
    List<TipoCargoCantidad> listaTipoCargoCantidad;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("empty-statement")
    protected void obtenerDatosFormTipoCargo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (opcion.equals("agregar") || opcion.equals("actualizar")) {
            // Datos Tipo Cargo
            String nombreTipoCargo = request.getParameter("nombreTipoCargo");
            String descripcionTipoCargo = request.getParameter("descripcionTipoCargo");
            System.out.println(request.getParameter("idTipoCargo"));
            if (opcion.equals("actualizar")) {
                idTipoCargo = Integer.parseInt(request.getParameter("idTipoCargo"));
                tipoCargo.setIdTipoCargo(idTipoCargo);
            };

            tipoCargo.setNombreTipoCargo(nombreTipoCargo);
            tipoCargo.setDescripcionTipoCargo(descripcionTipoCargo);
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
        request.setAttribute("tipoCargos", listaTipoCargo);
        request.setAttribute("tipoCargosCantidad", listaTipoCargoCantidad);

        RequestDispatcher dispatcherTipoCargo = request.getRequestDispatcher("tipocargo.jsp");
        RequestDispatcher dispatcherFormTipoCargo = request.getRequestDispatcher("formtipocargo.jsp");

        System.out.println(opcion + "OPCION");
        switch (opcion) {
            case "crear":

                System.out.println(opcion + "CREARRRRRRRRRRRRRRR");

                tipoCargo = new TipoCargo();
                request.setAttribute("modoEditar", false);
                dispatcherFormTipoCargo.forward(request, response);
                return;

            case "editar":
                idTipoCargo = Integer.parseInt(request.getParameter("idTipoCargo"));
                tipoCargo = tipoCargoDAO.obtenerTipoCargoPorId(idTipoCargo);
                request.setAttribute("tipoCargo", tipoCargo);
                request.setAttribute("modoEditar", true);

                dispatcherFormTipoCargo.forward(request, response);
                return;

            case "eliminar":
                idTipoCargo = Integer.parseInt(request.getParameter("idTipoCargo"));
                tipoCargoDAO.eliminarTipoCargo(idTipoCargo);
                listaTipoCargo = tipoCargoDAO.listarTipoCargo();
                request.setAttribute("tipoCargos", listaTipoCargo);
                dispatcherTipoCargo.forward(request, response);
                return;

            default:
                listaTipoCargo = tipoCargoDAO.listarTipoCargo();
                listaTipoCargoCantidad = tipoCargoDAO.obtenerCantidadCargosPorTipo();
                request.setAttribute("tipoCargos", listaTipoCargo);
                request.setAttribute("tipoCargosCantidad", listaTipoCargoCantidad);

                dispatcherTipoCargo.forward(request, response);
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        RequestDispatcher dispatcherTipoCargo = request.getRequestDispatcher("tipocargo.jsp");

        System.out.println(opcion + "OPCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON");

        switch (opcion) {

            case "agregar":
                // Datos usuario
                obtenerDatosFormTipoCargo(request, response);
                tipoCargoDAO.agregarTipoCargo(tipoCargo);
                listaTipoCargo = tipoCargoDAO.listarTipoCargo();
                listaTipoCargoCantidad = tipoCargoDAO.obtenerCantidadCargosPorTipo();
                request.setAttribute("tipoCargosCantidad", listaTipoCargoCantidad);

                request.setAttribute("tipoCargos", listaTipoCargo);
                dispatcherTipoCargo.forward(request, response);
                return;

            case "actualizar":

                obtenerDatosFormTipoCargo(request, response);
                tipoCargoDAO.actualizarTipoCargo(tipoCargo);
                listaTipoCargo = tipoCargoDAO.listarTipoCargo();
                listaTipoCargoCantidad = tipoCargoDAO.obtenerCantidadCargosPorTipo();
                request.setAttribute("tipoCargosCantidad", listaTipoCargoCantidad);

                request.setAttribute("tipoCargos", listaTipoCargo);
                dispatcherTipoCargo.forward(request, response);

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
