import java.util.Scanner;

public abstract class Usuario {

    Scanner leer= new Scanner(System.in);

    int id;
    String nombre;
    String correo;
    String contraseña;
    boolean sancionado;

    public Usuario(int id, String nombre, String correo, String contraseña, boolean sancionado){
        this.id= id;
        this.nombre= nombre;
        this.correo= correo;
        this.contraseña= contraseña;
        this.sancionado= false;
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
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public boolean isSancionado() {
        return sancionado;
    }
    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

    public void registrarse(){
        System.out.println("Ingrese su nombre completo");
        this.nombre= nombre;
        System.out.println("Ingrese su correo");
        this.correo= correo;
        System.out.println("Ingrese su contraseña");
        this.contraseña= contraseña;
    }

    public void iniciarSesion(){
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