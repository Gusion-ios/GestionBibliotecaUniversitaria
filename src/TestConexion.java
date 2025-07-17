public class TestConexion {
    public static void main(String[] args) {
        if (ConexionDB.obtenerConexion() != null) {
            System.out.println("¡Conexión exitosa a la base de datos!");
        } else {
            System.out.println("No se pudo conectar.");
        }
    }
}
