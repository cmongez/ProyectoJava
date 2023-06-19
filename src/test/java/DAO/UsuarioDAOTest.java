/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.util.List;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmongez
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerUsuarioPorRut method, of class UsuarioDAO.
     */
    @Test
    public void testObtenerUsuarioPorRut() {
        System.out.println("obtenerUsuarioPorRut");
        int rut = 122;
        UsuarioDAO instance = new UsuarioDAO();
        Usuario result = instance.obtenerUsuarioPorRut(rut);
        assertNotNull(result);
    }
    
    
    /**
     * Test of agregarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testAgregarUsuario() {
        System.out.println("agregarUsuario");
        Usuario usuario = new Usuario();
        usuario.setRut("1111");
        usuario.setDv('5');
        usuario.setNombres("Luis");
        usuario.setApellidos("Espindola");
        usuario.setCorreo("luis@gmail.com");
        usuario.setFechaNacimiento("2023-06-18");
        usuario.setGenero("Masculino");
        usuario.setFechaContratacion("2023-07-18");
        usuario.setTelefonoUsuario("221458");
        usuario.setIdCargo(1);
        UsuarioDAO instance = new UsuarioDAO();
        int expResult = 1;
        int result = instance.agregarUsuario(usuario);
        System.out.println(result+"RESULTTTTTTTTTTTTTTTT");
        assertEquals(expResult, result);
    }

    /**
     * Test of eliminarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("eliminarUsuario");
        int rut = 1111;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "USUARIO ELIMINADO CORRECTAMENTE.";
        String result = instance.eliminarUsuario(rut);
        assertEquals(expResult, result);
    }



   
    
}
