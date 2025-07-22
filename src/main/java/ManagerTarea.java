import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerTarea {

    private ArrayList<Tarea> tareas;
    //persistencia desde SQLite
    ConexionSQLite conexion; //= new ConexionSQLite("jdbc:sqlite:tempus.db");

   //constructor
    public ManagerTarea(ConexionSQLite conexion) {
        this.tareas = new ArrayList<>();
        this.conexion = conexion;
    }

    //metodos
    public void agregarTarea(String titulo, Tarea.Prioridad prioridad)
    {
        Tarea nueva = new Tarea(titulo, prioridad, Tarea.Estado.PENDIENTE);
        tareas.add(nueva);


        String sql = "INSERT INTO tareas (titulo, prioridad, estado) VALUES (?, ?, ?)";
        try (PreparedStatement sentencia = conexion.getConexion().prepareStatement(sql)){
            sentencia.setString(1, nueva.getTitulo());
            sentencia.setString(2, nueva.getPrioridad().name());
            sentencia.setString(3, nueva.getEstado().name());
            sentencia.executeUpdate();
            System.out.println("Tarea persistida en BD: " + nueva);
        }catch (SQLException e) {
            System.out.println("Error al guardar la tarea en la BD: " + e.getMessage());
        }
    }

    public boolean cambiarEstadoTarea(int id, Tarea.Estado nuevoEstado)
    {
        for(Tarea tarea : tareas)
        {
            if (tarea.getId() == id)
            {
                tarea.setEstado(nuevoEstado);
                System.out.println("Estado actualizado: " + tarea);
                return true;
            }
        }
        System.out.println("No se encontro la tarea con ID " + id);
        return false;
    }

    public boolean completarTarea(int id)
    {
        for (Tarea tarea : tareas)
        {
            if (tarea.getId() == id)
            {
                tarea.setEstado(Tarea.Estado.COMPLETADA);
                System.out.printf("Tarea %s completada con exito%n", tarea);
                return true;
            }
        }
        System.out.println("No se encontro la tarea con ID " + id);
        return false;
    }

    public boolean eliminarTarea(int id)
    {
        for (int i = 0; i < tareas.size(); i++)
        {
            if (tareas.get(i).getId() == id)
            {
                System.out.println("Eliminando tarea: " + tareas.get(i));
                tareas.remove(i);
                return true;
            }
        }
        System.out.printf("Tarea con ID %d no encontrada.", id);
        return false;
    }

    public List<Tarea> getTareas()
    {
        System.out.println("Lista de tareas activas");
        return tareas;
    }
}

