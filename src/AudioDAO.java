import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AudioDAO {

    public static void guardarAudio(Audio audio) {
        Connection conn = ConexionDB.obtenerConexion();
        String sql = "INSERT INTO Audios (codigo, titulo, autor, disponible, duracion, formato, categoria, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, audio.getCodigo());
            stmt.setString(2, audio.getTitulo());
            stmt.setString(3, audio.getAutor());
            stmt.setBoolean(4, audio.isDisponible());
            stmt.setInt(5, audio.getDuracion());
            stmt.setString(6, audio.getFormato());
            stmt.setString(7, audio.getCategoriaMultimedia().getCategoria());
            stmt.setString(8, audio.getCategoriaMultimedia().getDescripcion());

            stmt.executeUpdate();
            System.out.println("Audio guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el audio:");
            e.printStackTrace();
        }
    }

    public static List<Audio> obtenerTodos() {
        List<Audio> listaAudios = new ArrayList<>();
        String sql = "SELECT * FROM Audios";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponible = rs.getBoolean("disponible");
                int duracion = rs.getInt("duracion");
                String formato = rs.getString("formato");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");

                CategoriaMultimedia cat = new CategoriaMultimedia(categoria, descripcion);
                Audio audio = new Audio(codigo, titulo, autor, disponible, cat, duracion, formato);
                listaAudios.add(audio);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los audios:");
            e.printStackTrace();
        }

        return listaAudios;
    }
}
