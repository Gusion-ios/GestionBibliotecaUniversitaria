public abstract class Multimedia {
    private String codigo;
    private String titulo;
    private String estadoDisponibilidad;

    public Multimedia(String codigo, String titulo, String estadoDisponibilidad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstadoDisponibilidad() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(String estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }
}
