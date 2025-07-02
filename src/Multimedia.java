public abstract class Multimedia {

    protected int codigo;
    protected String titulo;
    protected String autor;
    protected boolean disponible;

    public Multimedia(int codigo, String titulo, String autor, boolean disponible){
        this.codigo = codigo;
        this.titulo= titulo;
        this.autor= autor;
        this. disponible= disponible;
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

    public void prestar(){

    }

    public void devolver(){

    }

    public void mostrarInfo(){

    }

}
