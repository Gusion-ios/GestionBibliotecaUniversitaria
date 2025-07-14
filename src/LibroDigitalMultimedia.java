public class LibroDigital extends Multimedia {

    private double tamaño;

    private String formato;

    public LibroDigital(int codigo, String titulo, String autor, boolean disponible, double tamaño, String formato, CategoriaMultimedia categoriaMultimedia) {

        super(codigo, titulo, autor, disponible, categoriaMultimedia);

        this.tamaño = tamaño;

        this.formato = formato;

        this.categoriaMultimedia = categoriaMultimedia;

    }

    public double getTamaño() {

        return tamaño;
    }

    public void setTamaño(double tamaño) {

        this.tamaño = tamaño;
    }

    public String getFormato() {

        return formato;
    }

    public void setFormato(String formato) {

        this.formato = formato;
    }

    public CategoriaMultimedia getCategoriaMultimedia() {

        return categoriaMultimedia;
    }

    public void setCategoriaMultimedia(CategoriaMultimedia categoriaMultimedia) {

        this.categoriaMultimedia = categoriaMultimedia;
    }

    @Override

    public void mostrarInfo() {

        System.out.println("Codigo: "+ codigo);

        System.out.println("Titulo: "+ titulo);

        System.out.println("Autor: "+ autor);

        System.out.println("Tamaño: "+ tamaño);

        System.out.println("Formato: "+ formato);

        System.out.println("Disponible: "+ disponible);

        System.out.println("Categoría: " + categoriaMultimedia.getCategoria());

        System.out.println("Descripción: " + categoriaMultimedia.getDescripcion());


    }

}

