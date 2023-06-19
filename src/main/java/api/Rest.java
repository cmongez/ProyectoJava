package api;

import DAO.UsuarioDAO;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.PathParam;
import modelo.Usuario;

@Path("/rest")
public class Rest {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/get/{rut}") // Parámetro en la ruta
    public String get(@PathParam("rut") int rut) {
    System.out.println("entra a get");
    // Crear un objeto Java que deseas convertir a JSON
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario = (Usuario) usuarioDAO.obtenerUsuarioPorRut(rut);

    // Convertir el objeto Java a JSON utilizando Gson
    Gson gson = new Gson();
    String json = gson.toJson(usuario);

    // Devolver el JSON resultante
    return json;
        //http://localhost:8080/demoRest/api/rest/get/rut (
    }
}