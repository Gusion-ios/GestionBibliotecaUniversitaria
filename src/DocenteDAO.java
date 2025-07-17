import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {

    Docente docente;
    private Connection conexion;

    public DocenteDAO() {
        this.conexion = conexion;
    }

    public void insertarDocente(Docente docente) {
        try {
            String sqlUsuario = "INSERT INTO Usuario (id, nombre, correo, contraseña, sancionado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psUsuario = conexion.prepareStatement(sqlUsuario);
            psUsuario.setInt(1, (Integer) docente.getId());
            psUsuario.setString(2, docente.getNombre());
            psUsuario.setString(3, docente.getCorreo());
            psUsuario.setString(4, docente.getContraseña());
            psUsuario.setBoolean(5, docente.isSancionado());
            psUsuario.executeUpdate();

            // Insertar en tabla Docente
            String sqlDocente = "INSERT INTO Docente (id, especialidad) VALUES (?, ?)";
            PreparedStatement psDocente = conexion.prepareStatement(sqlDocente);
            psDocente.setInt(1, (Integer) docente.getId());
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
