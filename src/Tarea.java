public class Tarea {
    //contador para los ID
    private static int contador = 0;

    //constantes
    public static enum Prioridad {BAJA, MEDIA, ALTA};
    public static enum Estado {PENDIENTE, EN_PROGRESO, COMPLETADA};
    //atributos
    private int id;
    private String titulo;
    private Prioridad prioridad;
    private Estado estado;

    //constructor
    public Tarea( String titulo, Prioridad prioridad, Estado estado) {
        this.id = ++contador;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    //getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //metodo to string
    public String toString()
    {
        return String.format("[%-3d] %-30s | Prioridad: %-6s | Estado: %-12s",
                id, titulo, prioridad, estado);
    }
}
