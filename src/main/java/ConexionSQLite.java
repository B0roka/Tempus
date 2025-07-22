import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionSQLite {
    //private static final String URL = "jdbc:sqlite:tempus.db";
    private Connection conexion;

    //constructor
    public ConexionSQLite(String url) {
        conectar(url);
    }

    //metodo para realizar la conexion a la base de datos
    public void conectar(String URL)
    {
        if (this.conexion != null) return; //ya esta conectado

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

    public void inicializar()
    {
        String sql = "CREATE TABLE IF NOT EXISTS tareas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "prioridad TEXT NOT NULL," +
                "estado TEXT NOT NULL)";
        try(Statement sentencia = conexion.createStatement()) {
            sentencia.execute(sql);
        } catch (SQLException e)
        {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}
