import java.util.Scanner;
import java.time.LocalDateTime;

public class Sancion {

    Scanner leer = new Scanner(System.in);

    private boolean sancionActiva;
    private Usuario usuario;
    private String motivo;
    private LocalDateTime inicioSancion;
    private LocalDateTime finSancion;

    public Sancion(Usuario usuario, String motivo, LocalDateTime inicioSancion, LocalDateTime finSancion) {
        this.usuario = usuario;
        this.motivo= motivo;
        this.inicioSancion= inicioSancion;
        this.finSancion= finSancion;
        this.sancionActiva = false;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public boolean isSancionActiva() {
        return sancionActiva;
    }
    public void setSancionActiva(boolean sancionActiva) {
        this.sancionActiva = sancionActiva;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public LocalDateTime getInicioSancion() {
        return inicioSancion;
    }
    public void setInicioSancion(LocalDateTime inicioSancion) {
        this.inicioSancion = inicioSancion;
    }
    public LocalDateTime getFinSancion() {
        return finSancion;
    }
    public void setFinSancion(LocalDateTime finSancion) {
        this.finSancion = finSancion;
    }

    public void aplicarSancion() {
        if (!sancionActiva) {
            System.out.println("Ingrese el motivo de la suspensión:");
            motivo = leer.nextLine();
            System.out.println("Ingrese la duración de la sanción (en horas)");
            int horas = leer.nextInt();
            leer.nextLine();
            inicioSancion = LocalDateTime.now();
            finSancion = inicioSancion.plusHours(horas);
            usuario.setSancionado(true);
            sancionActiva = true;
            System.out.println("Sanción aplicada a " + usuario.getNombre() + " por " + horas + " horas.");
        } else {
            System.out.println("La sanción ya está activa.");
        }
    }

    public void levantarSancion() {
        if (sancionActiva) {
            usuario.setSancionado(false);
            sancionActiva = false;
            System.out.println("Sanción levantada a " + usuario.getNombre());
        } else {
            System.out.println("No hay sanción que levantar.");
        }
    }

    @Override
    public String toString() {
        return "Sanción a: " + usuario.getNombre() + "\n" +
                "Motivo: " + motivo + "\n" +
                "Inicio: " + inicioSancion + "\n" +
                "Fin: " + finSancion + "\n" +
                "Activa: " + (sancionActiva ? "Sí" : "No");
    }
}
