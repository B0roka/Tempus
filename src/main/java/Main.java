import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerTarea gestor = new ManagerTarea();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do
        {
            System.out.println("--- GESTOR DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Mostrar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Cambiar estado de tarea");
            System.out.println("5. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            //variable de identificador
            int id;
            //agregar switch
            switch (opcion)
            {
                case 1:
                    String titulo;
                    int prior;
                    System.out.println("Ingresa el titulo de la tarea");
                    titulo = entrada.nextLine();
                    System.out.printf("Ingresa la prioridad de la tarea%n1-Baja%n2-Media%n3-Alta%n");
                    prior = entrada.nextInt();
                    Tarea.Prioridad prioridad = switch (prior)
                    {
                        case 1 -> Tarea.Prioridad.BAJA;
                        case 2 -> Tarea.Prioridad.MEDIA;
                        case 3 -> Tarea.Prioridad.ALTA;
                        default -> Tarea.Prioridad.MEDIA;
                    };
                    gestor.agregarTarea(titulo,prioridad);
                    break;
                case 2:
                    List<Tarea> lista = gestor.getTareas();
                    System.out.println("Lista de tareas registradas");
                    for (Tarea t : lista)
                    {
                        System.out.println(t);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Digita el ID de la tarea completada");
                    id = entrada.nextInt();
                    gestor.completarTarea(id);
                    break;
                case 4:
                    System.out.println("Digita el ID de la tarea a la que deseas cambiarle el estado");
                    id = entrada.nextInt();
                    System.out.println("¿A que estado deseas cambiar la tarea?\n1-En progeso\n2-Completada");
                    int est = entrada.nextInt();
                    Tarea.Estado estado = switch (est)
                    {
                        case 1 -> Tarea.Estado.EN_PROGRESO;
                        case 2 -> Tarea.Estado.COMPLETADA;
                        default -> Tarea.Estado.PENDIENTE;
                    };
                    gestor.cambiarEstadoTarea(id, estado);
                    break;
                case 5:
                    System.out.println("Digita el ID de la tarea que deseas eliminar");
                    id = entrada.nextInt();
                    gestor.eliminarTarea(id);
                    break;
            }
        } while (opcion != 0);
        System.out.println("Gracias por usar Tempus :)");
    }
}
