public class Stock {
    private int cantidadDisponible;
    private String ubicacion;
    private Dispositivo dispositivo;

    public Stock(int cantidadDisponible, String ubicacion, Dispositivo dispositivo) {
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacion = ubicacion;
        this.dispositivo = dispositivo;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public String toString() {
        return "Ubicación: " + ubicacion + ", Cantidad: " + cantidadDisponible + ", Dispositivo: " + dispositivo.getTipo();
    }
}
