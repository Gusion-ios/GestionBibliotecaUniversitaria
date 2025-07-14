public class Libro extends Multimedia {

    private String editorial;

    public Libro(int codigo, String titulo, String autor, boolean disponible, String editorial, CategoriaMultimedia categoriaMultimedia) {

        super(codigo, titulo, autor, disponible, categoriaMultimedia);

        this.editorial = editorial;

        this.categoriaMultimedia = categoriaMultimedia;

    }



    public String getEditorial() {

        return editorial;

    }

    public void setEditorial(String editorial) {

        this.editorial = editorial;

    }

    public CategoriaMultimedia getCategoriaMultimedia() {

        return categoriaMultimedia;

    }

    public void setCategoriaMultimedia(CategoriaMultimedia categoriaMultimedia) {

        this.categoriaMultimedia = categoriaMultimedia;

    }



    @Override

    public void mostrarInfo() {

        System.out.println("Código: " + codigo);

        System.out.println("Título: " + titulo);

        System.out.println("Autor: " + autor);

        System.out.println("Editorial: " + editorial);

        System.out.println("Disponible: " + disponible);

        System.out.println("Categoría: " + categoriaMultimedia.getCategoria());

        System.out.println("Descripción: " + categoriaMultimedia.getDescripcion());

    }



}

