public class Dispositivo implements Reservable{

    int codigo;
    String tipo;
    boolean disponible;

    public Dispositivo(int codigo, String tipo, boolean disponible){
        this.codigo= codigo;
        this.tipo= tipo;
        this.disponible= disponible;
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

    @Override
    public void reservar(){
        disponible= false;
    }

    @Override
    public void liberar(){
        disponible= true;
    }

    public void mostrarInfo(){
        System.out.println("Codigo: "+ codigo);
        System.out.println("Tipo: "+ tipo);
        System.out.println("Disponible: "+ disponible);
    }

}