import java.util.ArrayList;
import java.util.List;

public class ManagerTarea {

    private ArrayList<Tarea> tareas;

    //constructor
    public ManagerTarea()
    {
        this.tareas = new ArrayList<>();
    }

    //metodos
    public void agregarTarea(String titulo, Tarea.Prioridad prioridad)
    {
        Tarea nueva = new Tarea(titulo, prioridad, Tarea.Estado.PENDIENTE);
        tareas.add(nueva);
        System.out.println("Tarea agregada: " + nueva);
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

