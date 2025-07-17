import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private Connection conexion;

    public AlumnoDAO() {
        this.conexion = conexion;
    }

    public void insertarAlumno(Alumno alumno) {
        try {
            // Insertar en tabla Usuario
            String sqlUsuario = "INSERT INTO Usuario (id, nombre, correo, contraseña, sancionado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario);
            psUsuario.setInt(1, (Integer) alumno.getId());
            psUsuario.setString(2, alumno.getNombre());
            psUsuario.setString(3, alumno.getCorreo());
            psUsuario.setString(4, alumno.getContraseña());
            psUsuario.setBoolean(5, alumno.isSancionado());
            psUsuario.executeUpdate();

            // Insertar en tabla Alumno
            String sqlAlumno = "INSERT INTO Alumno (id, carrera, semestre) VALUES (?, ?, ?)";
            PreparedStatement psAlumno = conexion.prepareStatement(sqlAlumno);
            psAlumno.setInt(1, (Integer) alumno.getId());
            psAlumno.setString(2, alumno.getCarrera());
            psAlumno.setInt(3, alumno.getSemestre());
            psAlumno.executeUpdate();

            System.out.println("Alumno insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT u.id, u.nombre, u.correo, u.contraseña, u.sancionado, a.carrera, a.semestre " +
                "FROM Usuario u JOIN Alumno a ON u.id = a.id";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getBoolean("sancionado"),
                        rs.getString("carrera"),
                        rs.getInt("semestre")
                );
                alumnos.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alumnos;
    }

    public Alumno buscarPorCorreo(String correo) {
        String sql = "SELECT u.id, u.nombre, u.correo, u.contraseña, u.sancionado, a.carrera, a.semestre " +
                "FROM Usuario u JOIN Alumno a ON u.id = a.id WHERE u.correo = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getBoolean("sancionado"),
                        rs.getString("carrera"),
                        rs.getInt("semestre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
