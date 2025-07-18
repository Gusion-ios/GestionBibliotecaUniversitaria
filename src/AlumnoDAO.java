import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    private Connection conexion;

    public AlumnoDAO() {
        this.conexion = ConexionDB.obtenerConexion();
    }

    public void insertarAlumno(Alumno alumno) {
        try {
            // 1. Insertar en tabla Usuario (sin el campo id)
            String sqlUsuario = "INSERT INTO Usuario (nombre, correo, contraseña, sancionado) VALUES (?, ?, ?, ?)";
            PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            psUsuario.setString(1, alumno.getNombre());
            psUsuario.setString(2, alumno.getCorreo());
            psUsuario.setString(3, alumno.getContraseña());
            psUsuario.setBoolean(4, alumno.isSancionado());
            psUsuario.executeUpdate();

            // 2. Obtener el ID generado automáticamente
            ResultSet rs = psUsuario.getGeneratedKeys();
            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                alumno.setId(idGenerado);

                // 3. Insertar en tabla Alumno usando ese ID
                String sqlAlumno = "INSERT INTO Alumno (id, carrera, semestre) VALUES (?, ?, ?)";
                PreparedStatement psAlumno = conexion.prepareStatement(sqlAlumno);
                psAlumno.setInt(1, (Integer) alumno.getId());
                psAlumno.setString(2, alumno.getCarrera());
                psAlumno.setInt(3, alumno.getSemestre());
                psAlumno.executeUpdate();

                System.out.println("Alumno insertado correctamente.");
            } else {
                System.out.println("No se pudo obtener el ID generado para el alumno.");
            }
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
