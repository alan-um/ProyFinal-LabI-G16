package accesoADatos;

//Import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class Conexion {
  
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "gimnasiog16";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    //Medoto constructor
    private Conexion() {
    }

    public static Connection getConexion() {

        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL + DB + "?useLegacyDatatimeCode=false&serverTimezone=UTC"
                        + "&user=" + USUARIO + "&password=" + PASSWORD);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la DB " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse al cargar los Drivers " + ex.getMessage());
            }
        }
        return connection;
    }
}
