import java.util.Scanner;

public class Sancion {

    Scanner leer= new Scanner(System.in);

    private int duracionHoras;
    private boolean sancionActiva;
    private Usuario usuario;
    private String motivo;

    public Sancion(Usuario usuario, String motivo, int duracionHoras){
        this.usuario = usuario;
        this. motivo = motivo;
        this.duracionHoras= duracionHoras;
        this.sancionActiva= false;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public int getDuracionHoras() {
        return duracionHoras;
    }
    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public void aplicarSancion(){
        if(!sancionActiva){
            System.out.println("Sancion aplicada a "+ usuario.getNombre()+ " por un total de "+ duracionHoras+ " horas");
            usuario.setSancionado(true);
            sancionActiva= true;
        }else {
            System.out.println("La sancion ya esta activa");
        }
    }

    public void levantarSancion(){
        if(sancionActiva){
            System.out.println("Sancion levantada a "+ usuario.getNombre());
            usuario.setSancionado(false);
            sancionActiva= false;
        }else {
            System.out.println("No hay sancion que levantar");
        }
    }

    @Override
    public String toString() {
        return "Sanción a: " + usuario.getNombre() +
                "Motivo: " + motivo +
                "Duración: " + duracionHoras + "horas" +
                "Activa: " + (sancionActiva ? "Sí" : "No");
    }

}
