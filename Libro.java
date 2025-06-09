public class Libro extends Multimedia {
    private String editorial;
    private int paginas;
    private CategoriaLibro categoriaLibro;

    public Libro(String codigo, String titulo, String estadoDisponibilidad, String editorial, int paginas, CategoriaLibro categoriaLibro) {
        super(codigo, titulo, estadoDisponibilidad);
        this.editorial = editorial;
        this.paginas = paginas;
        this.categoriaLibro = categoriaLibro;
    }

    public CategoriaLibro getCategoriaLibro() {
        return categoriaLibro;
    }

    public void setCategoriaLibro(CategoriaLibro categoriaLibro) {
        this.categoriaLibro = categoriaLibro;
    }

    // Otros getters y setters opcionales
}
