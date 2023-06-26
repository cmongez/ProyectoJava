package conexion;

import java.sql.*;

/**
 * Esta clase proporciona una conexión a la base de datos utilizando JDBC. La
 * conexión se establece utilizando la URL, el nombre de usuario y la contraseña
 * especificados. La clase también proporciona métodos para obtener la instancia
 * de la conexión, cerrar la conexión y obtener el objeto Statement para
 * ejecutar consultas SQL.
 *
 */
public class Conexion {

    private static Conexion instancia = null;
    private static String url = "jdbc:mysql://localhost:3306/ficticia";
    private static String user = "root";
    private static String pass = "";
    private static Connection con = null;
    private Statement stmt = null;

    /**
     * Constructor privado para evitar instancias directas de la clase. La
     * conexión se establece y se crea el objeto Statement. Se lanza
     * ClassNotFoundException si no se encuentra el controlador de la base de
     * datos. Se lanza SQLException si ocurre un error al establecer la
     * conexión.
     */
    public Conexion() throws SQLException, ClassNotFoundException {
        System.out.println("Conectando...");
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);
        stmt = con.createStatement();
        System.out.println(con);
        System.out.println("Conectado");
    }

    /**
     * Obtiene la instancia de la conexión a la base de datos. Si la instancia
     * es nula, se crea una nueva instancia y se devuelve. Si la instancia ya
     * existe, se devuelve la instancia existente.
     *
     * @return la instancia de la conexión a la base de datos
     * @throws SQLException si ocurre un error al establecer la conexión
     * @throws ClassNotFoundException si no se encuentra el controlador de la
     * base de datos
     */
    public static Conexion obtenerInstancia() throws SQLException, ClassNotFoundException {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    /**
     * Obtiene la conexión actual.
     *
     * @return el objeto Connection que representa la conexión a la base de
     * datos
     */
    public Connection getConexion() //Permite retornar la conexion
    {
        return con;
    }

    /**
     * Cierra la conexión a la base de datos.
     *
     * @return 0 si se cierra la conexión correctamente, -1 si ocurre un error
     * al cerrar la conexión
     */
    public int cerrarConexion() {
        try {
            con.close();
            return 0;
        } catch (Exception exc) {
            System.out.println("Error al cerrar la conexion: " + " : " + exc);
            return -1;
        }
    }

    /**
     * Cierra la conexión y el objeto Statement.
     */
    public void close() {
        try {
            if (con != null) {
                stmt.close();
                con.close();
                con = null;
            }
        } catch (SQLException sqe) {
            System.out.println("Unexpected exception : "
                    + sqe.toString() + ", sqlstate = " + sqe.getSQLState());
            sqe.printStackTrace();
        }
    }

    /**
     * Obtiene la conexión actual.
     *
     * @return el objeto Connection que representa la conexión a la base de
     * datos
     */
    public Connection conexion() {
        return con;
    }

    /**
     * Obtiene el objeto Statement asociado a la conexión.
     *
     * @return el objeto Statement para ejecutar consultas SQL
     */
    public Statement sentencia() {
        return stmt;
    }

}
