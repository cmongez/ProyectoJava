/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.LoginDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Optional;
import modelo.Login;
import servicio.LoginServicio;



/**
 *
 * @author cmongez
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    final static String USERNAME = "admin";
    final static String PASSWORD = "1234";
    
  

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
        
        LoginServicio auth = new LoginServicio();
        Optional<String> usernameOptional = auth.getUsername(request);

        if (usernameOptional.isPresent()) {
            getServletContext().getRequestDispatcher("/").forward(request, response);
        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
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
        String email = request.getParameter("correo");
        String password = request.getParameter("contrasenia");
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setContrasenia(password);
        login.setCorreo(email);
        
        boolean estaLogueado = loginDAO.validarDatosLogin(login);
        System.out.println(estaLogueado);
        if (estaLogueado) {
            // Si las credenciales son válidas, crear una sesión para el usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuario", email);
            response.sendRedirect("/");
        } else {
            // Si las credenciales son inválidas, redirigir al formulario de login con un mensaje de error
            response.sendRedirect("login?error=true");
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
