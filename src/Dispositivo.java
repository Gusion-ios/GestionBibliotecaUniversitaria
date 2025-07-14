import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Dispositivo extends Stock implements Reservable{

    Scanner leer= new Scanner(System.in);

    protected int codigo;
    protected String tipo;
    protected boolean disponible;
    protected static List<Dispositivo> listaDispositivos = new ArrayList<>();

    public Dispositivo(int cantidadDisponible, String ubicacion, int codigo, String tipo, boolean disponible) {
        super(cantidadDisponible, ubicacion);
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponible = disponible;
        listaDispositivos.add(this);
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInfo(){
        System.out.println("Codigo: "+ codigo);
        System.out.println("Tipo: "+ tipo);
        System.out.println("Disponible: "+ disponible);
    }

    @Override
    public void actualizarStock(){
        System.out.println("Ingrese la cantidad de "+ tipo+"'s actualizada");
        int nuevoStock= leer.nextInt();
        this.cantidadDisponible=nuevoStock;
        System.out.println("Cantidad actualizada");
    }

    @Override
    public void consultarStock(){
        System.out.println("Se contiene un total de "+ cantidadDisponible+ " de "+ tipo);
    }

    public static void mostrarTodos() {
        for (Dispositivo d : listaDispositivos) {
            d.mostrarInfo();
            System.out.println("-------------------------");
        }
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
                System.out.println("Reserva aprobada por " + cantidadHoras + " horas.");
                respondido = true;
            } else if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Se desaprobó la reserva del dispositivo " + tipo + ".");
                respondido = true;
            } else {
                System.out.println("Respuesta inválida. Intente nuevamente.");
            }
        }
    }

    @Override
    public void liberarReserva(){
        if(disponible){
            System.out.println("El dispositivo se encuentra libre y dispuesto a ser reservado");
        }else {
            disponible= true;
            System.out.println("Se libero el dispositivo"+ tipo+ " con exito");
        }
    }

    public static void buscarPorCodigo() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese el código del dispositivo buscado: ");
        int codigoBuscado = leer.nextInt();
        leer.nextLine();
        boolean encontrado = false;
        for (Dispositivo d : listaDispositivos) {
            if (d.getCodigo() == codigoBuscado) {
                d.mostrarInfo();
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Dispositivo no encontrado.");
        }
    }

}
