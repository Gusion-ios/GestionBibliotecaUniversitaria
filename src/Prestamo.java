import java.util.Scanner;

public class Prestamo extends Libro {

    Scanner leer= new Scanner(System.in);

    int fechaInicio;
    int fechaFin;

    public Prestamo(String categoria, String descripcion, int codigo, String titulo, String autor, boolean disponible, int fechaInicio, int fechaFin) {
        super(categoria, descripcion, codigo, titulo, autor, disponible);
        this.fechaInicio= fechaInicio;
        this.fechaFin= fechaFin;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public int getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void registrarLibro(){
        String respuesta;
        System.out.println("Libro usado: "+ titulo);
        System.out.println("Codigo: "+ codigo);
        System.out.println("¿Desea cambiar de Libro?");
        respuesta= leer.nextLine();
        if(respuesta.equalsIgnoreCase("Si")){
            System.out.println("Ingrese el titulo del Libro");
            titulo= leer.nextLine();
            System.out.println("Ingrese el codigo del dispositivo");
            codigo= leer.nextInt();
        }else {
            return;
        }
        disponible= false;
    }

    public void devolver(){
        disponible= true;
    }

}