import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Administrador extends Usuario {//implements Reservable

    Scanner leer= new Scanner(System.in);

    private String cargo;

    private Set<Usuario> usuariosRegistrados;
    private List<Sancion> historialSanciones = new ArrayList<>();

    public Administrador(int id, String nombre, String correo, String contraseña, boolean sancionado, String  cargo){
        super(id, nombre, correo, contraseña, false);
        this.cargo= cargo;
        this.usuariosRegistrados= new HashSet<>();
        this.historialSanciones= new ArrayList<>();
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void registrarUsuario(){
        System.out.println("Ingrese el nombre");
        String nombre= leer.nextLine();
        System.out.println("Ingrese el correo");
        String correo= leer.nextLine();
        for (Usuario u : usuariosRegistrados) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                System.out.println("Este correo ya está registrado");
                return;
            }
        }
        System.out.println("Ingrese la contraseña");
        String contraseña= leer.nextLine();
        Usuario nuevo= null;
        boolean tipoValido = false;
        do {
            System.out.print("Ingrese el tipo (Docente, Alumno): ");
            String tipo = leer.nextLine();
            if (tipo.equalsIgnoreCase("Docente")) {
                System.out.print("Especialidad: ");
                String especialidad = leer.nextLine();
                nuevo = new Docente(usuariosRegistrados.size() + 1, nombre, correo, contraseña, false, especialidad);
                tipoValido = true;
            } else if (tipo.equalsIgnoreCase("Alumno")) {
                System.out.print("Carrera: ");
                String carrera = leer.nextLine();
                System.out.print("Semestre: ");
                int semestre = leer.nextInt();
                leer.nextLine();
                nuevo = new Alumno(usuariosRegistrados.size() + 1, nombre, correo, contraseña, false, carrera, semestre);
                tipoValido = true;
            } else {
                System.out.println("Tipo inválido, intentelo de nuevo");
            }
        } while (!tipoValido);
        usuariosRegistrados.add(nuevo);
        System.out.println("Usuario registrado exitosamente");
    }

    public void InfoUsuario(Usuario usuario){
        System.out.println("Mostrando información del usuario");
        System.out.println("ID: " + usuario.getId());
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Correo: " + usuario.getCorreo());

        if(usuario instanceof Alumno){
            Alumno a = (Alumno) usuario;
            System.out.println("Tipo: Alumno");
            System.out.println("Carrera: " + a.getCarrera());
            System.out.println("Semestre: " + a.getSemestre());
        }else if (usuario instanceof Docente){
            Docente d = (Docente) usuario;
            System.out.println("Tipo: Docente");
            System.out.println("Especialidad: " + d.getEspecialidad());
        }else if (usuario instanceof Administrador){
            System.out.println("Tipo: Administrador");
        }else {
            System.out.println("Tipo: Desconocido");
        }
    }

    public void gestionarLibros(){
    }

    public void gestionarReserva(){
    }

    public void gestionarBiblioteca(){
    }

    public void sancionarUsuario(Usuario usuario, Sancion sancion){
        if(!usuario.isSancionado()){
            sancion.aplicarSancion();
            historialSanciones.add(sancion);
            System.out.println("Sancion registrada en el histortial de "+ usuario.getNombre());
        }else {
            System.out.println("El usuario "+ usuario.getNombre()+ " ya se encuentra sancionado");
        }
    }

    public void verHistorialSanciones() {
        if (historialSanciones.isEmpty()) {
            System.out.println("No hay sanciones registradas.");
        } else {
            System.out.println("Historial de sanciones:");
            for (Sancion s : historialSanciones) {
                System.out.println(s);
            }
        }
    }

    public void asignarTiempo(){

    }
    public void aprobarReserva(){

    }
    public void rechazarReserva(){

    }


}