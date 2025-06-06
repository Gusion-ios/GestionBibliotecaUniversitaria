public class Alumno extends Usuario{

    String carrera;
    int semestre;
    public Alumno(int id, String nombre, String correo, String contraseña, String carrera, int semestre){
        super(id, nombre, correo, contraseña);
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

    public void consultarHorario() {
        System.out.println("""
            Su horario es el siguiente:
            ┌────────────┬────────────┬────────────┬────────────┬────────────┐
            │   Hora     │  Lunes     │  Martes    │  Miércoles │  Jueves    │
            ├────────────┼────────────┼────────────┼────────────┼────────────┤
            │ 08:00-09:30│ Matemática │            │ Matemática │            │
            │ 09:30-11:00│ Programación│ Algoritmos│ Programación│ Algoritmos│
            │ 11:00-12:30│            │ Inglés     │            │ Inglés     │
            │ 13:00-14:30│ Física     │            │ Física     │            │
            │ 14:30-16:00│            │ Base de datos│         │ Base de datos│
            └────────────┴────────────┴────────────┴────────────┴────────────┘
            """);
    }


}