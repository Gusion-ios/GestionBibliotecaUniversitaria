public class Video extends Multimedia {
    private double duracion;
    private String resolucion;

    public Video(int codigo, String titulo, String autor, boolean disponible,
                 double duracion, String resolucion) {
        super(codigo, titulo, autor, disponible);
        this.duracion = duracion;
        this.resolucion = resolucion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Video:");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Resolución: " + resolucion);
        System.out.println("Disponible: " + disponible);
    }
}
