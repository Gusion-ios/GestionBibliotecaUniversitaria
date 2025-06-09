public class Video extends Multimedia {
    private double duracion; // en minutos
    private String resolucion;

    public Video(String codigo, String titulo, boolean estadoDisponibilidad, double duracion, String resolucion) {
        super(codigo, titulo, estadoDisponibilidad);
        this.duracion = duracion;
        this.resolucion = resolucion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Video: " + titulo + ", Duración: " + duracion + " min, Resolución: " + resolucion);
    }
}
