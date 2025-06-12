public class LibroDigital extends Multimedia {
    private String formato;
    private double tamaño;

    public LibroDigital(int codigo, String titulo, String autor, boolean disponible,
                        String formato, double tamaño) {
        super(codigo, titulo, autor, disponible);
        this.formato = formato;
        this.tamaño = tamaño;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Digital:");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Formato: " + formato);
        System.out.println("Tamaño: " + tamaño + " MB");
        System.out.println("Disponible: " + disponible);
    }
}
