public class LibroMultimedia extends Multimedia {
    private String editorial;
    private int paginas;

    public LibroMultimedia(int codigo, String titulo, String autor, boolean disponible,
                           String editorial, int paginas) {
        super(codigo, titulo, autor, disponible);
        this.editorial = editorial;
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro Multimedia:");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        System.out.println("Páginas: " + paginas);
        System.out.println("Disponible: " + disponible);
    }
}
