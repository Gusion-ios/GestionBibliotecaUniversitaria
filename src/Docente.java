public class Docente extends Usuario{

    String especialidad;

    public Docente(int id, String nombre, String correo, String contraseña,String especialidad){
        super(id, nombre, correo, contraseña);
        this.especialidad= especialidad;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void subirMaterial(String curso){
        System.out.println("""
            Material del curso: """ + curso + """
            ha sido subido correctamente por el docente """+ nombre);
    }


}