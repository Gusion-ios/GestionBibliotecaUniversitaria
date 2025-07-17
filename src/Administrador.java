import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Administrador extends Usuario<Integer>{

    Scanner leer= new Scanner(System.in);

    private String cargo;
    private Multimedia multimedia;
    private Prestamo prestamo;
    private Dispositivo dispositivo;
    private SalaEstudio salaEstudio;

    protected Set<Usuario> usuariosRegistrados;
    private List<Sancion> historialSanciones = new ArrayList<>();
    private List<Prestamo> prestamosRegistrados = new ArrayList<>();

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
        System.out.println("Registrando nuevo usuario");
        System.out.println("Ingrese el nombre");
        String nombre= leer.nextLine();
        System.out.println("Ingrese el correo");
        String correo= leer.nextLine();
        for (Usuario u : usuariosRegistrados) {
            if (u.getCorreo().equals(correo)) {
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

    public void InfoUsuario(){
        System.out.println("Ingrese el id del Usuairo a mostrar informacion: ");
        int IdBuscado= leer.nextInt();
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuariosRegistrados) {
            if (u.getId().equals(IdBuscado)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        Usuario usuario;
        System.out.println("Mostrando información del usuario");
        System.out.println("ID: " + usuarioEncontrado.getId());
        System.out.println("Nombre: " + usuarioEncontrado.getNombre());
        System.out.println("Correo: " + usuarioEncontrado.getCorreo());

        if(usuarioEncontrado instanceof Alumno){
            Alumno a = (Alumno) usuarioEncontrado;
            System.out.println("Tipo: Alumno");
            System.out.println("Carrera: " + a.getCarrera());
            System.out.println("Semestre: " + a.getSemestre());
        }else if (usuarioEncontrado instanceof Docente){
            Docente d = (Docente) usuarioEncontrado;
            System.out.println("Tipo: Docente");
            System.out.println("Especialidad: " + d.getEspecialidad());
        }else if (usuarioEncontrado instanceof Administrador){
            System.out.println("Tipo: Administrador");
        }else {
            System.out.println("Tipo: Desconocido");
        }
    }

    public void gestionarMultimedia() {
        int opcion;
        do {
            System.out.println("\n---- GESTIÓN DE MULTIMEDIA ----");
            System.out.println("1. Agregar nuevo material");
            System.out.println("2. Listar materiales existentes");
            System.out.println("3. Buscar material por título");
            System.out.println("4. Eliminar material por título");
            System.out.println("5. Prestar material");
            System.out.println("6. Devolver material");
            System.out.println("7. Volver al menú principal");
            System.out.println("8. Salir del comando");
            System.out.print("Seleccione una opción: ");
            while (!leer.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                leer.next();
            }
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    agregarMultimedia();
                    break;
                case 2:
                    listarMultimedia();
                    break;
                case 3:
                    buscarMultimedia();
                    break;
                case 4:
                    eliminarMultimedia();
                    break;
                case 5:
                    prestarMultimedia();
                    break;
                case 6:
                    devolverMultimedia();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 7);
    }

    private void agregarMultimedia(){
        System.out.println("Ingrese un codigo: ");
        int codigo = leer.nextInt();
        System.out.print("Ingrese el título: ");
        String titulo = leer.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = leer.nextLine();
        System.out.print("Ingrese el tipo (Libro, Libro Digital, Video, Audio): ");
        String tipo = leer.nextLine();
        System.out.println("Ingrese la categoria de la multimedia");
        String categoria = leer.nextLine();
        System.out.println("Ingrese la descripcion");
        String descripcion = leer.nextLine();
        CategoriaMultimedia cat = new CategoriaMultimedia(categoria, descripcion);
        Multimedia nuevo;
        if (tipo.equalsIgnoreCase("Libro")) {
            System.out.print("Ingrese la editorial: ");
            String editorial = leer.nextLine();
            leer.nextLine();
            nuevo = new Libro(codigo, titulo, autor, true, editorial, cat);
        } else if (tipo.equalsIgnoreCase("Libro Digital")) {
            System.out.print("Ingrese el tamaño del libro: ");
            double tamaño = leer.nextDouble();
            leer.nextLine();
            System.out.println("Ingrese el formato del libro: ");
            String formato = leer.nextLine();
            nuevo = new LibroDigital(codigo, titulo,autor,true, tamaño, formato, cat);
        } else if (tipo.equalsIgnoreCase("Video")) {
            System.out.print("Ingrese la duración en minutos: ");
            int duracion = leer.nextInt();
            leer.nextLine();
            System.out.println("Ingrese la resolucion del video: ");
            String resolucion = leer.nextLine();
            nuevo = new Video(codigo, titulo,autor,true, duracion, resolucion, cat);
        } else if (tipo.equalsIgnoreCase("Audio")) {
            System.out.print("Ingrese la duracion del audio: ");
            int duracion = leer.nextInt();
            System.out.println("Ingrese el formato del audio: ");
            String formato = leer.nextLine();
            nuevo = new Audio(codigo,titulo, autor, true, cat, duracion, formato);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }
        Multimedia.listaRecursos.add(nuevo);
        System.out.println("Material agregado con éxito.");
    }

    private void listarMultimedia(){
        if (Multimedia.listaRecursos.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        for (Multimedia m : Multimedia.listaRecursos) {
            System.out.println(m);
        }
    }

    private void buscarMultimedia(){
        System.out.print("Ingrese el título a buscar: ");
        String titulo = leer.nextLine();
        boolean encontrado = false;
        for (Multimedia m : Multimedia.listaRecursos) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado: " + m);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró material con ese título.");
        }
    }

    private void eliminarMultimedia(){
        System.out.print("Ingrese el título del material a eliminar: ");
        String titulo = leer.nextLine();
        Multimedia encontrado = null;
        for (Multimedia m : Multimedia.listaRecursos) {
            if (m.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = m;
                break;
            }
        }
        if (encontrado != null) {
            Multimedia.listaRecursos.remove(encontrado);
            System.out.println("Material eliminado.");
        } else {
            System.out.println("No se encontró material con ese título.");
        }
    }

    private void prestarMultimedia() {
        System.out.print("Ingrese el título del material a prestar: ");
        String titulo = leer.nextLine();
        Multimedia seleccionado = null;
        for (Multimedia m : Multimedia.listaRecursos) {
            if (m.getTitulo().equalsIgnoreCase(titulo) && m.isDisponible()) {
                seleccionado = m;
                break;
            }
        }
        if (seleccionado == null) {
            System.out.println("Material no disponible o no encontrado.");
            return;
        }
        System.out.print("Ingrese nombre del usuario que realiza el préstamo: ");
        String nombre = leer.nextLine();
        Usuario usuario= null;
        for(Usuario u: usuariosRegistrados) {
            if (u.getNombre().equalsIgnoreCase(nombre)) {
                usuario = u;
                break;
            }
        }
        if (usuario == null) {
            System.out.println("Usuario no encontrado. Debe estar registrado para realizar préstamos.");
            return;
        }
        Prestamo p = new Prestamo(usuario, seleccionado);
        p.registrarPrestamo();
        Prestamo.prestamos.add(p);
    }

    private void devolverMultimedia() {
        System.out.print("Ingrese el título del material a devolver: ");
        String titulo = leer.nextLine();
        Prestamo encontrado = null;
        for (Prestamo p : Prestamo.prestamos) {
            if (p.getMultimedia().getTitulo().equalsIgnoreCase(titulo) && !p.getMultimedia().isDisponible()) {
                encontrado = p;
                break;
            }
        }
        if (encontrado == null) {
            System.out.println("No se encontró préstamo activo para ese material.");
            return;
        }
        encontrado.devolver();
    }

    public void gestionarUsuario() {
        int opcion;
        do {
            System.out.println("\n---- GESTIÓN DE USUARIOS ----");
            System.out.println("1. Sancionar usuario");
            System.out.println("2. Liberar sanción");
            System.out.println("3. Ver historial de sanciones");
            System.out.println("4. Aprobar reserva dispositivo");
            System.out.println("5. Aprobar reserva sala de estudio");
            System.out.println("6. Liberar reserva dispositivo");
            System.out.println("7. Liberar reserva sala de estudio");
            System.out.println("8. Registrar Usuario");
            System.out.println("9. Mostrar informacion de un usuario");
            System.out.println("10. Volver al menú principal");
            System.out.println("11. Salir del comando");
            System.out.print("Seleccione una opción: ");
            while (!leer.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                leer.next();
            }
            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:
                    sancionarUsuario();
                    break;
                case 2:
                    liberarSancion();
                    break;
                case 3:
                    verHistorialSanciones();
                    break;
                case 4:
                    dispositivo.aprobarReserva();
                    break;
                case 5:
                    salaEstudio.aprobarReserva();
                    break;
                case 6:
                    dispositivo.liberarReserva();
                    break;
                case 7:
                    salaEstudio.liberarReserva();
                    break;
                case 8:
                    registrarUsuario();
                    break;
                case 9:
                    InfoUsuario();
                    break;
                case 10:
                    System.out.println("Volviendo el menu principal");;
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 4);
    }


    private void sancionarUsuario() {
        System.out.println("Ingrese el correo del usuario a sancionar");
        String correo = leer.nextLine();
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuariosRegistrados) {
            if (u.getCorreo().equals(correo)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            System.out.println("No se encontro un usuario con este correo");
            return;
        }
        if (!usuarioEncontrado.isSancionado()) {
            Sancion sancion = new Sancion(usuarioEncontrado, "", null, null);
            sancion.aplicarSancion();
            historialSanciones.add(sancion);
        } else{
            System.out.println("El usuario ya se encuentra sancionado.");
        }
    }

    private void liberarSancion(){
        System.out.println("Ingrese el correo del usuario sancionado: ");
        String correo= leer.nextLine();
        Usuario usuarioEncontrado= null;
        for (Usuario u : usuariosRegistrados) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if(usuarioEncontrado== null){
            System.out.println("No se encontro un usuario con este correo");
            return;
        }
        if (!usuarioEncontrado.isSancionado()) {
            System.out.println("El usuario no se encuentra sancionado");
            return;
        }
        for(Sancion sancion: historialSanciones){
            if(sancion.getUsuario().equals(usuarioEncontrado) && sancion.isSancionActiva()){
                sancion.levantarSancion();
                return;
            }
        }
    }

    private void verHistorialSanciones() {
        if (historialSanciones.isEmpty()) {
            System.out.println("No hay sanciones registradas.");
        } else {
            System.out.println("Historial de sanciones:");
            for (Sancion s : historialSanciones) {
                System.out.println(s);
            }
        }
    }

    public void gestionarDispositivosSalaEstudio() {
        int opcion;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("\n---- GESTIÓN DE DISPOSITIVOS Y SALAS ----");
            System.out.println("1. Mostrar todos los dispositivos");
            System.out.println("2. Mostrar todas las salas de estudio");
            System.out.println("3. Buscar y aprobar/liberar reserva de un dispositivo");
            System.out.println("4. Buscar y aprobar/liberar reserva de una sala");
            System.out.println("5. Actualizar stock de un dispositivo");
            System.out.println("6. Volver al menú principal");
            System.out.println("7. Salir del comando");
            System.out.print("Seleccione una opción: ");

            while (!leer.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                leer.next();
            }
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nDISPOSITIVOS REGISTRADOS:");
                    Dispositivo.mostrarTodos();
                    break;
                case 2:
                    System.out.println("\nSALAS DE ESTUDIO REGISTRADAS:");
                    SalaEstudio.mostrarSalas();
                    break;
                case 3:
                    reservaDispositivo();
                    break;
                case 4:
                    reservaSala();
                    break;
                case 5:
                    actualizarStock();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 6);
    }

    private void reservaDispositivo(){
        System.out.print("Ingrese el código del dispositivo: ");
        int codDisp = leer.nextInt();
        leer.nextLine();
        boolean encontradoDisp = false;
        for (Dispositivo d : Dispositivo.listaDispositivos) {
            if (d.getCodigo() == codDisp) {
                d.mostrarInfo();
                System.out.println("1. Aprobar reserva");
                System.out.println("2. Liberar reserva");
                System.out.print("Seleccione una opción: ");
                int subOpcion = leer.nextInt();
                leer.nextLine();
                if (subOpcion == 1) d.aprobarReserva();
                else if (subOpcion == 2) d.liberarReserva();
                else System.out.println("Opción inválida.");
                encontradoDisp = true;
                break;
            }
        }
        if (!encontradoDisp) System.out.println("Dispositivo no encontrado.");
    }

    private void reservaSala(){
        System.out.print("Ingrese el número de la sala: ");
        int numSala = leer.nextInt();
        leer.nextLine();
        boolean encontradaSala = false;
        for (SalaEstudio s : SalaEstudio.espacios) {
            if (s.getNumeroSala() == numSala) {
                s.mostrarInfo();
                System.out.println("1. Aprobar reserva");
                System.out.println("2. Liberar reserva");
                System.out.print("Seleccione una opción: ");
                int subOpcion = leer.nextInt();
                leer.nextLine();
                if (subOpcion == 1) s.aprobarReserva();
                else if (subOpcion == 2) s.liberarReserva();
                else System.out.println("Opción inválida.");
                encontradaSala = true;
                break;
            }
        }
        if (!encontradaSala) System.out.println("Sala no encontrada.");
    }

    private void actualizarStock(){
        System.out.print("Ingrese el código del dispositivo: ");
        int codigoActualizar = leer.nextInt();
        leer.nextLine();
        boolean encontradoActualizar = false;
        for (Dispositivo d : Dispositivo.listaDispositivos) {
            if (d.getCodigo() == codigoActualizar) {
                d.actualizarStock();
                encontradoActualizar = true;
                break;
            }
        }
        if (!encontradoActualizar) System.out.println("Dispositivo no encontrado.");
    }

}