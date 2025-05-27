import java.util.Scanner;

public class SalaEstudio implements Reservable{

    Scanner leer= new Scanner(System.in);

    int numeroSala;
    int capacidad;
    boolean disponible;

    public SalaEstudio(int numeroSala, int capacidad, boolean disponible){
        this.numeroSala= numeroSala;
        this.capacidad= capacidad;
        this.disponible= disponible;
    }

    @Override
    public void reservar(){
        System.out.println("Ingrese la cantidad de personas que asistiran");
        int personas= leer.nextInt();
        if(personas<= capacidad && personas>0){
            System.out.println("Sala reservada");
            disponible= false;
        }else if(personas> capacidad){
            System.out.println("Capacidad no permitida");
        } else if(personas< 0){
            System.out.println("Error: ingrese numeros validos");
        }
    }

    @Override
    public void liberar(){
        disponible= true;
    }

}