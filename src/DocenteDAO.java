import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {

    private Connection conexion;

    public DocenteDAO() {
        this.conexion = ConexionDB.obtenerConexion();
    }

    public void insertarDocente(Docente docente) {
        try {
            // Insertar en tabla Usuario (sin ID manual)
            String sqlUsuario = "INSERT INTO Usuario (nombre, correo, contraseña, sancionado) VALUES (?, ?, ?, ?)";
            PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            psUsuario.setString(1, docente.getNombre());
            psUsuario.setString(2, docente.getCorreo());
            psUsuario.setString(3, docente.getContraseña());
            psUsuario.setBoolean(4, docente.isSancionado());
            psUsuario.executeUpdate();

            // Obtener ID generado
            ResultSet rs = psUsuario.getGeneratedKeys();
            int idGenerado = -1;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
                docente.setId(idGenerado); // asigna el ID al objeto
            }

            // Insertar en tabla Docente usando el ID generado
            String sqlDocente = "INSERT INTO Docente (id, especialidad) VALUES (?, ?)";
            PreparedStatement psDocente = conexion.prepareStatement(sqlDocente);
            psDocente.setInt(1, idGenerado);
            psDocente.setString(2, docente.getEspecialidad());
            psDocente.executeUpdate();

            System.out.println("Docente insertado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Docente> listarDocentes() {
        List<Docente> docentes = new ArrayList<>();
        String sql = "SELECT u.id, u.nombre, u.correo, u.contraseña, u.sancionado, d.especialidad " +
                "FROM Usuario u JOIN Docente d ON u.id = d.id";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Docente d = new Docente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getBoolean("sancionado"),
                        rs.getString("especialidad")
                );
                docentes.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return docentes;
    }

    public Docente buscarPorCorreo(String correo) {
        String sql = "SELECT u.id, u.nombre, u.correo, u.contraseña, u.sancionado, d.especialidad " +
                "FROM Usuario u JOIN Docente d ON u.id = d.id WHERE u.correo = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Docente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getBoolean("sancionado"),
                        rs.getString("especialidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
