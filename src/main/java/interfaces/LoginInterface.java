/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import javax.servlet.http.HttpServletRequest;

import java.util.Optional;

/**
 *
 * @author cmongez
 */
public interface LoginInterface {
    Optional<String> getUsername(HttpServletRequest request);
}
