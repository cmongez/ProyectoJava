/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.CargoDAO;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cargo;
import servicio.LoginServicio;

/**
 *
 * @author cmongez
 */
public class CargoController extends HttpServlet {

    CargoDAO cargoDAO = new CargoDAO();

    Cargo cargo = new Cargo();
    String opcion = "";
    int idTipoCargo = -1;
    int idCargo = -1;

    List<Cargo> listaCargo;

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
    protected void obtenerDatosFormCargo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (opcion.equals("agregar") || opcion.equals("actualizar")) {
            // Datos Cargo
            idTipoCargo = Integer.parseInt(request.getParameter("idTipoCargo"));
            
            System.out.println(request.getParameter("idTipoCargo") + "RESQUEST");
            cargo.setIdTipoCargo(idTipoCargo);
            String nombreCargo = request.getParameter("nombreCargo");
            if (opcion.equals("actualizar")) {
                idCargo = Integer.parseInt(request.getParameter("idCargo"));
                cargo.setIdCargo(idCargo);
            };

            cargo.setNombreCargo(nombreCargo);
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        request.setAttribute("cargos", listaCargo);
        RequestDispatcher dispatcherCargo = request.getRequestDispatcher("cargo.jsp");
        RequestDispatcher dispatcherFormCargo = request.getRequestDispatcher("formcargo.jsp");

        System.out.println(opcion + "OPCION");
        switch (opcion) {
            case "crear":

                System.out.println(opcion + "CREARRRRRRRRRRRRRRR");

                cargo = new Cargo();
                request.setAttribute("modoEditar", false);
                dispatcherFormCargo.forward(request, response);
                return;

            case "editar":
                idCargo = Integer.parseInt(request.getParameter("idCargo"));
                cargo = cargoDAO.obtenerCargoPorId(idCargo);
                request.setAttribute("cargo", cargo);
                request.setAttribute("modoEditar", true);

                dispatcherFormCargo.forward(request, response);
                return;

            case "eliminar":
                idCargo = Integer.parseInt(request.getParameter("idCargo"));
                cargoDAO.eliminarCargo(idCargo);
                listaCargo = cargoDAO.listarCargo();
                request.setAttribute("cargos", listaCargo);
                dispatcherCargo.forward(request, response);
                return;

            default:
                listaCargo = cargoDAO.listarCargo();
                request.setAttribute("cargos", listaCargo);

                dispatcherCargo.forward(request, response);
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
        RequestDispatcher dispatcherCargo = request.getRequestDispatcher("cargo.jsp");
        
        
        System.out.println(opcion + "OPCIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOON");
 
        switch (opcion) {

            case "agregar":
                // Datos usuario
                obtenerDatosFormCargo(request, response);
                cargoDAO.agregarCargo(cargo);
                listaCargo = cargoDAO.listarCargo();
                request.setAttribute("cargos", listaCargo);
                dispatcherCargo.forward(request, response);
                return;

            case "actualizar":

                obtenerDatosFormCargo(request, response);
                cargoDAO.actualizarCargo(cargo);
                listaCargo = cargoDAO.listarCargo();
                request.setAttribute("cargos", listaCargo);
                dispatcherCargo.forward(request, response);

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
