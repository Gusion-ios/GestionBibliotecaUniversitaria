import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DispositivoDAO {

    public void guardarOActualizar(Dispositivo dispositivo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionDB.obtenerConexion();

            // Suponemos que si existe el ID, es una actualización
            String sql = "MERGE INTO dispositivos AS target " +
                    "USING (SELECT ? AS id) AS source " +
                    "ON target.id = source.id " +
                    "WHEN MATCHED THEN " +
                    "  UPDATE SET nombre = ?, disponible = ?, tipo = ? " +
                    "WHEN NOT MATCHED THEN " +
                    "  INSERT (id, nombre, disponible, tipo) VALUES (?, ?, ?, ?);";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, dispositivo.getCodigo());
            ps.setString(2, dispositivo.getTipo());
            ps.setBoolean(3, dispositivo.isDisponible());


            ps.setInt(4, dispositivo.getCodigo());
            ps.setString(5, dispositivo.getTipo());
            ps.setBoolean(6, dispositivo.isDisponible());

            ps.executeUpdate();
            System.out.println("[✔] Dispositivo '" + dispositivo.getTipo() + "' sincronizado.");
        } catch (SQLException e) {
            System.err.println("Error al guardar/actualizar dispositivo: " + e.getMessage());
        } finally {
            ConexionDB.cerrarRecursos(conn, ps, null);
        }
    }
}
