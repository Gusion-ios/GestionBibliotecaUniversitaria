import java.util.Scanner;

public abstract class Usuario {

    Scanner leer= new Scanner(System.in);

    protected int id;
    protected String nombre;
    protected String correo;
    protected String contraseña;
    protected boolean sancionado;

    public Usuario(int id, String nombre, String correo, String contraseña, boolean sancionado){
        this.id= id;
        this.nombre= nombre;
        this.correo= correo;
        this.contraseña= contraseña;
        this.sancionado= sancionado;
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
        nombre= leer.nextLine();
        System.out.println("Ingrese su correo");
        correo= leer.nextLine();
        System.out.println("Ingrese su contraseña");
        contraseña= leer.nextLine();
    }

    public void iniciarSesion(){
        boolean autenticado = false;
        String correoPrueba = "";
        String contraseñaPrueba= "";
        do{
            System.out.println("Ingrese su correo");
            correoPrueba = leer.nextLine();
            System.out.println("Ingrese su contraseña");
            contraseñaPrueba= leer.nextLine();
            if(contraseñaPrueba.equals(contraseña) && correoPrueba.equals(correo)){
                autenticado = true;
            }else {
                System.out.println("Credenciales incorrectas");
            }
        }while(!autenticado);
    }

    public void cerrarSesion(){
        System.out.println("Sesion cerrada");
    }

}