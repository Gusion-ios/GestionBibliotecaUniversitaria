import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario{

    private String especialidad;
    Multimedia multimedia;
    List<Multimedia> listaRecursos;
    Dispositivo dispositivo;
    List<Dispositivo> listaDispositivos;
    SalaEstudio salaEstudio;
    ArrayList<SalaEstudio> espacios;

    public Docente(int id, String nombre, String correo, String contraseña, boolean sancionado,String especialidad){
        super(id, nombre, correo, contraseña, sancionado);
        this.especialidad= especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void menuDocente() {
        int opcion;
        do {
            System.out.println("\n---- MENÚ DE ALUMNO ----");
            System.out.println("1. Ver material multimedia disponible");
            System.out.println("2. Reservar material multimedia");
            System.out.println("3. Ver salas disponibles");
            System.out.println("4. Reservar sala");
            System.out.println("5. Ver dispositivos disponibles");
            System.out.println("6. Reservar dispositivo");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            while (!leer.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                leer.next();
            }
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    verMultimedia();
                    break;
                case 2:
                    reservarMultimedia();
                    break;
                case 3:
                    verSalas();
                    break;
                case 4:
                    reservarSala();
                    break;
                case 5:
                    verDispositivos();
                    break;
                case 6:
                    reservarDispositivo();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 7);
    }
    private void verMultimedia() {
        System.out.println("[Multimedia]");
        for(Multimedia u: listaRecursos){
            u.mostrarInfo();
        }
    }

    private void reservarMultimedia() {
        System.out.println("[Reservar multimedia]");
        for(Multimedia u: listaRecursos){
            u.mostrarInfo();
        }
        System.out.println("Ingrese el ID del recurso que desea reservar: ");
        int codigoBuscado= leer.nextInt();
        for(Multimedia u: listaRecursos){
            if(u.isDisponible()== true && u.getCodigo()== codigoBuscado){
                System.out.println("Multimedia reservada con exito");
                u.setDisponible(false);
                return;
            }
        }
    }

    private void verSalas() {
        System.out.println("[Salas]");
        SalaEstudio.mostrarSalas();
    }

    private void reservarSala() {
        System.out.println("[Reservar sala]");
        SalaEstudio.mostrarSalas();
        System.out.println("Ingrese el numero de sala a reservar");
        int salaBuscada= leer.nextInt();
        for(SalaEstudio s: espacios){
            if(s.isDisponible()== true && s.getNumeroSala()== salaBuscada){
                System.out.println("Sala "+ s.getNumeroSala()+ " reservada con exito");
                s.setDisponible(false);
                return;
            }
        }
    }

    private void verDispositivos() {
        System.out.println("[Dispositivos ]");
        for(Dispositivo d: listaDispositivos){
            d.mostrarInfo();
        }
    }

    private void reservarDispositivo() {
        for(Dispositivo d: listaDispositivos){
            d.mostrarInfo();
        }
        System.out.println("[Reservar dispositivo]");
        System.out.println("Ingrese el codigo del dispositivo a reservar");
        int codigoBuscado= leer.nextInt();
        for(Dispositivo d: listaDispositivos){
            if(d.isDisponible()== true && d.getCodigo()== codigoBuscado){
                System.out.println("Dispositivo reservado con exito");
                d.setDisponible(false);
                return;
            }
        }
    }

}