package org.israeldelamo.bbdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase de conexión a la bbdd
 *
 * @author israel
 * @version $Id: $Id
 */
public class ConexionBD {
    // Usamos SLF4J para el logger
  
    private final Connection conexion;

    /**
     * Es el constructor que se llama al crear un objeto de esta clase, lanzado la conexión
     *
     * @throws java.sql.SQLException Hay que controlar errores de SQL
     */
    public ConexionBD() throws SQLException {

        String url = "localhost/prueba";
        //TODO QUITAR LAS CREDENCIALES EXPUESTAS AQUÍ, QUE HORROR!!!
        String user = "root";
        String password ="root";

        Properties connConfig = new Properties();
        connConfig.setProperty("user", user);
        connConfig.setProperty("password", password);


        conexion = DriverManager.getConnection("jdbc:mysql://" + url + "?serverTimezone=Europe/Madrid", connConfig);
        conexion.setAutoCommit(true);
        conexion.setAutoCommit(true);
      


    }

    /**
     * Esta clase devuelve la conexión creada
     *
     * @return una conexión a la BBDD
     */
    public Connection getConexion() {
        //logger.info("Conexión establecida");
        return conexion;
    }

    /**
     * Metodo de cerrar la conexion con la base de datos
     *
     * @return La conexión cerrada.
     * @throws java.sql.SQLException Se lanza en caso de errores de SQL al cerrar la conexión.
     */
    public Connection CloseConexion() throws SQLException {
        conexion.close();
        // logger.info("Conexión cerrada");
        return conexion;
    }


    public static void main(String[] args) {
        try {
            ConexionBD conexion = new ConexionBD();
            System.out.println("Conexión establecida correctamente");
            conexion.CloseConexion();
            System.out.println("Conexión cerrada correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
