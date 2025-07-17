import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO Libros (codigo, titulo, autor, disponible, editorial, categoria, descripcion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, libro.getCodigo());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getAutor());
            stmt.setBoolean(4, libro.isDisponible());
            stmt.setString(5, libro.getEditorial());
            stmt.setString(6, libro.getCategoriaMultimedia().getCategoria());
            stmt.setString(7, libro.getCategoriaMultimedia().getDescripcion());

            stmt.executeUpdate();
            System.out.println("Libro guardado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al guardar el libro:");
            e.printStackTrace();
        }
    }

    public List<Libro> obtenerTodos() {
        List<Libro> listaLibros = new ArrayList<>();
        String sql = "SELECT * FROM Libros";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponible = rs.getBoolean("disponible");
                String editorial = rs.getString("editorial");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");

                CategoriaMultimedia cat = new CategoriaMultimedia(categoria, descripcion);
                Libro libro = new Libro(codigo, titulo, autor, disponible, editorial, cat);
                listaLibros.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener libros:");
            e.printStackTrace();
        }

        return listaLibros;
    }
}
