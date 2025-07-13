public class Audio extends Multimedia{



    private int duracion;

    private String formato;



    public Audio(int codigo, String titulo, String autor, boolean disponible, CategoriaMultimedia categoriaMultimedia, int duracion, String formato ) {

        super(codigo, titulo, autor, disponible, categoriaMultimedia);

        this.duracion = duracion;

        this.formato = formato;

        this.categoriaMultimedia = categoriaMultimedia;

    }



    public int getDuracion() {

        return duracion;

    }

    public void setDuracion(int duracion) {

        this.duracion = duracion;

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

        System.out.println("Duracion: "+ duracion);

        System.out.println("Formato: "+ formato);

        System.out.println("Disponible: "+ disponible);

        System.out.println("Categoría: " + categoriaMultimedia.getCategoria());

        System.out.println("Descripción: " + categoriaMultimedia.getDescripcion());

    }



}

