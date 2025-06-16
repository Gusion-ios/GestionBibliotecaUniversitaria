public class Docente extends Usuario{

    String especialidad;

    public Docente(int id, String nombre, String correo, String contraseña, boolean sancionado,String especialidad){
        super(id, nombre, correo, contraseña, sancionado);
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