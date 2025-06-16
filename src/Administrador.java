public class Administrador extends Usuario implements Reserva{

    String cargo;

    public Administrador(int id, String nombre, String correo, String contraseña, boolean sancionado, String  cargo){
        super(id, nombre, correo, contraseña, sancionado);
        this.cargo= cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
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
    }

    public void registrarUsuario(Usuario usuario){

    }


}