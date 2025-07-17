public class PruebaConexion {
    public static void main(String[] args) {
        CategoriaMultimedia categoria = new CategoriaMultimedia("Podcast", "Audio informativo o educativo");
        Audio audio = new Audio(101, "La historia de Java", "Ana López", true, categoria, 60, "MP3");

        AudioDAO dao = new AudioDAO();
        dao.guardarAudio(audio);
    }
}
