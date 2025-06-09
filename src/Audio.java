public class Audio extends Multimedia {
    private double duracion;
    private String formato;

    public Audio(String codigo, String titulo, boolean estadoDisponibilidad, double duracion, String formato) {
        super(codigo, titulo, estadoDisponibilidad);
        this.duracion = duracion;
        this.formato = formato;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Audio: " + titulo + ", Duración: " + duracion + " min, Formato: " + formato);
    }
}
