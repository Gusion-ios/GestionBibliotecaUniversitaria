import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaEstudioDAO {

    // INSERTAR UNA SALA NUEVA
    public void insertar(SalaEstudio sala) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO SalaEstudio (numeroSala, capacidad, disponible) VALUES (?, ?, ?)";

        try {
            conn = ConexionDB.obtenerConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, sala.getNumeroSala());
            ps.setInt(2, sala.getCapacidad());
            ps.setBoolean(3, sala.isDisponible());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar SalaEstudio: " + e.getMessage());
        } finally {
            ConexionDB.cerrarRecursos(conn, ps, null);
        }
    }

    // ACTUALIZAR DISPONIBILIDAD DE UNA SALA
    public void actualizarDisponibilidad(int numeroSala, boolean disponible) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SalaEstudio SET disponible = ? WHERE numeroSala = ?";

        try {
            conn = ConexionDB.obtenerConexion();
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, disponible);
            ps.setInt(2, numeroSala);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar disponibilidad de la sala: " + e.getMessage());
        } finally {
            ConexionDB.cerrarRecursos(conn, ps, null);
        }
    }

    // OBTENER TODAS LAS SALAS
    public List<SalaEstudio> obtenerTodas() {
        List<SalaEstudio> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM SalaEstudio";

        try {
            conn = ConexionDB.obtenerConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int numero = rs.getInt("numeroSala");
                int capacidad = rs.getInt("capacidad");
                boolean disponible = rs.getBoolean("disponible");

                SalaEstudio sala = new SalaEstudio(numero, capacidad, disponible);
                lista.add(sala);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener salas de estudio: " + e.getMessage());
        } finally {
            ConexionDB.cerrarRecursos(conn, ps, rs);
        }

        return lista;
    }

    // ELIMINAR SALA POR NÚMERO (opcional)
    public void eliminarSala(int numeroSala) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM SalaEstudio WHERE numeroSala = ?";

        try {
            conn = ConexionDB.obtenerConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroSala);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar sala: " + e.getMessage());
        } finally {
            ConexionDB.cerrarRecursos(conn, ps, null);
        }
    }
}
