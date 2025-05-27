import java.util.Scanner;

public class Usuario {

    Scanner leer= new Scanner(System.in);

    int id;
    String nombre;
    String correo;
    String tipo;                //Alumno o Estudiante

    public Usuario(int id, String nombre, String correo, String tipo){
        this.id= id;
        this.nombre= nombre;
        this.correo= correo;
        this.tipo= tipo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void iniciarSesion(String contraseña){
        int contador= 0;
        String correroPrueba= "";
        String contraseñaPrueba= "";
        do{
            System.out.println("Ingrese su correo");
            correroPrueba= leer.nextLine();
            System.out.println("Ingrese su contraseña");
            contraseñaPrueba= leer.nextLine();
            if(contraseñaPrueba.equals(contraseña) && correroPrueba.equals(correo)){
                contador++;
            }else {
                System.out.println("Credenciales incorrectas");
            }
        }while(contador== 1);
    }

    public void cerrarSesion(){
        System.out.println("Sesion cerrada");
    }

}