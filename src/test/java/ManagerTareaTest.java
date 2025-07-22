import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerTareaTest {

    private ConexionSQLite conexion = new ConexionSQLite("jdbc:sqlite::memory:");
    private ManagerTarea gestor;

    @BeforeEach
    public void prepararBaseDeDatos() {
        conexion.inicializar();
        gestor = new ManagerTarea(conexion);
    }

    @AfterEach
    public void cerrarConexion(){
        conexion.cerrar();
    }

    @Test
    public void probarAgregarTarea() throws SQLException {
        gestor.agregarTarea("Prueba", Tarea.Prioridad.MEDIA);

        String consulta = "SELECT * FROM tareas WHERE titulo = ?";
        try(PreparedStatement sentencia = conexion.getConexion().prepareStatement(consulta)){
            sentencia.setString(1, "Prueba");
            ResultSet resultado = sentencia.executeQuery();

            //pruebas
            assertTrue(resultado.next(), "La tarea no fue encontrada en la db");
            assertEquals("Prueba", resultado.getString("titulo"));
            assertEquals("MEDIA", resultado.getString("prioridad"));
            assertEquals("PENDIENTE", resultado.getString("estado"));

            resultado.close();
        }
    }
}
