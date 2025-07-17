import java.util.ArrayList;
import java.util.List;

public class MultimediaDAO {

    public List<Multimedia> obtenerTodosLosRecursos() {
        List<Multimedia> todos = new ArrayList<>();

        LibroDAO libroDAO = new LibroDAO();
        AudioDAO audioDAO = new AudioDAO();
        VideoDAO videoDAO = new VideoDAO();
        LibroDigitalDAO libroDigitalDAO = new LibroDigitalDAO();

        // Se asume que cada DAO tiene un método obtenerTodos()
        todos.addAll(libroDAO.obtenerTodos());
        todos.addAll(audioDAO.obtenerTodos());
        todos.addAll(videoDAO.obtenerTodos());
        todos.addAll(libroDigitalDAO.obtenerTodos());

        return todos;
    }

    public void guardarTodosLosRecursos(List<Multimedia> listaMultimedia) {
        for (Multimedia m : listaMultimedia) {
            if (m instanceof Libro) {
                new LibroDAO().insertar((Libro) m);
            } else if (m instanceof Audio) {
                new AudioDAO().guardarAudio((Audio) m);
            } else if (m instanceof Video) {
                new VideoDAO().guardarVideo((Video) m);
            } else if (m instanceof LibroDigital) {
                new LibroDigitalDAO().guardarLibroDigital((LibroDigital) m);
            } else {
                System.out.println("Tipo desconocido de Multimedia: " + m.getClass().getSimpleName());
            }
        }
    }
}
