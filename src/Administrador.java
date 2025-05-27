import java.util.Scanner;

public class Administrador extends Usuario{

    Scanner leer= new Scanner(System.in);

    String cargo;

    public Administrador(int id, String nombre, String correo, String cargo){
        super(id, nombre, correo);
        this.cargo= cargo;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void gestionarUsuario(){
        System.out.println("Mostrando informacion del usuario");
        System.out.println("ID: "+ id);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Correo: "+ correo);
        System.out.println("Cargo: "+ cargo);
    }

    public void gestionarLibros(){

    }

    public


}
