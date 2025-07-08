import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    private static final String URL = "jdbc:sqlite:tempus.db";
    private Connection conexion;

    //metodo para realizar la conexion a la base de datos
    public void conectar()
    {
        try{
            conexion = DriverManager.getConnection(URL);
            System.out.println("Conexion con BD exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar "  + e.getMessage());
        }
    }

    public void cerrar() {
        try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerra la conexion: " + e.getMessage());
        }
    }

    public Connection getConexion()
    {
        return conexion;
    }
}
