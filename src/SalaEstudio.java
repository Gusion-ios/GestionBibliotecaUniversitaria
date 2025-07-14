import java.util.ArrayList;
import java.util.Scanner;

public class SalaEstudio implements Reservable {

    private static final Scanner leer = new Scanner(System.in);

    private int numeroSala;
    private int capacidad;
    private boolean disponible;
    protected static ArrayList<SalaEstudio> espacios = new ArrayList<>();

    public SalaEstudio(int numeroSala, int capacidad, boolean disponible) {
        this.numeroSala = numeroSala;
        this.capacidad = capacidad;
        this.disponible = disponible;
        espacios.add(this);
    }

    public int getNumeroSala() {
        return numeroSala;
    }
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInfo() {
        System.out.println("Número de Sala: " + numeroSala);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Disponible: " + disponible);
    }

    @Override
    public void aprobarReserva() {
        boolean respondido = false;
        while (!respondido) {
            System.out.println("¿Aprueba la reserva? Si/No");
            String respuesta = leer.nextLine();
            if (respuesta.equalsIgnoreCase("Si")) {
                System.out.println("Ingrese la cantidad de horas a reservar:");
                int cantidadHoras = leer.nextInt();
                leer.nextLine();
                this.disponible = false;
                System.out.println("Reserva aprobada por " + cantidadHoras + " horas");
                respondido = true;
            } else if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Se desaprobó la reserva de la sala " + numeroSala);
                respondido = true;
            } else {
                System.out.println("Respuesta inválida. Intente nuevamente");
            }
        }
    }

    @Override
    public void liberarReserva() {
        if (disponible) {
            System.out.println("La sala ya se encuentra libre y disponible para reservar.");
        } else {
            disponible = true;
            System.out.println("Se liberó la sala " + numeroSala + " con éxito.");
        }
    }

    public static void buscarSala() {
        System.out.print("Ingrese el número de la sala buscada: ");
        int codigoBuscado = leer.nextInt();
        leer.nextLine();
        boolean encontrado = false;
        for (SalaEstudio s : espacios) {
            if (s.getNumeroSala() == codigoBuscado) {
                s.mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Sala no encontrada.");
        }
    }

    public static void mostrarSalas() {
        if (espacios.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            for (SalaEstudio s : espacios) {
                s.mostrarInfo();
                System.out.println("-------------------------");
            }
        }
    }
}
