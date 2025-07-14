public abstract class Stock {

    protected int cantidadDisponible;
    protected String ubicacion;

    public Stock(int cantidadDisponible, String ubicacion) {
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacion = ubicacion;
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

    public void actualizarStock(){
        //Sobreescritura de metodo en la clase hija
    }

    public void consultarStock(){
        //Sobreescritura de metodo en la clase hija
    }

}
