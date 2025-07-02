import java.util.Scanner;

public class Prestamo {

    Scanner leer= new Scanner(System.in);

    private Usuario usuario;
    private Multimedia multimedia;
    private int fechaInicio;
    private int fechaFin;

    public Prestamo(Usuario usuario, Multimedia multimedia, int fechaInicio, int fechaFin) {
        this.usuario= usuario;
        this.multimedia= multimedia;
        this.fechaInicio= fechaInicio;
        this.fechaFin= fechaFin;
        multimedia.setDisponible(false);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Multimedia getMultimedia() {
        return multimedia;
    }
    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }
    public int getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public int getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void registrarPrestamo(){
        if (usuario.isSancionado()) {
            System.out.println("El usuario está sancionado y no puede realizar préstamos.");
            return;
        }
        if (!multimedia.isDisponible()) {
            System.out.println("El recurso ya está prestado.");
            return;
        }
        System.out.println("Realizando el prestamo de la multimedia "+ multimedia.getTitulo());
        System.out.println("Tipo: "); //aqui va las hijas de multimedia
        //aqui va el resto de la informacion
        multimedia.setDisponible(false);
    }

    public void devolver(){
        multimedia.setDisponible(true);
        System.out.println("Multimedia devuelta: "+ multimedia.getTitulo());
    }

    public void mostrarInfo(){
        System.out.println("Se presto a "+ usuario.getNombre());
        System.out.println("El recurso "+ multimedia.getTitulo());
        System.out.println("Fecha de inicio: "+ fechaInicio);
        System.out.println("Fecha de fin: "+ fechaFin);
    }

}