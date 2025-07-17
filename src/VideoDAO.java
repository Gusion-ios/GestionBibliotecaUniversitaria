import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    public void guardarVideo(Video video) {
        String sql = "INSERT INTO Video (codigo, titulo, autor, disponible, duracion, resolucion, categoria, descripcion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, video.getCodigo());
            stmt.setString(2, video.getTitulo());
            stmt.setString(3, video.getAutor());
            stmt.setBoolean(4, video.isDisponible());
            stmt.setInt(5, video.getDuracion());
            stmt.setString(6, video.getResolucion());
            stmt.setString(7, video.getCategoriaMultimedia().getCategoria());
            stmt.setString(8, video.getCategoriaMultimedia().getDescripcion());

            stmt.executeUpdate();
            System.out.println("Video guardado correctamente en la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al guardar el video:");
            e.printStackTrace();
        }
    }

    public List<Video> obtenerTodos() {
        List<Video> listaVideos = new ArrayList<>();
        String sql = "SELECT * FROM Video";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponible = rs.getBoolean("disponible");
                int duracion = rs.getInt("duracion");
                String resolucion = rs.getString("resolucion");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");

                CategoriaMultimedia cat = new CategoriaMultimedia(categoria, descripcion);
                Video video = new Video(codigo, titulo, autor, disponible, duracion, resolucion, cat);
                listaVideos.add(video);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los videos:");
            e.printStackTrace();
        }

        return listaVideos;
    }
}
