package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kamir
 */
public class CONEXION {

    public static Connection getConexion() {
        Connection cn = null;
        String DATA_BASE = "SNYPAL";
        String USER = "root";
        String HOST = "localhost";
        String PASSWORD = "";
        String URL = "jdbc:mysql://" + HOST + ":3306/" + DATA_BASE + "?serverTimezone=UTC";
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion");
            System.out.println("" + e.getMessage());
        }
        return cn;
    }
}
