import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibroDigitalDAO {

    public static void guardarLibroDigital(LibroDigital libro) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = ConexionDB.obtenerConexion();

            String sql = "INSERT INTO LibroDigital (codigo, titulo, autor, disponible, tamaño, formato, categoria, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, libro.getCodigo());
            stmt.setString(2, libro.getTitulo());
            stmt.setString(3, libro.getAutor());
            stmt.setBoolean(4, libro.isDisponible());
            stmt.setDouble(5, libro.getTamaño());
            stmt.setString(6, libro.getFormato());
            stmt.setString(7, libro.getCategoriaMultimedia().getCategoria());
            stmt.setString(8, libro.getCategoriaMultimedia().getDescripcion());

            stmt.executeUpdate();
            System.out.println("Libro digital guardado en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al guardar el libro digital: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }

    public static List<LibroDigital> obtenerTodos() {
        List<LibroDigital> lista = new ArrayList<>();
        String sql = "SELECT * FROM LibroDigital";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionDB.obtenerConexion();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean disponible = rs.getBoolean("disponible");
                double tamaño = rs.getDouble("tamaño");
                String formato = rs.getString("formato");
                String categoria = rs.getString("categoria");
                String descripcion = rs.getString("descripcion");

                CategoriaMultimedia cat = new CategoriaMultimedia(categoria, descripcion);
                LibroDigital libro = new LibroDigital(codigo, titulo, autor, disponible, tamaño, formato, cat);
                lista.add(libro);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener libros digitales: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return lista;
    }
}
