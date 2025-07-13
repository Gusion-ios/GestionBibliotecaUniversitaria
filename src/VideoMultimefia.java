public class Video extends Multimedia{

    private int duracion;

    private String resolucion;

    public Video(int codigo, String titulo, String autor, boolean disponible, int duracion, String resolucion, CategoriaMultimedia categoriaMultimedia) {

        super(codigo, titulo, autor, disponible, categoriaMultimedia);

        this.duracion = duracion;

        this.resolucion = resolucion;

        this.categoriaMultimedia = categoriaMultimedia;

    }


    public int getDuracion() {

        return duracion;

    }

    public void setDuracion(int duracion) {

        this.duracion = duracion;

    }

    public String getResolucion() {

        return resolucion;

    }

    public void setResolucion(String resolucion) {

        this.resolucion = resolucion;

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
        System.out.println("Resolucion: "+ resolucion);
        System.out.println("Disponible: "+ disponible);
        System.out.println("Categoría: " + categoriaMultimedia.getCategoria());
        System.out.println("Descripción: " + categoriaMultimedia.getDescripcion());

    }

}

