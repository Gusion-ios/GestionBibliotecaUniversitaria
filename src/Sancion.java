import java.util.Scanner;

public abstract class Sancion {

    Scanner leer= new Scanner(System.in);

    private Usuario usuario;
    private String motivo;

    public Sancion(Usuario usuario, String motivo) {
        this.usuario = usuario;
        this. motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void aplicarSancion(){
        System.out.println("Asigne el tiempo de sancion (En horas)");
        int horasSancion= leer.nextInt();
        System.out.println("Sanción aplicada a "+ usuario.getNombre() + " por "+ getMotivo()+ " un total de "+ horasSancion+ " horas");
        usuario.setSancionado(true);
    }

    public void levantarSanncion(){
        System.out.println("Sanción levantada a "+ usuario.getNombre() + " por "+ getMotivo());
        usuario.setSancionado(false);
    }

}
