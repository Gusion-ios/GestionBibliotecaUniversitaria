public class Audio extends Multimedia {
    private double duracion;
    private String formato;

    public Audio(int codigo, String titulo, String autor, boolean disponible,
                 double duracion, String formato) {
        super(codigo, titulo, autor, disponible);
        this.duracion = duracion;
        this.formato = formato;
    }

    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Audio:");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Formato: " + formato);
        System.out.println("Disponible: " + disponible);
    }
}
