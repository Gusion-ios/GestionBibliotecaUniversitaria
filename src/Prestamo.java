import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Prestamo {

    Scanner leer= new Scanner(System.in);

    private Usuario usuario;
    private Multimedia multimedia;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    protected static List<Prestamo> prestamos = new ArrayList<>();

    public Prestamo(Usuario usuario, Multimedia multimedia) {
        this.usuario= usuario;
        this.multimedia= multimedia;
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
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public LocalDateTime getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void registrarPrestamo(){
        if (usuario.isSancionado()) {
            System.out.println("El usuario está sancionado y no puede realizar préstamos");
            return;
        }
        if (!multimedia.isDisponible()) {
            System.out.println("El recurso no se encuentra disponible");
            return;
        }
        System.out.println("Realizando el prestamo de la multimedia "+ multimedia.getTitulo());
        if(multimedia instanceof Video){
            System.out.println("Tipo: Video");
            System.out.println("Ingrese la cantidad de dias a prestar");
        }
        if(multimedia instanceof Libro){
            System.out.println("Tipo: Libro");
        }
        if(multimedia instanceof LibroDigital){
            System.out.println("Tipo: Libro Digital");
        }
        if(multimedia instanceof Audio){
            System.out.println("Tipo: Audio");
        }
        multimedia.mostrarInfo();
        int diasPrestado= 0;
        System.out.println("Ingrese la cantidad de dias a prestar");
        diasPrestado= leer.nextInt();
        leer.nextLine();
        this.fechaInicio= LocalDateTime.now();
        this.fechaFin= fechaInicio.plusDays(diasPrestado);
        multimedia.setDisponible(false);
        System.out.println("Prestamo registrado desde "+ fechaInicio+ " hasta "+ fechaFin);
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