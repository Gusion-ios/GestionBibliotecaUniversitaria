public class DispositivoMultimedia {
    private String tipo;
    private int codigo;
    private boolean disponible;

    public DispositivoMultimedia(String tipo, int codigo, boolean disponible) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void prestar() {
        disponible = false;
    }

    public void devolver() {
        disponible = true;
    }

    public void mostrarInfo() {
        System.out.println("Dispositivo:");
        System.out.println("Código: " + codigo);
        System.out.println("Tipo: " + tipo);
        System.out.println("Disponible: " + disponible);
    }
}
