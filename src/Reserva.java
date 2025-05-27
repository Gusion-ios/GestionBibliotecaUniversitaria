import java.util.Scanner;

public class Reserva extends Dispositivo{

    Scanner leer= new Scanner(System.in);

    int tiempoReserva;        //En horas
    boolean aprobado;

    public Reserva(int codigo, String tipo, boolean disponible, int tiempoReserva, boolean aprobado) {
        super(codigo, tipo, disponible);
        this.tiempoReserva = tiempoReserva;
        this.aprobado= aprobado;
    }

    public void asignarTiempo(){
        if(aprobado){
            System.out.println("Asigne un tiempo de uso al "+ tipo+ "("+codigo+")");
            tiempoReserva= leer.nextInt();
            System.out.println("Reserva aprobada");
        }else {
            System.out.println("Su reserva fue desaprobada, no se puede asignar un tiempo");
        }
    }

    public void aprobarReserva(){
        aprobado= true;
    }

    public void rechazarReserva(){
        aprobado= false;
    }

}