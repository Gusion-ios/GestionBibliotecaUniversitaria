public class Libro extends CategoriaLibro{

    int codigo;
    String titulo;
    String autor;
    boolean disponible;

    public Libro(String categoria, String descripcion, int codigo, String titulo, String autor, boolean disponible){
        super(categoria, descripcion);
        this.codigo= codigo;
        this.titulo= titulo;
        this.autor= autor;
        this.disponible= disponible;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void estaDisponible() {
        if (disponible) {
            System.out.println("Libro "+ titulo+ ": disponible");
        }else {
            System.out.println("Libro "+ titulo+ ": no disponible");
        }
    }

    public void prestarLibro(){
        disponible= false;
    }

    public void devolverLibro(){
        disponible= true;
    }

    public void mostrarInfo(){
        System.out.println("Codigo: "+ codigo);
        System.out.println("Titulo: "+ titulo);
        System.out.println("Categoria: "+ categoria);
        System.out.println("Autor: "+ autor);
        System.out.println("Descripcion: "+ descripcion);
        System.out.println("Disponible: "+ disponible);
    }

}