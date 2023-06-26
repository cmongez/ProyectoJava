/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import interfaces.LoginInterface;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * Esta clase implementa la interfaz LoginInterface y proporciona
 * funcionalidades relacionadas con el inicio de sesión.
 *
 * Permite obtener el nombre de usuario de una sesión HTTP.
 *
 * La clase utiliza HttpSession para obtener la sesión actual y recuperar el
 * nombre de usuario almacenado en ella.
 *
 * Si no se encuentra un nombre de usuario, se devuelve un Optional vacío.
 *
 * @author cmongez
 */
public class LoginServicio implements LoginInterface {

    /**
     *
     * Obtiene el nombre de usuario de la sesión HTTP actual.
     *
     * @param request el objeto HttpServletRequest que representa la solicitud
     * HTTP actual
     * @return un Optional que contiene el nombre de usuario si está presente, o
     * un Optional vacío si no hay nombre de usuario en la sesión
     */

    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("usuario");
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
