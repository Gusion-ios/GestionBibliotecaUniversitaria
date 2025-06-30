public class Alumno extends Usuario{

    private String carrera;
    private int semestre;

    public Alumno(int id, String nombre, String correo, String contraseña, boolean sancionado, String carrera, int semestre){
        super(id, nombre, correo, contraseña, sancionado);
        this.carrera= carrera;
        this.semestre= semestre;
    }

    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

}